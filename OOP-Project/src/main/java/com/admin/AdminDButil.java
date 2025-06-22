package com.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDButil {
	
	private static boolean isSuccess;
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// method for return account type, if username was given
	public static String getAccountType(String username) {
		
		String accType = null;
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			// sql query for retrive user details from the User_Details table
			String sql = "SELECT Type FROM User_Details WHERE Username='"+username+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				accType = rs.getString("Type");
			}
			
		}
		// if any error occurs print the error
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return accType;
	}
	
	// method for validate user from the database, if username and password was entered
	public static int validateUser(String username, String password) {
		
		int numForType = 0;
		String accType = getAccountType(username);
		
		try {
				conn = DBconnect.getConnection();
				stmt = conn.createStatement();
				
				if (accType.equals("Admin"))
				{
					String sql = "SELECT * FROM User_Details WHERE Username='"+username+"' AND Password='"+password+"' ";
					rs = stmt.executeQuery(sql);
				
					if (rs.next()) {
						numForType = 1;
					}
					/*else {
						numForType = 0;
					}*/
				}
				else if (accType.equals("Customer"))
				{
					String sql = "SELECT * FROM User_Details WHERE Username='"+username+"' AND Password='"+password+"' ";
					rs = stmt.executeQuery(sql);
				
					if (rs.next()) {
						numForType = 2;
					}
					/*else {
						numForType = 0;
					}*/
				}
				else if (accType.equals("Organizer"))
				{
					String sql = "SELECT * FROM User_Details WHERE Username='"+username+"' AND Password='"+password+"' ";
					rs = stmt.executeQuery(sql);
				
					if (rs.next()) {
						numForType = 3;
					}
					/*else {
						numForType = 0;
					}*/
				}
				else if (accType.equals("Vendor"))
				{
					String sql = "SELECT * FROM User_Details WHERE Username='"+username+"' AND Password='"+password+"' ";
					rs = stmt.executeQuery(sql);
				
					if (rs.next()) {
						numForType = 4;
					}
					/*else {
						numForType = 0;
					}*/
				}
					
			
				
			}
		
			catch (Exception e) {
				e.printStackTrace();
			}
		
			return numForType;
	}
	
	public static List<Admin> getAdmin(String userName) {
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
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
				
				Admin adm = new Admin(id, name, email, phone, type, username, password);
				
				admin.add(adm);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}
	
	// method for get admin details from the User_Details table
	public static List<Admin> getAdminDetails(String id) {
		
		int convertedID = Integer.parseInt(id);
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM User_Details WHERE id='"+convertedID+"'"; 
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int ID = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String type = rs.getString(5);
				String username = rs.getString(6);
				String password = rs.getString(7);
				
				Admin adm = new Admin(ID, name, email, phone, type, username, password);
				admin.add(adm);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}
	
	public static boolean insertDetails(String name, String email, String phone, String type, String username, String password) {
		
		isSuccess = false;
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO User_Details VALUES (0, '"+name+"', '"+email+"', '"+phone+"', '"+type+"', '"+username+"', '"+password+"')";
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
	
	public static boolean updateAdminDetails(String id, String name, String email, String phone, String username) {
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = "UPDATE User_Details SET Name='"+name+"', Email='"+email+"', Telephone='"+phone+"', Username='"+username+"'" + "WHERE id='"+id+"' ";
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
	
	public static String getPassword(String id) {
		
		String password = null;
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
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
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
				
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
	
	public static List<Integer> getUserIDs() {
	    
	    List<Integer> userIDs = new ArrayList<>();
	    
	    try {
	        conn = DBconnect.getConnection();
	        stmt = conn.createStatement();
	        
	        String sql = "SELECT ID FROM User_Details WHERE Type NOT IN('Admin') ORDER BY ID ASC";
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int id = rs.getInt("ID");
	            userIDs.add(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return userIDs;
	}

	
	public static List<Admin> getUserDetails(int id) {
		
		//int convertedID = Integer.parseInt(id);
		
		ArrayList<Admin> user = new ArrayList<>();
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
			
			String sql = " SELECT * FROM User_Details WHERE ID = '"+id+"' "; 
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int ID = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String telephone = rs.getString(4);
				String type = rs.getString(5);
				String username = rs.getString(6);
				String password = rs.getString(7);
				
				Admin newUser = new Admin(ID, name, email, telephone, type, username, password);
				
				user.add(newUser);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static List<Admin> getAllUserDetails() {
		
	    List<Admin> allDetails = new ArrayList<>();
	    
	    // Get all the PIDs
	    List<Integer> userIDs = getUserIDs();
	    
	    // For each PID, get the booking details
	    for (int id : userIDs) {
	        List<Admin> detailsForID = getUserDetails(id);
	        allDetails.addAll(detailsForID); // Add all booking details to the main list
	    }
	    
	    return allDetails;
	}
	
	public static boolean deleteUserAccount(String id) {
		
		try {
			
			conn = DBconnect.getConnection();
			stmt = conn.createStatement();
				
			String sql = " DELETE FROM User_Details WHERE ID='"+id+"' ";
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
	


