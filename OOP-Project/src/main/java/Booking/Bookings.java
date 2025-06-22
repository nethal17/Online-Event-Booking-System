package Booking;

public class Bookings {

	int booking_id;
	String email;
	String type;
	String event_date;  
	String event_time; 
	String package_type;
	String hotel_name;
	String add;
	String status;
	String cusid;
	
	public Bookings(int booking_id, String email, String type, String event_date, String event_time,
			String package_type, String hotel_name, String add, String status, String cusid) {
		super();
		this.booking_id = booking_id;
		this.email = email;
		this.type = type;
		this.event_date = event_date;
		this.event_time = event_time;
		this.package_type = package_type;
		this.hotel_name = hotel_name;
		this.add = add;
		this.status = status;
		this.cusid = cusid;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public String getEmail() {
		return email;
	}

	public String getType() {
		return type;
	}

	public String getEvent_date() {
		return event_date;
	}

	public String getEvent_time() {
		return event_time;
	}

	public String getPackage_type() {
		return package_type;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public String getAdd() {
		return add;
	}

	public String getStatus() {
		return status;
	}

	public String getCusid() {
		return cusid;
	}

	
	
	
	
}