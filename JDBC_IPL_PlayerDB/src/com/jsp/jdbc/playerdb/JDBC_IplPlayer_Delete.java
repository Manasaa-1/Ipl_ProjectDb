package com.jsp.jdbc.playerdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBC_IplPlayer_Delete {

	
	 public static void main(String[] args) {
		
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_ipl_playerdb?user=root&password=Manu@1012");
			
			
			Statement st= conn.createStatement();
			
			boolean result = st.execute("DELETE FROM player WHERE playerId=102");
			System.out.println(result);
			ResultSet rs= st.getResultSet();
			
			if(result == false) {
				System.out.println("data deleted!!");
			}
			else {
				System.out.println("data not deleted");
				
			}
			conn.close();
		 }
			
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	}


