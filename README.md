# Basic-Banking-Form-with-Database-Connectivity
# Banking Form Application

## Description

This project is a simple Swing-based Java application for registering users to a bank system. Users can fill out a form with their personal information, and the data is then stored in a MySQL database.

## Features

- User registration form with fields for name, gender, email, mobile number, password, account type, branch, and additional options.
- Form validation and data submission.
- Connection to a MySQL database to store user information.

## Prerequisites

- Java Development Kit (JDK) 8 or higher.
- Eclipse IDE or any other Java IDE.
- MySQL Database.

  ##Configure the MySQL Database:

Make sure MySQL is installed and running.
Create a database named bankform.
Create a table in the bankform database with the following schema:

CREATE TABLE bank (
    Name VARCHAR(50),
    Gender VARCHAR(10),
    MailId VARCHAR(50),
    Mobile VARCHAR(15),
    Password VARCHAR(50),
    Account VARCHAR(20),
    Branch VARCHAR(20),
    Options VARCHAR(50)
);

##Update Database Connection Details:

Open BankingForm.java.
Update the DriverManager.getConnection method with your MySQL username and password

##Dependencies
mysql-connector-java library for connecting to MySQL.

Now, run your Java application.

Fill out the registration form with the required details.
Click on the Register button to submit the form.
The application will display a message showing the entered details and store the information in the MySQL database.

