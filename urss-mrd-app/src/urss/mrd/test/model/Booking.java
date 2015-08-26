package urss.mrd.test.model;


public class Booking {
	// {"date":"1234567890", "room":"A06", "reserver":"AlexPopescu"}
	private long date;

	private String room;

	private String reserver;
	
	private String subject;
	
	public Booking(String room, String reserver, String subject, long date) {
		this.room = room;
		this.reserver = reserver;
		this.date = date;
		this.subject = subject;
	}
	
	public Booking() {
	
	}
	
	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getReserver() {
		return reserver;
	}

	public void setReserver(String reserver) {
		this.reserver = reserver;
	}

}
