package it.objectmethod.world.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/world";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		System.out.println("Connecting to database...");
		
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
		return conn;
	}
	
}
