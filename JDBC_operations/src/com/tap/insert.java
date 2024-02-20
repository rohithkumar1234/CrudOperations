package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		Connection connection =null;
		Statement statement = null;
		int res;
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		String SQL = "INSERT INTO `employee` (`idEmployee`,`Name`,`Email`,`Dept`,`Salary`)"
				+ " values ('6','jacky','jacky@gmail.com','IT','5000')";
		try {
			connection = DriverManager.getConnection(url,username,pin);
			statement = connection.createStatement();
			res = statement.executeUpdate(SQL);
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			statement.close();
			connection.close();
		}

	}

}
