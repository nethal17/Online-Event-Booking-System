package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	
	private static String url = "jdbc:mysql://localhost:3306/OOP"; // file path where project is resides
	private static String username = "root"; // username
	private static String password = "Nethal@1005"; // password
	private static Connection conn;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, username, password);
			
		}
		catch (Exception e) { // if unexpected error occur, display an error message
			System.out.println("Connection Unsuccessful!");
		}
		
		return conn;
		
	}

}
