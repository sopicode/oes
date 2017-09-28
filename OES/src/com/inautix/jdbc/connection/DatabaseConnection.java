package com.inautix.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	 	private static String url = "jdbc:oracle:thin:@10.232.71.29:1521:INATP02";    
	    private static String username = "shobana";   
	    private static String password = "shobana";
	    private static Connection con;
	
	    public static Connection getConnection() {
	        try {
	        	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	            try {
	                con = DriverManager.getConnection(url, username, password);
	            } catch (SQLException ex) {
	                // log an exception. fro example:
	                System.out.println("Failed to create the database connection."); 
	            }
	        } catch (SQLException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }

}
