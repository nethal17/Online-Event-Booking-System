package com.admin;

public class EventBooking {

		private int bookingID;
		private String email;
		private String eventType;
		private String eventDate;
		private String eventTime;
		private String packageType;
		private String hotelName;
		private String requirements;
		private String bookingStatus;
		private int cusID;
		
	
		public EventBooking(int bookingID, String email, String eventType, String eventDate, String eventTime,
				String packageType, String hotelName, String requirements, String bookingStatus, int cusID) {
			super();
			this.bookingID = bookingID;
			this.email = email;
			this.eventType = eventType;
			this.eventDate = eventDate;
			this.eventTime = eventTime;
			this.packageType = packageType;
			this.hotelName = hotelName;
			this.requirements = requirements;
			this.bookingStatus = bookingStatus;
			this.cusID = cusID;
		}


		public int getBookingID() {
			return bookingID;
		}


		public String getEmail() {
			return email;
		}


		public String getEventType() {
			return eventType;
		}


		public String getEventDate() {
			return eventDate;
		}


		public String getEventTime() {
			return eventTime;
		}


		public String getPackageType() {
			return packageType;
		}


		public String getHotelName() {
			return hotelName;
		}


		public String getRequirements() {
			return requirements;
		}


		public String getBookingStatus() {
			return bookingStatus;
		}


		public int getCusID() {
			return cusID;
		}

}
