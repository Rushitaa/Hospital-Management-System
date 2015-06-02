package com.hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnManager {
	static Connection connection;
	public static Connection getConnection()
	{
		ResourceBundle rBundle=ResourceBundle.getBundle("jdbc");
		try
		{
			String driver=rBundle.getString("driver");
			String url=rBundle.getString("url");
			String user=rBundle.getString("user");
			String password=rBundle.getString("password");
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
	
