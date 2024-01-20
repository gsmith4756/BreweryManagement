package org.example.brewerymanagement.dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    public static void createTables(Connection connection) throws SQLException {
        String checkTablesSQL = "SHOW TABLES;";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(checkTablesSQL);


        String [] tableList = new String[6];
        int count = 1;

        while(resultSet.next()){
            System.out.println(resultSet.getString(count));
            tableList[count]=resultSet.getString(count);
            count++;
        }
    }
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

    public static void createYeastTable(Connection connection) {
        String createTableSQL = "CREATE TABLE yeast (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "format VARCHAR(255)," +
                "price DOUBLE" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (
             Statement statement = connection.createStatement()) {
             statement.executeUpdate(createTableSQL);
             System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createMaltTable(Connection connection) {
        String createTableSQL = "CREATE TABLE malt (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "price DOUBLE," +
                "format VARCHAR(255)" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Statement statement = connection.createStatement()) {
             statement.executeUpdate(createTableSQL);
             System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createFVTable(Connection connection) {
        String createTableSQL = "CREATE TABLE fermentationVessels (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "inUse TINYINT(1)," +
                "capacity DOUBLE," +
                "dateOfPurchase VARCHAR(255)" +
                ");";

        //Connect to MySQL and create table with above parameters

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    public static void createMTTable(Connection connection) {
        String createTableSQL = "CREATE TABLE mashTuns (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "inUse TINYINT(1)," +
                "dateOfPurchase VARCHAR(255)," +
                "capacity INT" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createCLTable(Connection connection) {
        String createTableSQL = "CREATE TABLE canningLines (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "inUse TINYINT(1)," +
                "dateOfPurchase VARCHAR(255)," +
                "capacity INT" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

    public static void createBeersTable(Connection connection) {
        String createTableSQL =
                "CREATE TABLE beersBrewing (" +
                "ID INT PRIMARY KEY AUTO_INCREMENT," +
                "beerName VARCHAR(255)," +
                "brewDate DATE," +
                "hopsUsed VARCHAR(255)," +
                "maltUsed VARCHAR(255)," +
                "yeastUsed VARCHAR(255)" +
                "fvUsed VARCHAR(255)" +
                ");";

        //Connect to mySQL and create table with above parameters

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }

    }

}
