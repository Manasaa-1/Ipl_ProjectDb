# IPL Player DB

A Java application for managing IPL player data using JDBC and MySQL. This project allows users to perform CRUD operations (Create, Read, Update, Delete) on an IPL players database.

## Features
- Add new players
- View all players
- Update player details
- Delete players from the database

## Technologies Used
- **Java**: For core application development
- **JDBC**: To connect and interact with MySQL database
- **MySQL**: As the database to store IPL player information

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/ipl-player-db.git
   
##Install MySQL and set up your database:
CREATE DATABASE ipl_db;
USE ipl_db;

CREATE TABLE players (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    team VARCHAR(50),
    runs INT,
    wickets INT
);
##Configure the DBConnection.java file with your MySQL username and password:
String url = "jdbc:mysql://localhost:3306/ipl_db";
String username = "your-username";
String password = "your-password";
