package com.mysql.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class CallStatementTest {

	public static void main(String[] args){
		
		// JDBC driver name and database URL
		   final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "admin";
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try{
			//driver registration
			 Class.forName(JDBC_DRIVER);
			 
			 System.out.println("Connecting to database...");
		     conn = DriverManager.getConnection(DB_URL,USER,PASS);
		     String SQL = "{call getEmpName (?, ?)}";
		     cstmt = conn.prepareCall (SQL);
		     cstmt.setInt("EMP_ID", 1);
		     cstmt.setString("EMP_FIRST", "");
		     cstmt.execute();
		     System.out.println("Employee's name is " + cstmt.getString("EMP_FIRST"));
			

		     
		}catch(SQLException ex){
			System.out.println("Error: " + ex.getErrorCode() + " " + ex.getMessage());
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}finally{
			//finally block used to close resources
		      try{
		         if(cstmt!=null)
		            cstmt.close();
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
