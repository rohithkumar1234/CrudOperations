package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class update {

	public static void main(String[] args) throws SQLException  {
		Connection connection =null;
		Statement statement = null;
		int res;
		ResultSet Res = null;
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		String SQL = "UPDATE `Employee` SET "
				+ "`Salary` = `Salary` + 5000"
				+ " WHERE `Dept` = 'finance' ";
		try {
			connection = DriverManager.getConnection(url, username, pin);
			statement = connection.createStatement();
			program1.display(connection,statement,null);
			res = statement.executeUpdate(SQL);
			System.out.println(res);
			program1.display(connection,statement,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}finally {
		statement.close();
		connection.close();
		
	}
	}
		
	}

