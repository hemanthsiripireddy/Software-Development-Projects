import java.util.ArrayList;
import java.util.List;

public class BusTicketBooking {

}

class User {
	private String mail;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private boolean isAdmin;
	private int age;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(String mail, String password, String firstName, String lastName) {
		super();
		this.mail = mail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String mail, String password, String firstName, String lastName, Gender gender, boolean isAdmin,
			int age) {
		super();
		this.mail = mail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.isAdmin = isAdmin;
		this.age = age;
	}

}

enum Gender {
	Male, Female
}

interface Bus {
	
	public double getPrice();

	public double getRefundPer();

	public List<Seat> getSeats();

	public boolean isFull();
	public int getBusId();
	public int getAvailableSeats();
	public void setAvailableSeats(int value);

}

class NonACSeater implements Bus {
	private int busId;
	private double price;
	private double refundPer;
	private List<Seat> seats;
	private int availableSeats;

	public NonACSeater(int busId, double price, double refundPer) {
		super();
		this.price = price;
		this.busId=busId;
		this.refundPer = refundPer;
		seats = new ArrayList<Seat>();
		availableSeats = 12;
	}

	public int getBusId() {
		return busId;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public double getRefundPer() {
		// TODO Auto-generated method stub
		return refundPer;
	}

	@Override
	public List<Seat> getSeats() {
		// TODO Auto-generated method stub
		return seats;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return availableSeats == 0;
	}

	@Override
	public void setAvailableSeats(int value) {
		// TODO Auto-generated method stub
		this.availableSeats=value;
		
	}

	
	

}

class ACSeater implements Bus {
	private int busId;
	private double price;
	private double refundPer;
	private List<Seat> seats;
	private int availableSeats;

	public ACSeater( int busId,double price, double refundPer) {
		super();
		this.price = price;
		this.busId=busId;
		this.refundPer = refundPer;
		seats = new ArrayList<Seat>();
		availableSeats = 12;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public double getRefundPer() {
		// TODO Auto-generated method stub
		return refundPer;
	}

	@Override
	public List<Seat> getSeats() {
		// TODO Auto-generated method stub
		return seats;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return availableSeats == 0;
	}

	public int getBusId() {
		return busId;
	}

	@Override
	public int getAvailableSeats() {
		// TODO Auto-generated method stub
		return availableSeats;
	}

	@Override
	public void setAvailableSeats(int value) {
		// TODO Auto-generated method stub
		availableSeats=value;
		
	}
	

}

class NonACSleeper implements Bus {
	private int busId;
	private double price;
	private double refundPer;
	private List<Seat> seats;
	private int availableSeats;

	public NonACSleeper(int busId,double price, double refundPer) {
		super();
		this.price = price;
		this.busId=busId;
		this.refundPer = refundPer;
		seats = new ArrayList<Seat>();
		availableSeats = 12;
	}

	public int getBusId() {
		return busId;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public double getRefundPer() {
		// TODO Auto-generated method stub
		return refundPer;
	}

	@Override
	public List<Seat> getSeats() {
		// TODO Auto-generated method stub
		return seats;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return availableSeats == 0;
	}

	@Override
	public int getAvailableSeats() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAvailableSeats(int value) {
		// TODO Auto-generated method stub
		
	}

}

class ACSleeper implements Bus {
	private int busId;
	private double price;
	private double refundPer;
	private List<Seat> seats;
	private int availableSeats;

	public ACSleeper(int busId,double price, double refundPer) {
		super();
		this.price = price;
		this.busId=busId;
		this.refundPer = refundPer;
		seats = new ArrayList<Seat>();
		availableSeats = 12;
	}
	

	public int getBusId() {
		return busId;
	}


	


	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public double getRefundPer() {
		// TODO Auto-generated method stub
		return refundPer;
	}

	@Override
	public List<Seat> getSeats() {
		// TODO Auto-generated method stub
		return seats;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return availableSeats == 0;
	}


	@Override
	public int getAvailableSeats() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setAvailableSeats(int value) {
		// TODO Auto-generated method stub
		
	}

}

class Seat {
	int seatNumber;
	User user;
	public Seat(int seatNumber) {
		super();
		this.seatNumber = seatNumber;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}

class System {
	private static List<User> users;
	private static List<Bus> buses;
	private static User loggedInUser;

	public boolean signUp(String mail, String password, String firstName, String lastName) {

		for (User user : users) {
			if (user.getMail().equals(mail))
				return false;
		}
		User newUser = new User(mail, password, firstName, lastName);
		users.add(newUser);
		return true;
	}

	public boolean login(String mail, String password) {
		for (User user : users) {
			if (user.getMail().equals(mail) && user.getPassword().equals(password)) {
				loggedInUser = user;
				return true;
			}

		}
		return false;

	}

	public boolean logout() {
		loggedInUser = null;
		return true;
	}

	public List<Bus> filer(String SeaterType, String ACType) {
		List<Bus> filteredBuses = new ArrayList<Bus>();
		
			if (SeaterType.equals("Seater")) {
				if (ACType.equals("AC")) {
					for(Bus bus:buses) {
						if(bus.getClass().equals("ACSeater")) {
							filteredBuses.add(bus);
						}
					}

				} else {
					for(Bus bus:buses) {
						if(bus.getClass().equals("NonACSeater")) {
							filteredBuses.add(bus);
						}
					}

				}

			} else {
				if (ACType.equals("AC")) {
					for(Bus bus:buses) {
						if(bus.getClass().equals("ACSleeper")) {
							filteredBuses.add(bus);
						}
					}

				} else {
					for(Bus bus:buses) {
						if(bus.getClass().equals("NonACSleeper")) {
							filteredBuses.add(bus);
						}
					}

				}

			}
			return filteredBuses;
		
	}
	
	public double bookTicket(int busId,List<Integer> seatIds) {
		Bus busToBeBooked=null;
		for(Bus bus:buses) {
			if(bus.getBusId()==busId) {
				busToBeBooked=bus;
				break;
				
			}
				
			
		}
		double price=0;
		
		for(int seatId:seatIds) {
			for(Seat seat:busToBeBooked.getSeats()) {
				if(seat.seatNumber==seatId) {
					seat.user=loggedInUser;
					price+=busToBeBooked.getPrice();
					busToBeBooked.setAvailableSeats(busToBeBooked.getAvailableSeats()+1);
				}
			}
		}
		return price;
	}
	

}
