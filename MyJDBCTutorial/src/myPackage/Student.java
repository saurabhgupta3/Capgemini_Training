package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Student {
	public void createDatabase() {
		//1 -> driver load
		//2 -> conn establish
		//3 -> statement create
		//4 -> execute query
		//5 -> close conn
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); //driver load (not needed in modern settings)
			String url = "jdbc:mysql://localhost:3306/";
			String userName = "root";
			String password = System.getenv("DB_PASSWORD"); 

			Connection conn = DriverManager.getConnection(url, userName, password); // conn establish
			System.out.println("connected successfully database");
			
			Statement stm = conn.createStatement(); // statement create
			
			String query = "create database jdbc"; 
			
			stm.execute(query); // execute query
			System.out.println("database created");
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void createTable() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String userName = "root";
			String password = System.getenv("DB_PASSWORD"); 

			Connection conn = DriverManager.getConnection(url, userName, password); // conn establish
			System.out.println("connected successfully database");
			
			Statement stm = conn.createStatement(); // statement create
			
			String query = "create table Student(roll int, name varchar(50), email varchar(50))"; 
			
			stm.execute(query); // execute query
			System.out.println("table created");
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void insertData() {
		try {
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String userName = "root";
			String password = System.getenv("DB_PASSWORD"); 

			Connection conn = DriverManager.getConnection(url, userName, password); // conn establish
			System.out.println("connected successfully database");
			String query = "INSERT INTO student (roll, name, email) values (?, ?, ?, ?)"; 
			PreparedStatement pstm = conn.prepareStatement(query); // statement create
			pstm.setInt(1, 33);
			pstm.setString(2, "Saurabh");
			pstm.setString(3,  "saurabh@gmail.com");
//			stm.execute(query); // execute query
			System.out.println("data inserted");
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
