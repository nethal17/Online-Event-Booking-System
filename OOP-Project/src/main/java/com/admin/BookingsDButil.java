package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingsDButil {

	private static boolean isSuccess;
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static boolean deleteBooking(String id) {
		
		//int convID = Integer.parseInt(id);
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
				
			String sql = "DELETE FROM Event_Bookings WHERE Booking_ID='"+id+"'";
			int rs = stmt.executeUpdate(sql);
				
			if (rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Integer> getBookingIDs() {
	    
	    List<Integer> bookingIDs = new ArrayList<>();
	    
	    try {
	        conn = DBconnect.getConnection();
	        stmt = conn.createStatement();
	        
	        String sql = "SELECT Booking_ID FROM Event_Bookings ORDER BY Booking_ID ASC";
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int bookingID = rs.getInt("Booking_ID");
	            bookingIDs.add(bookingID);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return bookingIDs;
	}

	
	public static List<EventBooking> getBookingDetails(int id) {
		
		//int convertedID = Integer.parseInt(id);
		
		ArrayList<EventBooking> book = new ArrayList<>();
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = " SELECT * FROM Event_Bookings WHERE Booking_ID = '"+id+"' "; 
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int bookingID = rs.getInt(1);
				String email = rs.getString(2);
				String eventType = rs.getString(3);
				String eventDate = rs.getString(4);
				String eventTime = rs.getString(5);
				String pkgType = rs.getString(6);
				String hotelName = rs.getString(7);
				String additionalReq = rs.getString(8);
				String bookingStatus = rs.getString(9);
				int cusID = rs.getInt(10);
				
				
				EventBooking bk = new EventBooking(bookingID, email, eventType, eventDate, eventTime, pkgType, hotelName, additionalReq, bookingStatus, cusID);
				
				book.add(bk);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public static List<EventBooking> getAllBookingDetails() {
		
	    List<EventBooking> allBookings = new ArrayList<>();
	    
	    // Get all the PIDs
	    List<Integer> bookingIDs = getBookingIDs();
	    
	    // For each PID, get the booking details
	    for (int id : bookingIDs) {
	        List<EventBooking> bookingsForID = getBookingDetails(id);
	        allBookings.addAll(bookingsForID); // Add all booking details to the main list
	    }
	    
	    return allBookings;
	}
	
	public static String getBookingStatus(String id) {
		
		String status = null;
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT Booking_Status FROM Event_Bookings WHERE Booking_ID='"+id+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				status = rs.getString("Booking_Status");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static boolean approveEventBooking(String pid) {
		
		String bookingStatus = getBookingStatus(pid);
		String status1 = "Pending";
		String status2 = "Approved";
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			if (bookingStatus.equals("Pending")) {
				
				String sql = "UPDATE Event_Bookings SET Booking_Status='"+status2+"'" + "WHERE Booking_ID='"+pid+"' ";
				int rs = stmt.executeUpdate(sql);
				
				if (rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
			else {
				
				String sql = "UPDATE Event_Bookings SET Booking_Status='"+status1+"'" + "WHERE Booking_ID='"+pid+"' ";
				int rs = stmt.executeUpdate(sql);
				
				if (rs > 0) {
					isSuccess = true;
				}
				else {
					isSuccess = false;
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
}
