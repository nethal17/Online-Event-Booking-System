package Booking;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUTIL {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	 public static boolean insertBooking(String email, String type, String event_date, String time, String package_type, String hotel_name, String additional, String status, String cusID) {
		 
		 boolean isSuccess = false;		     
		    
		    try {
		    	con = DBConnect.getConnectin();
		    	stmt = con.createStatement();		
		    	
		    	String sql = "INSERT INTO Event_Bookings VALUES (0,'"+email+"', '"+type+"', '"+event_date+"', '"+time+"', '"+package_type+"', '"+hotel_name+"', '"+additional+"', '"+status+"', '"+cusID+"')";
				
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;	
				} else {
					isSuccess = false;
				}
		    	
		    }
		    
		    catch(Exception e) {
		    	e.printStackTrace();
		    }
		 
		 return isSuccess;
		 
	 }
	 
	 //read
	 
	 public static List<Customer> getCustomerDetails(String Id){
		 
		 int convertedID = Integer.parseInt(Id);
		 
		 ArrayList<Customer> cus = new ArrayList<>();
		 
		 try {
			 
			 con = DBConnect.getConnectin();
			 stmt = con.createStatement();
			 
			 String sql = "select * from user_details where id='"+convertedID+"'";
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 
				 int ID = rs.getInt(1);
				 String Name = rs.getString(2);
				 String Email = rs.getString(3);
				 String Telephone = rs.getString(4);
				 String Type = rs.getString(5);
				 String UserName = rs.getString(6);
				 String Password = rs.getString(7);
				 
				 Customer c = new Customer(ID,Name,Email,Telephone,Type,UserName,Password); 
				 cus.add(c);
			 }
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return cus;
	 }
	    
	    

}
