package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Acid_properties {
	static final String SQL = "UPDATE employee SET Salary = Salary + ? WHERE Name = ?  ";
	static final Scanner scanner = new Scanner(System.in);
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		
		try {
			
			connection = DriverManager.getConnection(url,username,pin);
			
			program1.display(connection, statement, null);
			connection.setAutoCommit(false);
			
			transaction();
			program1.display(connection, statement, null);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			statement.close();
			connection.close();
			scanner.close();
		}

	}
	
	static void  transaction() throws SQLException {
		System.out.println("Enter the Sender Name : ");
		String sender = scanner.next();
		
		System.out.println("Enter Receivers Name: ");
		String Receiver = scanner.next();
		
		System.out.println("Enter the Amount: ");
		int amount = scanner.nextInt();
		
		int i = updateSalary(sender,-amount);
		
//		updateSalary(sender/,-amount);
		int j = updateSalary(Receiver,amount);
		if (isconfirm(i,j)) {
			System.out.println("congratulations! Transcation Succesful..");
			connection.commit();
		} else {
			System.out.println("Transaction failed..");
			connection.rollback();
		}
		
		
	}
	static boolean isconfirm(int i, int j) {
		System.out.println("Do you want to proceed with the transaction(YES/NO): ");
		String bool = scanner.next();
		
		return bool.equalsIgnoreCase("YES") && i == 1 &&  j==1;
	}
	static int updateSalary(String user,int amount) throws SQLException{
			
			statement = connection.prepareStatement(SQL);
			statement.setInt(1, amount);
			statement.setString(2, user);
			int i = statement.executeUpdate();
			return i;
		
	}

}
