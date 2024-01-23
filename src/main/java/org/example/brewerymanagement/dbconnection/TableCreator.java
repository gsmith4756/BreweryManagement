package org.example.brewerymanagement.dbconnection;

import java.sql.*;

public class TableCreator {

    private static String [] tables = {"hops","malt","yeast","canninglines","fermentationvessels","mashtuns","beersbrewing"};

    public static void createTables(Connection connection,String tableName) throws SQLException {
        switch (tableName.toLowerCase()) {
            case "hops":
                createHopTable(connection);
                break;
            case "malt":
                createMaltTable(connection);
                break;
            case "yeast":
                createYeastTable(connection);
                break;
            case "canninglines":
                createCLTable(connection);
                break;
            case "fermentationvessels":
                createFVTable(connection);
                break;
            case "mashtuns":
                createMTTable(connection);
                break;
            case "beersbrewing":
                createBeersTable(connection);
                break;
            default:
                throw new IllegalArgumentException("Unknown table: " + tableName);
        }
    }


    public static void createHopTable(Connection connection) {
        String createTableSQL = "CREATE TABLE hops (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "quantity DOUBLE," +
                "price DOUBLE," +
                "harvestDate VARCHAR(255)," +
                "IBU INT" +
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
                "containerType VARCHAR(255)" +
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
                "yeastUsed VARCHAR(255)," +
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
    public static void createMissingTables(Connection connection) {
        try {
            //loop through tables and create if missing
            for (String tableName : tables) {
                createTableIfMissing(connection, tableName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableIfMissing(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        if (!tableExists(metaData, tableName)) {
            createTables(connection,tableName);
            System.out.println("Table " + tableName + " created.");
        }
    }

    //check if table exists using metadata retrieved in above method
    private static boolean tableExists(DatabaseMetaData metaData, String tableName) throws SQLException {
        try (var resultSet = metaData.getTables(null, null, tableName, null)) {
            return resultSet.next();
        }
    }

}
