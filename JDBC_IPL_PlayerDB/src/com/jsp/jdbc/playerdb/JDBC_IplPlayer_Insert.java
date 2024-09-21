package com.jsp.jdbc.playerdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_IplPlayer_Insert {
	public static void main(String[] args) {

		try {
			// 1.load & register the driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			// 2. establish the connections

			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","Manu@1012" );

			// 3. create statement
			Statement st =  conn.createStatement();

			// 4. execute the query
			int rowsInserted = st.executeUpdate("INSERT INTO jdbc_ipl_playerdb.player VALUES(107,'mythri',40,'hindu','rcb',20000)");

			// 5. process the result

			if(rowsInserted > 0) {
				System.out.println(rowsInserted +" Data inserted successfully ");
			}
			else {
				System.out.println("Data not inserted");
			}
			// 6. close connection
			conn.close();
		}
		catch( Exception e) {
			e.printStackTrace();

		}
	}

}
