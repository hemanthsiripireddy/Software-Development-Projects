
package cache;

import java.time.zone.ZoneRulesException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class Cache<KEY, VALUE> {
	final private Map<KEY, Record<VALUE>> map = new ConcurrentHashMap<KEY, Record<VALUE>>();

	final private DataSource<KEY, VALUE> dataSource;
	final private EvictionAlgorithm evictionAlgorithm;
	final private PersistanceAlogorithm persistanceAlogorithm;
	private static final Integer THRESHOLD_SIZE = 500;
	private final Integer expiryTimeInMillis;
	private final Map<Long, List<Record<VALUE>>> expiryQueue;
	private final Map<AccessDetails, List<KEY>> priorityQueue;
	private final ExecutorService threadPool[];
	private final int poolSize;

	public Cache(DataSource<KEY, VALUE> dataSource, EvictionAlgorithm evictionAlgorithm,
			PersistanceAlogorithm persistanceAlogorithm, Integer expiryTimeInSeconds, int poolSize,List<KEY> keys) {

		this.dataSource = dataSource;
		this.evictionAlgorithm = evictionAlgorithm;
		this.persistanceAlogorithm = persistanceAlogorithm;
		this.expiryTimeInMillis = expiryTimeInSeconds;
		this.expiryQueue = new ConcurrentSkipListMap();
		
		this.priorityQueue = new ConcurrentSkipListMap<AccessDetails, List<KEY>>((a, b) -> {
			final int older = (int) (a.getAccessTimestamp() - b.getAccessTimestamp());
			if (evictionAlgorithm.equals(EvictionAlgorithm.LRU)) {
				return older;
			} else {
				return (a.getAccessCount() == b.getAccessCount()) ? older
						: (int) (a.getAccessCount() - b.getAccessCount());
			}
			// return 0;
		});
//		this.priorityQueue = new ConcurrentSkipListMap<AccessDetails, List<Record<VALUE>>>((a,b)->{
//			final int older=(int)a.
//		});
		this.poolSize = poolSize;
		this.threadPool = new ExecutorService[poolSize];
		for (int i = 0; i < poolSize; i++) {
			threadPool[i] = Executors.newSingleThreadExecutor();
		}
		//hot loading
		for(KEY key:keys) {
			dataSource.get(key).thenAccept(value->addToCache(key, value));
		}
	}

	public CompletableFuture<VALUE> get(KEY key) {
		return CompletableFuture.supplyAsync(() -> getInAssignedThread(key), threadPool[key.hashCode() % poolSize])
				.thenCompose(Function.identity());

	}

	public CompletableFuture<Void> set(KEY key, VALUE value) {
//		AccessDetails a=new AccessDetails(0, 0);
//		a.
		return CompletableFuture
				.supplyAsync(() -> setInAssignedThread(key, value), threadPool[key.hashCode() % poolSize])
				.thenCompose(Function.identity());

	}

	public CompletableFuture<Void> setInAssignedThread(KEY key, VALUE value) {

		if (map.containsKey(key)) {
			final var record = map.remove(key);
			expiryQueue.get(record.getLoadTime()).remove(record);
			priorityQueue.get(record.getAccessDetails()).remove(key);
		}
		// Record<VALUE> record = new Record(value);

		if (persistanceAlogorithm.equals(PersistanceAlogorithm.WRITE_THROUGH)) {
			return dataSource.persist(key, value).thenAccept(__ -> addToCache(key, value));

		} else {
			addToCache(key, value);
			dataSource.persist(key, value);
			return CompletableFuture.completedFuture(null);

		}
		// TreeMap<KEY,Record<VALUE>>treeMap=new TreeMap<>();
		// treeMap.firstEntry();
	}

	private Record<VALUE> addToCache(KEY key, VALUE value) {
		if (map.size() >= THRESHOLD_SIZE) {
			// map.put(key, value);
			
			Entry<Long,List<Record<VALUE>>> expiredRecord=expiryQueue.peekFirstEntry();
			while(expiredRecord!=null&&expiredRecord.getKey()<System.currentTimeMillis()-expiryTimeInMillis) {
				expiryQueue.poolFirstEntry();
				final var expiredRecords=expiredRecord.getValue();
				for(Record record:expiredRecords) {
					priorityQueue.get(record.getAccessDetails()).remove(record);
					
				}
				
			}
			if(map.size()>=THRESHOLD_SIZE) {
				final KEY lowPrioritykey=priorityQueue.firstEntry().getValue().stream().findAny();
				Record removedRecord=map.remove(lowPrioritykey);
				expiryQueue.get(removedRecord.getLoadTime()).remove(removedRecord);
				priorityQueue.get(removedRecord.getAccessDetails()).remove(removedRecord);
				
			}

		}
		final var currentTime = System.currentTimeMillis();
		Record<VALUE> record = new Record(value, currentTime);
		expiryQueue.putIfAbsent(currentTime, new CopyOnWriteArrayList<>());
		expiryQueue.get(currentTime).add(record);
		priorityQueue.putIfAbsent(record.getAccessDetails(), new CopyOnWriteArrayList<>());
		priorityQueue.get(record.getAccessDetails()).add(key);
		map.put(key, record);
		return map.get(key);
	}



	public CompletableFuture<VALUE> getInAssignedThread(KEY key) {
		final CompletableFuture<Record<VALUE>> result;

		if (map.containsKey(key)) {
			final var record = map.get(key);
			if (map.get(key).getAccessDetails().getAccessTimestamp() >= System.currentTimeMillis() - expiryTimeInMillis)
				result = CompletableFuture.completedFuture(map.get(key));
			else {
				expiryQueue.get(record.getLoadTime()).remove(record);
				priorityQueue.get(record.getAccessDetails()).remove(record);
				result = dataSource.get(key).thenApply(value -> addToCache(key, value));

			}

		} else {

			result = dataSource.get(key).thenApply(value -> addToCache(key, value));
		}

		return result.thenApply(record -> {
			final AccessDetails accessDetails = record.getAccessDetails();
			priorityQueue.get(accessDetails).remove(record);
			accessDetails.setAccessCount(accessDetails.getAccessCount() + 1);
			accessDetails.setAccessTimestamp(System.currentTimeMillis());

			priorityQueue.putIfAbsent(record.getAccessDetails(), new CopyOnWriteArrayList<>());
			priorityQueue.get(record.getAccessDetails()).add(key);
			return record.getValue();
		});
	}
}
	class Record<VALUE> implements Comparable<Record<VALUE>> {
		private final VALUE value;
		private long loadTime;
		private final AccessDetails accessDetails;

		public Record(VALUE value, long currentTime) {

			this.value = value;
			this.loadTime = currentTime;
			this.accessDetails = new AccessDetails(currentTime, 1);
		}

		@Override
		public int compareTo(Record<VALUE> record) {
			// TODO Auto-generated method stub
			return (int) (this.accessDetails.getAccessTimestamp() - record.accessDetails.getAccessCount());
		}

		public long getLoadTime() {
			return loadTime;
		}

		public void setLoadTime(long loadTime) {
			this.loadTime = loadTime;
		}

		public AccessDetails getAccessDetails() {
			return accessDetails;
		}

		public VALUE getValue() {
			return value;
		}

	}

class AccessDetails {
	private long accessTimestamp;
	private long accessCount;

	public AccessDetails(long accessTimestamp, long accessCount) {
		super();
		this.accessTimestamp = accessTimestamp;
		this.accessCount = accessCount;
	}

	public long getAccessTimestamp() {
		return accessTimestamp;
	}

	public void setAccessTimestamp(long accessTimestamp) {
		this.accessTimestamp = accessTimestamp;
	}

	public long getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}

}