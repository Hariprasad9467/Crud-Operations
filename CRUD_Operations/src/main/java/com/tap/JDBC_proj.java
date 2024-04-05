package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.tap1.day1;

public class JDBC_proj {
    private static  Scanner scan= new Scanner(System.in);
	private static String url="jdbc:mysql://localhost:3306/jdbc_project";
	private static String user="root";
	private static String pass="Hari99@#";
	
	public static void main(String[] args) {
	
	 
	  System.out.println("Enter the number : ");
	  System.out.println("1. Select Query : ");
	  System.out.println("2. Update Query :");
	  System.out.println("3. Delete Query :");
	  System.out.println("4. Insert Query :");


	   int input = scan.nextInt();
	   if(input==1) {
		   selectQuery();
	   }
	   else if(input==2) {
		   updateQuery();
	   }
	   else if(input==3)
	   {
		   deleteQuary();
	   }
	   else if(input==4) {
		   insertQuery();
	   }
	   else {
		   System.out.println("Enter valid Number...?");
	   }
	   
	  
		
	}
		//Insert Query
	public static void insertQuery() {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement("insert into `employee`(id, name, dept) values(?, ?, ?)");
			System.out.println("Enter the id :");
			st.setInt(1, scan.nextInt());
			System.out.println("Enter the name :");
			st.setString(2, scan.next());
			System.out.println("Enter the department :");
			st.setString(3, scan.next());
			int res = st.executeUpdate();
			System.out.println(res);
			day1.disply(con, st, null);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//delete Quary
     public static void deleteQuary() {
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement("delete from `employee` where `id`=? ");
			System.out.println("Enter the id :");
			st.setInt(1, scan.nextInt());
			int res=st.executeUpdate();
			System.out.println(res);
			day1.disply(con, st, null);
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	//Update Query
	public static void updateQuery() {
		
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st = con.prepareStatement("update `employee` set `dept`=? where `id`=?");
			System.out.println("Enter the dept :");
			st.setString(1, scan.next());
			System.out.println("Enter the id");
			st.setInt(2, scan.nextInt());
			int res =st.executeUpdate();
			System.out.println(res);
			day1.disply(con, st, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	// SelectQuery
	  public static void selectQuery() {
		  
		  try {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st =con.createStatement();
			ResultSet res = st.executeQuery("select *from employee");
			System.out.println(res);
			day1.disply(con, st, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	 }
	
}
