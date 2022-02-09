package com.revature.stacklite.dl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory 
{
	//eager loading - you create instance of connectionFactory as soon as program starts
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	//hold db config stuff
	private Properties prop = new Properties();
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	//force load postgreSQL driver
	//static members of a class get loaded into mem at start of prog runtime
	//static blocks get run at the start
	static 
	{
		try
		{
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}	
	
	// singletons are characterized by the private constructor
	private ConnectionFactory()
	{
		//loading properties file that contains db config
		try 
		{		
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			prop.load(loader.getResourceAsStream("db.properties"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			logger.error("Can't find db.props file");
		}
	}
	
	//as well as get instance method
	public static ConnectionFactory getInstance()
	{
		//lazy loading - create instance of connectioFactory the first time you call it
		//if (connectionFactory == null) connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	//factories are characterized by some method that contains logic for one connection method
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Can't get connection");
		}
		return conn;
	}
}
