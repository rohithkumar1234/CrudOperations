package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class insertValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		String SQL ="INSERT INTO employee(idEmployee,Name,Email,Dept,Salary)"
				+ " VALUES (?,?,?,?,?)";
		
		try {
			
			Connection connection = DriverManager.getConnection(url, username, pin);
			
			program1.display(connection, null, null);
			
			insert(scanner, SQL, connection);
			
			program1.display(connection, null, null);
		
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param scanner
	 * @param SQL
	 * @param connection
	 * @throws SQLException
	 */
	protected static void insert(Scanner scanner, String SQL, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL);
		do {

			System.out.println("Enter id: ");
			int id = scanner.nextInt();
			
			System.out.println("Enter Name: ");
			String name = scanner.next();
			
			System.out.println("Enter email: ");
			String email = scanner.next();
			
			System.out.println("Enter department: ");
			String dept = scanner.next();
			
			System.out.println("Enter salary: ");
			int salary = scanner.nextInt();
			
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, email);
			statement.setString(4, dept);
			statement.setInt(5, salary);
//			int i = statement.executeUpdate();
			statement.addBatch();
			
//				System.out.println();
			
			System.out.println("Do you want to enter more employee (YES/NO) : ");
			
		} while (scanner.next().equalsIgnoreCase("YES"));
		int[] arr = statement.executeBatch();
		System.out.println();
		for(int i =0 ;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
