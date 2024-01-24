# Brewery Management System

Hello! Thanks for checking out this project. This project is a simple Brewery Management System that allows users to manage ingredients and equipment within the brewery, and track beers currently being brewed.

## Table of Contents

- Features
- Requirements
- Installation
- Usage


## Features

- View and manage ingredients and equipment within a simple UI
- Add new ingredients or equipment to the system.
- Brew beer and track beers being brewed.


## Requirements

- Java Development Kit (JDK)
- MySQL Database
- Maven (for building the project)

## Installation

1. Clone the repository:

   git clone https://github.com/gsmith4756/BreweryManagement.git

2. Build project in Maven

    cd BreweryManagement
    mvn clean package

3. Create mySQL database

    1. **Install MySQL:**
    - Ensure that MySQL is installed on your machine. If not, download and install MySQL from the official website: [MySQL Downloads](https://dev.mysql.com/downloads/)

    2. **Start MySQL Server:**
    - Start the MySQL server on your machine. This process varies depending on your operating system.

    3. **Access MySQL Shell:**
    - Open a terminal or command prompt and access the MySQL shell using the following command:

     mysql -u root -p

    - Enter your MySQL root password when prompted.

    4. **Create Database:**
    - In the MySQL shell, run the following command to create the "brewery_management" database:

     CREATE DATABASE brewery_management;


    5. **Grant Privileges:**
    - Grant the necessary privileges to a user. Replace 'username' and 'password' with your preferred username and password:

     GRANT ALL PRIVILEGES ON brewery_management.* TO 'username'@'localhost' IDENTIFIED BY 'password';


    6. **Flush Privileges:**
    - After granting privileges, flush the privileges for changes to take effect:

     FLUSH PRIVILEGES;


    7. **Exit MySQL Shell:**
    - Type `exit` in the MySQL shell to exit.

    Your "brewery_management" database is now set up!

## Usage

Use this command from the command line (make sure you are in the \target folder)
java -jar BreweryManagement-1.0-SNAPSHOT.jar

Please add all of the hops, yeast, malt and equipment you have within the brewery and then use the "Brew" button to brew a beer using the quantities you specify. The application will automatically pick an available fermentation vessel once you press brew again.

Happy brewing!