package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class update_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/jdbc_operations";
		String username = "root";
		String pin = "root";
		String SQL = "SELECT * FROM employee WHERE Dept = ?";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, pin);
			PreparedStatement statement = connection.prepareStatement(SQL);
			System.out.println("Enter the Department name: ");
			String dept = scanner.next();
			statement.setString(1, dept);
			ResultSet Res = statement.executeQuery();
			
			
//			Display
			
			
			System.out.println("---------------------------------------------------------");
			while (Res.next()) {
				int id = Res.getInt("idEmployee");
				String name = Res.getString("Name");
				String email = Res.getString("Email");
				String dept2 = Res.getString("Dept");
				int salary = Res.getInt("Salary");
				
//				System.out.println(id + " " + name + " " + email +" " + dept +" "+ salary+" ");
				System.out.printf("| %-3d %-12s %-20s %-10s %d | \n",id,name,email,dept,salary);
			}
			System.out.println("---------------------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
