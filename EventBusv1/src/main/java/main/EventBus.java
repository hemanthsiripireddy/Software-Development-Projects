package main;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class EventBus {
    private final Map<String, List<Event>>topics;

    public EventBus(Map<String, List<Event>> topics) {
        this.topics = topics;
    }
}
class Event{
    private final String id;
    private final String name;
    private final Map<String,String> attributes;

    public Event(String id, String name, Map<String, String> attributes) {
        this.id = id;
        this.name = name;
        this.attributes = attributes;
    }
}
abstract class  RetryAlgorithm{
    public abstract void retry(Function<P,R> task,P parameter);
}
class ExponentialBackOff<P,R> extends  RetryAlgorithm{
    private final Timer timer;
    private final int maxAttempts;

    private ExponentialBackOff(int maxAttempts){
        this.maxAttempts=maxAttempts;
        timer=new Timer();
    }

    @Override
    public void retry(Function<P,R> task,P parameter) {
        long currentTime=timer.getTime();
        int attempts=1;
        try{
            task.apply(parameter);
        }
        catch (Exception e){
           if(e.getCause() instanceof  RetryAbleException){
               if(attempts==maxAttempts){
                   throw new RetryLimitExceededException();

               }else {
                   long timeToSleep=waitTimeFactor*1000;
               }

           }
            e.printStackTrace();
        }
    }
}
@Singleton
class Timer{
    public long getTime(){
        return System.nanoTime();
    }
}
class RetryLimitExceededException extends  RuntimeException{

}
class RetryAbleException extends RuntimeException{

}