package com.almaviva.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMysql 
{
	private final String username = "root";
	private final String password = "Alex6630";
	private final String url = "jdbc:mysql://localhost:3306/db_user";
	
	private Connection conn =null;
	
	public Connection openConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Driver Non Trovati");
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			System.out.println("errore sql");
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection conn)
	{
		try 
		{
			if (!conn.isClosed())
			{
				conn.close();
			}
		} 
		catch (SQLException e) 
		{
			System.err.println("errore chiusura");
			e.printStackTrace();
		}
	}
	
}
