package com.events;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static String url = "jdbc:mysql://localhost:3306/OOP";
	private static String userName = "root";
	private static String password = "Nethal@1005";
	
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch(Exception e) {
			System.out.println("Database Connection is not Success");
		}
		
		return con;
	}

}
