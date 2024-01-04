package org.example.brewerymanagement.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    public static void createIngredientsTable() {
        String createTableSQL = "CREATE TABLE ingredients (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "price DOUBLE" +
                ");";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createEquipmentTable() {
        String createTableSQL = "CREATE TABLE equipment (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                ");";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public static void createHopTable() {
        String createTableSQL = "CREATE TABLE hops (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "price DOUBLE," +
                "harvestDate VARCHAR(255)," +
                "IBU INT" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
             statement.executeUpdate(createTableSQL);
             System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createYeastTable() {
        String createTableSQL = "CREATE TABLE yeast (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "format VARCHAR(255)," +
                "price DOUBLE" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
             statement.executeUpdate(createTableSQL);
             System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createMaltTable() {
        String createTableSQL = "CREATE TABLE malt (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "colour VARCHAR(255)" +
                "price DOUBLE" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
             statement.executeUpdate(createTableSQL);
             System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }
}
