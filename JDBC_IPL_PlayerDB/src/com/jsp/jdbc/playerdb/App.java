package com.jsp.jdbc.playerdb;


import java.util.Scanner;
class App{
	public static void main(String[] args) {
		PlayerRepository p = new  PlayerRepository();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice ");
		System.out.println("1.AddPlayers\n 2.FindPlayerById \n 3.findAllPlayerByNationality\n 4.findAllPlayersBetweenAges\n"
				+ " 5. UpdatePlayerSalaryByIplTeam\n6.UpdateIplTeamByPlayerId\n7.DeletePlayerById\n8.DeleteAllPlayerByNationality()"
				+ "\n 9.DeleteAllPlayerWithSalaryBetween");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:p.addPlayer();
		break;

		case 2:p.findPlayerBYAgeBetween();
		break;

		case 3:p.deleteAllPlayerByNationality();
		break;

		case 4 :p.findPlayerBYAgeBetween();
		break;

		case 5 :p.updatePlayerSalaryByIplTeam();
		break;
		
		case 6 :p.deleteTeamByPlayerID();
		break;
		
		case 7 :p.findPlayerByID();
		break;
		
		case 8 :p.deleteAllPlayerByNationality();
		break;
		
		case 9 :p.deleteAllPlayerBysalBetween ();
		break;
		default:
			System.out.println("Invalid choice");

		}
	} 




}