package Booking;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnect {

	private static String url = "jdbc:mysql://localhost:3306/OOP";
	private static String username = "root";
	private static String password = "Nethal@1005";
	private static Connection con;
	
	public static Connection getConnectin() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = (Connection) DriverManager.getConnection(url,username,password);
		}
		catch(Exception e){
			System.out.println("Database connection is not successfull !");
		}
		
		return con;
	}
	
}
