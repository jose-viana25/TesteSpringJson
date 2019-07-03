package br.com.telefonica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager instance;
	
	private String user = "sa";
	private String password = "";	
	private String dbUrl = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=sqlexpress";

	private Connection connection;
	
	private ConnectionManager() {
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			new DaoException();
			e.printStackTrace();
		}
	}
	
	public static ConnectionManager getInstance() {
		return instance == null ? new ConnectionManager() : instance;
	}
	
	public Connection getConnection() {
		
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(user,password,dbUrl);
			} catch (SQLException e) {
				new DaoException();
				e.printStackTrace();
			}
		}
		
		return connection;
		
	}

}
