package com.tap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class day1 {

	public static void main(String[] args) {
		Connection connection =null;
		Statement state= null;
		ResultSet res=null;
		
      String url="jdbc:mysql://localhost:3306/jdbcprogram";
     String username ="root";
     String password="Hari99@#";
    
     
      try {
		 connection = DriverManager.getConnection(url, username, password);
		 disply(connection,state,res);
		 
	} 
      catch (SQLException e) {
		e.printStackTrace();
	  }
      finally {
    	  close(connection, state, res);
    	  
      }
	}
	
	
	public static void disply(Connection connection, Statement statement, ResultSet res)throws SQLException {
		 String SQl="SELECT * from employee";
		 statement= connection.createStatement();
		  res=statement.executeQuery(SQl);
		  System.out.println("-------------------------");
		 while(res.next()) {
			 int id=res.getInt("id");
			 String name=res.getString("name");
			 String dept=res.getString("dept");
			 
			 System.out.printf("|%-3d | %8s |  %-4s | \n", id, name,dept);
		 }
		  System.out.println("-------------------------");

	}

	private static void close(Connection connection, Statement state, ResultSet res) {
		try {
			if(res!=null) {
				res.close();
			}
  			
  		} 
      	  catch (SQLException e) {
  			e.printStackTrace();
  		}
    	 
    	  try {
    		  if(state !=null) {
    			  state.close(); 
    		  }
		} 
    	  catch (SQLException e) {
			e.printStackTrace();
		}
    	  try {	
    		  if(connection!=null) {
    			  connection.close();
    		  }
  		} 
      	  catch (SQLException e) {
  			e.printStackTrace();
  		}
	}

}