package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		Student st = new Student();
//		st.createDatabase();
		
//		st.createTable();
		st.insertData();
		
		
	}
}
