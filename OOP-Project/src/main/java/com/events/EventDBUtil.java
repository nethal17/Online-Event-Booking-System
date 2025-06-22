package com.events;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDBUtil {
	
	private static boolean isSuccess;
	private static Connection con =null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static boolean addevent(String title, String description, String organizer, String email, String phone, String price, String date) {
		 
		boolean isSuccess = false;		
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql ="insert into Events values(0, '"+title+"', '"+description+"', '"+organizer+"', '"+email+"', '"+phone+"', '"+price+"', '"+date+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Event> getEventDetails(String ID){
		
		
		
		ArrayList<Event> event = new ArrayList<>();
		
		try {
			
			int convertedID = Integer.parseInt(ID);
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from events where id='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String title = rs.getNString(2);
				String description = rs.getNString(3);
				String organizer = rs.getNString(4);
				String email = rs.getNString(5);
				String phone = rs.getNString(6);
				String price = rs.getNString(7);
				String date = rs.getNString(8);
				
				Event e = new Event(id,title,description,organizer,email,phone,price,date);
				event.add(e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return event;
		
	}
	
	
	
	public static List<Integer> getEventIDs() {
	    
	    List<Integer> eventIDs = new ArrayList<>();
	    
	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        
	        String sql = "SELECT event_id FROM events WHERE MONTH(event_date) > 10";
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

	
	public static List<Event> getEventDetails(int id) {
		
		//int convertedID = Integer.parseInt(id);
		
		ArrayList<Event> events = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = " SELECT * FROM events WHERE event_id = '"+id+"' ORDER BY event_id"; 
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
				
				Event evn = new Event(eventID, title, description, organizer, email, phone, price, date);
				
				events.add(evn);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return events;
	}
	
	public static List<Event> getAllEventDetails() {
		
	    List<Event> allEvents = new ArrayList<>();
	    
	    // Get all the PIDs
	    List<Integer> eventIDs = getEventIDs();
	    
	    // For each PID, get the booking details
	    for (int id : eventIDs) {
	        List<Event> eventsForID = getEventDetails(id);
	        allEvents.addAll(eventsForID); // Add all booking details to the main list
	    }
	    
	    return allEvents;
	}
	
	
	public static boolean deleteEvent(String eventID) {
        boolean isSuccess = false;

        try {
            // Establish connection
            con = DBConnect.getConnection();
            stmt = con.createStatement();

            // Create SQL delete query
            String sql = "DELETE FROM events WHERE event_id='" + eventID + "'";

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
	
	public static int getTotalEventsCount() {
        int count = 0;
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT COUNT(*) FROM events";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getUpcomingEventsCount() {
        int count = 0;
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT COUNT(*) FROM events WHERE event_date >= CURDATE()";  // Adjust this if you're using a different date format
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getPastEventsCount() {
        int count = 0;
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT COUNT(*) FROM events WHERE event_date < CURDATE()";  // Adjust this if you're using a different date format
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
	
	

}
