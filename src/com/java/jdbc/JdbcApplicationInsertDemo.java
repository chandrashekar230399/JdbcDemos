package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApplicationInsertDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "marolix@2023");
			Statement st = c.createStatement();

			String s = "create schema jdbc_demo";
			String s1 = "use jdbc_demo";
			String s2 = "create table student(std_id int,std_name varchar(30))";
			String s3 ="insert into  student values(3,\"rajesh\"),(4,\"vamsi\")";
			boolean b = st.execute(s1);
			int a = st.executeUpdate(s3); 
			System.out.println(a);
			System.out.println(b);

			System.out.println("inserted record sucessfully.......");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
