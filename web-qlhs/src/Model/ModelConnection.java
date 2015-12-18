package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelConnection
{

	public final String mysqlHost = "jdbc:mysql://localhost:3306/qlhs?useUnicode=true&characterEncoding=UTF-8";
	public final String userName = "root";
	public final String password = "";
	private Connection connection = null;

	public ModelConnection()
	{

	}

	public Connection getConnection()
	{
		return connection;
	}	

	public Boolean connect()
	{
		try
		{
			// chá»�n driver
			Class.forName("com.mysql.jdbc.Driver");
			// tao káº¿t ná»‘i xuá»‘ng database
			connection = DriverManager.getConnection(mysqlHost, userName, password);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet read(String sql)
	{
		ResultSet data = null;
		try
		{
			java.sql.Statement cmd = connection.createStatement();
			data = cmd.executeQuery(sql);

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
		return data;
	}	

	public int write(String sql)
	{
		try
		{
			java.sql.Statement cmd = connection.createStatement();
			
			return cmd.executeUpdate(sql);

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void close()
	{
		try
		{
			this.connection.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
