package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.dbconnection.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class IngredientCreation {

    /* Replaced with mySQL DB

    //replace with DB
    static List<Hop> hopsList = new ArrayList<Hop>();
    static List<Yeast> yeastList = new ArrayList<Yeast>();
    static List<Malt> maltList = new ArrayList<Malt>();

    static Scanner scanner = new Scanner(System.in);

   public static void creationMethod(Connection connection) throws SQLException {
       //Request input for which type of Ingredient to create
       System.out.println("Which type of Ingredient do you want to create?");
       System.out.println("1. Hops");
       System.out.println("2. Yeast");
       System.out.println("3. Malt");

       int choice = scanner.nextInt();

       switch (choice) {
           case 1:
               createHop(connection);
               break;
           case 2:
               createYeast(connection);
               break;
           case 3:
               createMalt(connection);
               break;
           default:
               System.out.println("Invalid choice");
               break;
       }


   }

   public static void createHop(Connection connection) throws SQLException {


        System.out.println("Enter the number of hops to create:");
        int numOfHops = scanner.nextInt();

        //Connect to DB
        HopDAO hopDAO = new HopDAO(connection);

        for (int i = 0; i < numOfHops; i++) {
            System.out.println("Enter variety for hop " + (i + 1) + ":");
            String name = scanner.next();

            System.out.println("Enter quantity for hop " + name + ":");
            double quantity = scanner.nextDouble();

            System.out.println("Enter price for hop " + name + ":");
            double price = scanner.nextDouble();

            System.out.println("Enter harvest date for hop " + name + ":");
            String harvestDate = scanner.next();

            System.out.println("Enter IBU for hop " + name + ":");
            int IBU = scanner.nextInt();

            hopsList.add(new Hop(name,quantity, price, harvestDate, IBU));

            //Add hop to DB
            hopDAO.create(new Hop(name,quantity, price, harvestDate, IBU));

        }
    }

    public static void createYeast(Connection connection) throws SQLException {

       YeastDAO yeastDAO = new YeastDAO(connection);

        System.out.println("Enter the number of yeast strains to create:");
        int numOfHops = scanner.nextInt();

        for (int i = 0; i < numOfHops; i++) {

            System.out.println("Enter yeast strain " + (i + 1) + ":");
            String strain = scanner.next();

            System.out.println("Enter quantity for yeast strain " + strain + ":");
            double quantity = scanner.nextDouble();

            System.out.println("Enter price for yeast " + strain + ":");
            double price = scanner.nextDouble();

            System.out.println("Enter format for yeast " + strain + ":");
            String format = scanner.next();

            yeastDAO.create(new Yeast(strain,quantity,price,format));



        }
    }

    public static void createMalt(Connection connection) throws SQLException {

       MaltDAO maltDAO = new MaltDAO(connection);
        System.out.println("Enter the number of malt types to create:");
        int numOfMalts = scanner.nextInt();

        for (int i = 0; i < numOfMalts; i++) {
            System.out.println("Enter malt type " + (i + 1) + ":");
            String strain = scanner.next();

            System.out.println("Enter quantity for malt " + strain + ":");
            double quantity = scanner.nextDouble();

            System.out.println("Enter price for malt " + strain + ":");
            double price = scanner.nextDouble();

            System.out.println("Enter format for malt " + strain + ":");
            String format = scanner.next();


            maltDAO.create(new Malt(strain, quantity, price, format));


        }
    }


*/

    }



