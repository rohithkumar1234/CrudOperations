package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class update2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		String SQL = "UPDATE employee SET Salary = Salary + ? "
				+ "WHERE Dept = ? ";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, pin);
			program1.display(connection, null, null);
			
			PreparedStatement statement = connection.prepareStatement(SQL);
			System.out.println("Enter increment salary = ");
			int inc = scanner.nextInt();
			System.out.println("Enter Department Name: ");
			String dept = scanner.next();
			statement.setInt(1, inc);
			statement.setString(2, dept);
			int i = statement.executeUpdate();
			System.out.println(i);
			
			program1.display(connection, null, null);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
