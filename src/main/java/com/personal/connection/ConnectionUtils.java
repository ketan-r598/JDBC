package com.personal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionUtils {

	private static Connection conn;

	static {

		ResourceBundle rb = ResourceBundle.getBundle("db");

		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String password = rb.getString("password");

//		System.out.println(driver);
//		System.out.println(url);
//		System.out.println(user);
//		System.out.println(password);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (conn == null)
			System.out.println("Connection cannot be established");

		return conn;
	}
}