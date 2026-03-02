package com.dk.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUser("root");
		ds.setPassword(System.getenv("DB_PASSWORD"));
		ds.setUrl("jdbc:mysql://localhost:3306/company_db");
		
		try {
			connection = ds.getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}


