package controller;

import java.sql.*;

/**
 * @authors Maria Alejandra Reyes Gonzalez, Maria José Villalba Lozano, Cesar David Salamanca Martinez
 *
 */

public class DataSource  
{
	private String bd = "test";
	private String usr = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost:3306/" + bd;
	private Connection cnn;
	private static DataSource dataSource = null;

	public Connection getCnn()
	{
		return cnn;
	}

	public void setCnn(Connection con)
	{
		cnn = con;
	}

	public void conectar()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			cnn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("Successful connection");
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			System.out.println("No se pudo conectar a la base de datos");
		}
	}

	public static DataSource getInstance()
	{
		if(dataSource != null)
		{
			dataSource = new DataSource();	
		}
		return dataSource;
	}

	public ResultSet runQuery(String sql)
	{
		ResultSet resultSet = null;
		try
		{
			Statement statement = cnn.createStatement();
			resultSet = statement.executeQuery(sql);
			System.out.println("Successful query: "+sql);
		} 
		catch (SQLException e) 
		{
			System.out.println("Query error: "+e.getMessage());
		}
		return resultSet;
	}

	public boolean runUpdateQuery(String sql)
	{
		@SuppressWarnings("unused")
		int rows=0;
		try 
		{
			Statement statement = cnn.createStatement();
			rows = statement.executeUpdate(sql);
			System.out.println("Successful query: "+sql);
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.println("Query error: "+e.getMessage());
			return false;
		}
	}
}
