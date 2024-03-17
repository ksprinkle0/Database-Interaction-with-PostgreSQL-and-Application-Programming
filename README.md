# Database-Interaction-with-PostgreSQL-and-Application-Programming

Author: Khushie Singh

How to run:
  - make sure you have installed Java and Driver (I used eclipse so the driver in included in my project folder)
  - create schema on pgAdmin using the A3Q1.sql file
  - open main file and change url, username, and password if differnt on your device
  - run program and uncomment the functions as needed

Notes: This project was created using eclipse and the code structer is from class, it spceifically useses the format given in lecture 11 and the JDBC example video the proffessor shared.

Functions:
  All functions uses connection to create a statement, String query specifys what SQL operation is needed. An extra paremeter Connection con is added to all functions to avoid re-writing "Connection con = DriverManager.getConnection(url, user, password);".  
