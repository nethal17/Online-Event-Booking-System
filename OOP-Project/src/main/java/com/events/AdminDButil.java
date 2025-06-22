package com.events;

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
	
	public static boolean validateUser(String username, String password, String type) {
		try {
				conn = DBConnect.getConnection();
				stmt = conn.createStatement();
			
				String sql = "SELECT * FROM User_Details WHERE Username='"+username+"' AND Password='"+password+"' AND Type='"+type+"'";
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
	
	public static List<Admin> getAdmin(String userName) {
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		try {
			
			conn = DBConnect.getConnection();
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
	
	public static List<Admin> getAdminDetails(String id) {
		
		int convertedID = Integer.parseInt(id);
		
		ArrayList<Admin> admin = new ArrayList<>();
		
		try {
			
			conn = DBConnect.getConnection();
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
	
	public static boolean updateprofile(String id, String username, String name, String email, String phone) {
		
		boolean isSuccess = false;
		
		try {
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			String sql = "update User_Details set Name='"+name+"',Email='"+email+"',Telephone='"+phone+"',Username='"+username+"' "
					+ "where ID='"+id+"'";
			
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
	
public static String getPassword(String id) {
		
		String password = null;
		
		try {
			
			conn = DBConnect.getConnection();
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
			
			conn = DBConnect.getConnection();
			stmt = conn.createStatement();
			
			if (oldPass1.equals(oldPass2)) {
				
				if (newPass1.equals(newPass2)) {
					
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
				
						
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
}
