package com.events;

public class Bookings {

		private int pid;
		private String eventType;
		private String eventDate;
		private String packageType;
		
		public Bookings(int pid, String eventType, String eventDate, String packageType) {
			this.pid = pid;
			this.eventType = eventType;
			this.eventDate = eventDate;
			this.packageType = packageType;
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
		
}
