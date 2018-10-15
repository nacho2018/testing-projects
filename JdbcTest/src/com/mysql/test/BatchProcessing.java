package com.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {

	 
	   
	public static void main(String[] args){
		
		// JDBC driver name and database URL
		   final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "admin";
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			//driver registration
			 Class.forName(JDBC_DRIVER);
			 
			 System.out.println("Connecting to database...");
		     conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			// Create statement object
		     stmt = conn.createStatement();

		     // Set auto-commit to false
		     conn.setAutoCommit(false);

		     // Create SQL statement
		     String SQL = "INSERT INTO employees (id, first_name, last_name) " +
		                  "VALUES(4,'Zia', 'Ali')";
		     // Add above SQL statement in the batch.
		     stmt.addBatch(SQL);

		     // Create one more SQL statement
		     SQL = "INSERT INTO employees (id, first_name, last_name) " +
		                  "VALUES(5,'Raj', 'Kumar')";
		     // Add above SQL statement in the batch.
		     stmt.addBatch(SQL);

		     // Create one more SQL statement
		     SQL = "UPDATE employees SET last_name = 'Salted' " +
		                  "WHERE id = 1";
		     // Add above SQL statement in the batch.
		     stmt.addBatch(SQL);

		     // Create an int[] to hold returned values
		     int[] count = stmt.executeBatch();
		     System.out.println("\n\nNumber of queries in batch: " + count.length);

		     //Explicitly commit statements to apply changes
		     conn.commit();
		}catch(SQLException ex){
			System.out.println("Error: " + ex.getErrorCode() + " " + ex.getMessage());
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}finally{
			//finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){}
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		}
		
}

