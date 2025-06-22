package Booking;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CustomerDBUTIL {
	
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	/*------------------------------------------------------*/
	
	public static boolean validateUser(String username, String password, String type) {
		try {
				con = DBConnect.getConnectin();
				stmt = con.createStatement();
			
				String sql = "SELECT * FROM user_details WHERE Username='"+username+"' AND Password='"+password+"' AND Type='"+type+"'";
				rs = stmt.executeQuery(sql);
			
				if (rs.next()) {
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
	
	
	/*--------------------------------------------------*/
	
	public static List<Customer> validate(String username,String password) {
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		try {						
			 con = DBConnect.getConnectin();
			 stmt = con.createStatement();
			
			String sql = "select * from user_details where Username='"+username+"' and Password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
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
	
	public static List<Customer> getCustomer(String userName) {
		
		ArrayList<Customer> customer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnectin();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM User_details WHERE Username='"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next() == true) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String type = rs.getString(5);
				String username = rs.getString(6);
				String password = rs.getString(7);
				
				Customer cus = new Customer(id, name, email, phone, type, username, password);
				
				customer.add(cus);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	
	    /*----------update customer-----------*/
	public static boolean updatecustomer(String id, String name, String email, String telephone, String userName) {
		
		try {
			
			con = DBConnect.getConnectin();
			stmt = con.createStatement();
			
			String sql ="update User_Details set Name='"+name+"', Email='"+email+"',Telephone='"+telephone+"',UserName='"+userName+"'"
					+"where ID='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------*/
	
	
	public static List<Integer> getBookingIDs() {
		
		int cusID = 1;
	    
	    List<Integer> bookingIDs = new ArrayList<>();
	    
	    try {
	    	con = DBConnect.getConnectin();
			stmt = con.createStatement();
	        
	        String sql = "SELECT booking_id FROM event_table WHERE CusID = '"+cusID+"'";
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int id = rs.getInt("booking_id");
	            bookingIDs.add(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return bookingIDs;
	    
	    
	}

	
	public static List<Bookings> getBookingtDetails(int id) {
		
		//int convertedID = Integer.parseInt(id);
		
		ArrayList<Bookings> bookings = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnectin();
			stmt = con.createStatement();
			
			String sql = " SELECT * FROM event_table WHERE Booking_ID = '"+id+"'"; 
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				int booking_id = rs.getInt(1); 				 
				String email = rs.getString(2);
				String type = rs.getString(3);				
				String event_date = rs.getString(4);
				String event_time = rs.getString(5);
				String package_type = rs.getString(6);
				String hotel_name = rs.getString(7); 
				String add = rs.getString(8);
				String status = rs.getString(9);
				String cusId = rs.getString(10);
				
				Bookings book = new Bookings (booking_id, email,type, event_date, event_time, package_type, hotel_name,add, status, cusId);
				
				bookings.add(book);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return bookings;
	}
	
	public static List<Bookings> getAllBookingDetails() {
		
	    List<Bookings> allBookings = new ArrayList<>();
	    
	    // Get all the PIDs
	    List<Integer> bookingIDs = getBookingIDs();
	    
	    // For each PID, get the booking details
	    for (int id : bookingIDs) {
	        List<Bookings> eventsForID = getBookingtDetails(id);
	        allBookings.addAll(eventsForID); // Add all booking details to the main list
	    }
	    
	    return allBookings;
	}
	
	
	/*----------------------------------update password-------------------------------------------------*/
	
public static String getPassword(String id) {
		
		String password = null;
		
		try {
			
			con = DBConnect.getConnectin();
			stmt = con.createStatement();
			
			String sql = "SELECT Password FROM User_Details WHERE ID='"+id+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				password = rs.getString("Password");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return password;
	}
	
	
	public static boolean changePassword(String id, String oldPass1, String newPass1, String newPass2) {
		
		String oldPass2 = getPassword(id);
		
		try {
			
			con = DBConnect.getConnectin();
			stmt = con.createStatement();
				
			if (oldPass1.equals(oldPass2) && newPass1.equals(newPass2)) {
					
					String sql = "UPDATE User_Details SET Password = '"+newPass1+"'" + "WHERE ID='"+id+"' ";
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
	
	public static boolean deleteprofile(String id) {
		
		int convId = Integer.parseInt(id);
		
		try {
			con = DBConnect.getConnectin();
			stmt = con.createStatement();
			
			String sql = "delete from user_details where ID='"+convId+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				isSuccess = true;
				
			}
			else {
				
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}
