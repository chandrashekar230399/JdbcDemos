package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecord {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root",
					"marolix@2023");
 
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter eid,name,password,email,mobile_no,and address values");

			int eid = sc.nextInt();
			String name = sc.next();
			String password = sc.next();
			String email = sc.next();
			String mobile_no = sc.next();
			String address = sc.next();
           //for delete we have to apply only one row is enough
			PreparedStatement ps = con.prepareStatement(
					//to insert record
					"INSERT INTO employee(eid,name,password,email,mobile_no,address) VALUES (?,?,?,?,?,?)");
					//to update record
					//"update employee set name=?,password=?,email=?,mobile_no=?,address=? where eid=?");
					//to delete record
					//"delete from employee where eid=?");
			
			//this is to insert 
			ps.setInt(1, eid);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setString(5, mobile_no);
			ps.setString(6, address);
			
			//this is to update
//			ps.setString(1,name);
//			ps.setString(2,password);
//			ps.setString(3,email);
//			ps.setString(4,mobile_no);
//			ps.setString(5,address);
//			ps.setInt(6, eid);
			
			//this is to delete
			//ps.setInt(1, eid);
			
			
			int i = ps.executeUpdate();

			System.out.println(i + "===Inserted New Record===");
			//System.out.println(i+"===Record updated===");
			//System.out.println(i+"===Deleted Record Sucessfully===");
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
