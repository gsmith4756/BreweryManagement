package org.example.brewerymanagement.dbconnection;
import java.sql.*;
import java.util.*;

public class DBConnection {

    private static final String URL= "jdbc:mysql://localhost:3306/brewery_management";;
    private static String username;
    private static String password;

    static Scanner scanner = new Scanner(System.in);

    //Connect to mySQL DB
    public static Connection getConnection() throws SQLException {
        try{
            System.out.println("DB username: ");
            username = scanner.next();
            System.out.println("DB password: ");
            password = scanner.next();

            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, username, password);
        } catch(ClassNotFoundException | SQLException e){
            throw new SQLException("Connection failed");
        }
    }

}
