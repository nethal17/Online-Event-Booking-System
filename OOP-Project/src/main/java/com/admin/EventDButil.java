package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDButil {
	
	private static boolean isSuccess;
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Integer> getEventIDs() {
	    
	    List<Integer> eventIDs = new ArrayList<>();
	    
	    try {
	        conn = DBconnect.getConnection();
	        stmt = conn.createStatement();
	        
	        String sql = "SELECT Event_ID FROM Events";
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int id = rs.getInt("event_id");
	            eventIDs.add(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return eventIDs;
	}

	
	public static List<Events> getEventDetails(int id) {
		
		//int convertedID = Integer.parseInt(id);
		
		ArrayList<Events> events = new ArrayList<>();
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = " SELECT * FROM Events WHERE Event_ID = '"+id+"' ORDER BY Event_ID"; 
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int eventID = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				String organizer = rs.getString(4);
				String email = rs.getString(5);
				String phone = rs.getString(6);
				String price = rs.getString(7);
				String date = rs.getString(8);
				
				Events evn = new Events(eventID, title, description, organizer, email, phone, price, date);
				
				events.add(evn);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return events;
	}
	
	public static List<Events> getAllEventDetails() {
		
	    List<Events> allEvents = new ArrayList<>();
	    
	    // Get all the PIDs
	    List<Integer> eventIDs = getEventIDs();
	    
	    // For each PID, get the booking details
	    for (int id : eventIDs) {
	        List<Events> eventsForID = getEventDetails(id);
	        allEvents.addAll(eventsForID); // Add all booking details to the main list
	    }
	    
	    return allEvents;
	}
	
	public static boolean deleteEvent(String eventID) {
        boolean isSuccess = false;

        try {
            // Establish connection
            conn = DBconnect.getConnection();
            stmt = conn.createStatement();

            // Create SQL delete query
            String sql = "DELETE FROM Events WHERE Event_ID='" + eventID + "'";

            // Execute the delete query
            int result = stmt.executeUpdate(sql);

            // If result is greater than 0, the deletion was successful
            if (result > 0) {
                isSuccess = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources here (optional, if you're using connection pooling)
        }

        return isSuccess;
    }
	
	
	public static boolean addInquery(String name, String email, String phone, String subject, String message) {
		
		isSuccess = false;
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO Contact_Us VALUES (0, '"+name+"', '"+email+"', '"+phone+"', '"+subject+"', '"+message+"')";
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
}
