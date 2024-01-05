package org.example.brewerymanagement;

import org.example.brewerymanagement.dbconnection.DBConnection;
import org.example.brewerymanagement.dbconnection.TableCreator;
import org.example.brewerymanagement.equipment.CanningLine;
import org.example.brewerymanagement.equipment.Equipment;
import org.example.brewerymanagement.equipment.FermentationVessel;
import org.example.brewerymanagement.equipment.MashTun;
import org.example.brewerymanagement.ingredients.IngredientCreation;
import org.example.brewerymanagement.equipment.EquipmentCreation;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static Connection connection;


    public static void main(String[] args) throws SQLException {

        //Connect to DB and assign to connection variable
        connection = DBConnection.getConnection();

        TableCreator.createTables(connection);

        IngredientCreation.creationMethod(connection);



    }
}
