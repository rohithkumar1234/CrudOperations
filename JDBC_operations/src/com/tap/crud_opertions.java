package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class crud_opertions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		
		try {
			
			Connection connection = DriverManager.getConnection(url,username,pin);
			
			program1.display(connection, null, null);
			
//			do {
			System.out.println();
			
			System.out.println("1.Insert");
			System.out.println("2.UPDATE");
			System.out.println("3.DELETE");
			System.out.println("4.DISPLAY");
			System.out.println("5.EXIT");
			
			System.out.println();
			int input = scanner.nextInt();
			
//			do {
				if (input == 1) {
					insert_values(scanner, connection);
				} else if (input == 2){
					update_values(scanner, connection);
				} else if (input == 3) {
					DeleteRecord(scanner, connection);
				} else if (input == 4) {
					program1.display(connection, null, null);		
				} else {
					System.out.println("Succesfullt closed...");
					return;
				}
//			}while(input != 5);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param scanner
	 * @param connection
	 * @throws SQLException
	 */
	protected static void DeleteRecord(Scanner scanner, Connection connection) throws SQLException {
		String SQL = "DELETE FROM employee"
				+ " WHERE idEmployee = ? ;";
		PreparedStatement statement = connection.prepareStatement(SQL);
		System.out.println("Enter id: ");
		int id = scanner.nextInt();
		statement.setInt(1, id);
		if (statement.executeUpdate() >0) {
			System.out.println(" Record deleted succesfully");
		} else {
			System.out.println("record not found");
		}
		
		program1.display(connection, statement, null);
	}

	/**
	 * @param scanner
	 * @param connection
	 * @throws SQLException
	 */
	protected static void update_values(Scanner scanner, Connection connection) throws SQLException {
		String SQL = "UPDATE employee SET Salary = Salary + ? "
				+ "WHERE Dept = ? ";
		
		PreparedStatement statement = connection.prepareStatement(SQL);
		System.out.println("Enter increment salary = ");
		int inc = scanner.nextInt();
		System.out.println("Enter Department Name: ");
		String dept = scanner.next();
		statement.setInt(1, inc);
		statement.setString(2, dept);
		statement.executeUpdate();
		
		program1.display(connection, statement, null);
	}

	/**
	 * @param scanner
	 * @param connection
	 * @throws SQLException
	 */
	protected static void insert_values(Scanner scanner, Connection connection) throws SQLException {
		String SQL ="INSERT INTO employee(idEmployee,Name,Email,Dept,Salary)"
				+ " VALUES (?,?,?,?,?)";
		insertValues.insert(scanner, SQL, connection);;
		
		program1.display(connection, null, null);
	}

}
