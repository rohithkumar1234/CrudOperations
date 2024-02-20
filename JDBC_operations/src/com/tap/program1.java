package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program1 {

	public static void main(String[] args)  {
		Connection connection =null;
		Statement statement = null;
		ResultSet Res = null;
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String Username = "root";
		String password = "root";
		
		
		try {
			connection = DriverManager.getConnection(url, Username, password);
//			System.out.println("connected Succesful....");
			display (connection,statement,Res);
			
			
			
//			statement.executeQuery(SQL);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close(connection, statement, Res);
			
		}
		
	}
	
	
	public static void display (Connection connection,Statement statement,ResultSet Res) throws SQLException {
		statement = connection.createStatement();
		String SQL = "SELECT * FROM employee";
		Res =  statement.executeQuery(SQL);
//		System.out.println(Res);
		while (Res.next()) {
			int id = Res.getInt("idEmployee");
			String name = Res.getString("Name");
			String email = Res.getString("Email");
			String dept = Res.getString("Dept");
			int salary = Res.getInt("Salary");
			
//			System.out.println(id + " " + name + " " + email +" " + dept +" "+ salary+" ");
			System.out.println("---------------------------------------------------------");
			System.out.printf("| %-3d %-12s %-20s %-10s %d | \n",id,name,email,dept,salary);
			System.out.println("---------------------------------------------------------");
		}
		
	}

	/**
	 * @param connection
	 * @param statement
	 * @param Res
	 */
	private static void close(Connection connection, Statement statement, ResultSet Res) {
		try {
			if (Res != null) {
				Res.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			if (statement != null) {
				statement.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (connection != null) {
				connection.close();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
