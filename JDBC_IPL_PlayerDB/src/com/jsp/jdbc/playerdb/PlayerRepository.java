package com.jsp.jdbc.playerdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PlayerRepository {
	

		public static Connection getconnection(){
			Connection conn=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_ipl_playerdb", "root", "Manu@1012");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		public void addPlayer() {
			Connection conn=getconnection();
			Scanner sc=new Scanner(System.in);
			try {
				PreparedStatement pt=conn.prepareStatement("INSERT INTO player VALUES(?,?,?,?,?,?)");
				System.out.println("enter the playerId");
				pt.setInt(1, sc.nextInt());
				System.out.println("enter the playerName");
				pt.setString(2, sc.next());
				System.out.println("enter the playerAge");
				pt.setInt(3, sc.nextInt());
				System.out.println("enter the player Nationality");
				pt.setString(4, sc.next());
				System.out.println("enter the player IPL TEAM");
				pt.setString(5, sc.next());
				System.out.println("enter the player Salary");
				pt.setInt(6, sc.nextInt());
				int rowsInserted=pt.executeUpdate();
				if(rowsInserted>0) {
					System.out.println(" Data Inserted");
				}
				else {
					System.out.println("DaTA not Inserted");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	public void findPlayerByID() {
		Scanner sc=new Scanner(System.in);
		Connection conn=getconnection();
		try {
			PreparedStatement pt=conn.prepareStatement("SELECT * FROM PLAYER WHERE playerID=?");
			System.out.println("Enter the id");
			pt.setInt(1, sc.nextInt());
			pt.executeQuery();
			ResultSet rs=pt.getResultSet();
			while(rs.next())
			System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getInt(6));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void findPlayerBYNAtionality(){
		Scanner sc=new Scanner(System.in);
		Connection conn=getconnection();
		try {
			PreparedStatement pt=conn.prepareStatement("SELECT * FROM PLAYER WHERE nationality=?");
			System.out.println("Enter the player nationality");
			pt.setString(1, sc.next());
			pt.executeQuery();
			ResultSet rs=pt.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getInt(6));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void findPlayerBYAgeBetween(){
		Scanner sc=new Scanner(System.in);
		Connection conn=getconnection();
		try {
			PreparedStatement pt=conn.prepareStatement("SELECT * FROM PLAYER WHERE playerAge between ? and ?");	
			System.out.println("Enter from age");
			pt.setString(1, sc.next());
			System.out.println("Enter last age");
			pt.setString(2, sc.next());
			pt.executeQuery();
			ResultSet rs=pt.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getInt(6));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void updatePlayerSalaryByIplTeam() {
		Scanner sc=new Scanner(System.in);
		Connection conn=getconnection();
		try {
			PreparedStatement pt=conn.prepareStatement("Update player set iplsalary =? where iplteam=?");
			System.out.println("enter team name");
			pt.setString(2, sc.next());
			System.out.println("enter player salary");
			pt.setInt(1, sc.nextInt());
			int n=pt.executeUpdate();
			if(n>0) {
				System.out.println(n+" rows affected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void UpdateIplTeamByPlayerID() {Scanner sc=new Scanner(System.in);
	Connection conn=getconnection();
	try {
		PreparedStatement pt=conn.prepareStatement("Update player set iplteam =? where playerID=?");
		System.out.println("enter PlayerID");
		pt.setString(2, sc.next());
		System.out.println("enter iplteam");
		pt.setString(1, sc.next());
		int n=pt.executeUpdate();
		if(n>0) {
			System.out.println(n+" rows affected");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

		
	}
	public void deleteTeamByPlayerID() {Scanner sc=new Scanner(System.in);
	Connection conn=getconnection();
	try {
		PreparedStatement pt=conn.prepareStatement("delete from player where playerid=?");
		System.out.println("enter PlayerID");
		pt.setInt(1, sc.nextInt());
		
		int n=pt.executeUpdate();
		if(n>0) {
			System.out.println(n+" rows affected");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	}
	public void deleteAllPlayerByNationality() {Scanner sc=new Scanner(System.in);
	Connection conn=getconnection();
	try {
		PreparedStatement pt=conn.prepareStatement("delete from player where nationality=?");
		System.out.println("enter Nationality");
		pt.setString(1, sc.next());
		
		int n=pt.executeUpdate();
		if(n>0) {
			System.out.println(n+" rows affected");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	}
	public void deleteAllPlayerBysalBetween() {Scanner sc=new Scanner(System.in);
	Connection conn=getconnection();
	try {
		PreparedStatement pt=conn.prepareStatement("delete from player where iplsalary between ? and ?");
		System.out.println("enter start salary");
		pt.setInt(1, sc.nextInt());
		System.out.println("enter end salary");
		pt.setInt(2, sc.nextInt());

		
		int n=pt.executeUpdate();
		if(n>0) {
			System.out.println(n+" rows affected");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	}

}