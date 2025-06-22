package com.admin;

// Bookings model class
public class Bookings {

		private int pid;
		private String eventType;
		private String eventDate;
		private String packageType;
		private int cusID;
		private String bookingStatus;
		
		public Bookings(int pid, String eventType, String eventDate, String packageType, String bookingStatus) {
			this.pid = pid;
			this.eventType = eventType;
			this.eventDate = eventDate;
			this.packageType = packageType;
			this.bookingStatus = bookingStatus;
		}

		public int getPid() {
			return pid;
		}

		public String getEventType() {
			return eventType;
		}

		public String getEventDate() {
			return eventDate;
		}

		public String getPackageType() {
			return packageType;
		}
		
		public String getBookingStatus() {
			return bookingStatus;
		}
		
		public int getCusID() {
			return cusID;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}

		public void setPackageType(String packageType) {
			this.packageType = packageType;
		}

		public void setCusID(int cusID) {
			this.cusID = cusID;
		}

		public void setBookingStatus(String bookingStatus) {
			this.bookingStatus = bookingStatus;
		}
		
		
		
}
