package org.example.brewerymanagement.ingredients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IngredientCreation {

    static List<Hop> hopsList = new ArrayList<Hop>();
    static List<Yeast> yeastList = new ArrayList<Yeast>();
    static List<Malt> maltList = new ArrayList<Malt>();

    static Scanner scanner = new Scanner(System.in);

   public static void creationMethod(){
       //Request input for which type of Ingredient to create
       System.out.println("Which type of equipment do you want to create?");
       System.out.println("1. Fermentation Vessel");
       System.out.println("2. Mash Tun");
       System.out.println("3. Canning Line");

       int choice = scanner.nextInt();

       switch (choice) {
           case 1:
               createHop();
               break;
           case 2:
               createYeast();
               break;
           case 3:
               createMalt();
               break;
           default:
               System.out.println("Invalid choice");
               break;
       }


   }

   public static void createHop(){


        System.out.println("Enter the number of hops to create:");
        int numOfHops = scanner.nextInt();

        for (int i = 0; i < numOfHops; i++) {
            System.out.println("Enter variety for hop " + (i + 1) + ":");
            String variety = scanner.next();

            System.out.println("Enter quantity for hop " + variety + ":");
            double quantity = scanner.nextDouble();

            System.out.println("Enter price for hop " + variety + ":");
            double price = scanner.nextDouble();

            System.out.println("Enter harvest date for hop " + variety + ":");
            String harvestDate = scanner.next();

            System.out.println("Enter IBU for hop " + variety + ":");
            int IBU = scanner.nextInt();

            hopsList.add(new Hop(variety,quantity, price, harvestDate, IBU));
        }
    }

    public static void createYeast(){

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

            yeastList.add(new Yeast(strain,quantity,price,format));



        }
    }

    public static void createMalt() {
        System.out.println("Enter the number of malt strains to create:");
        int numOfMalts = scanner.nextInt();

        for (int i = 0; i < numOfMalts; i++) {
            System.out.println("Enter malt strain " + (i + 1) + ":");
            String strain = scanner.next();

            System.out.println("Enter quantity for malt strain " + strain + ":");
            double quantity = scanner.nextDouble();

            System.out.println("Enter price for malt " + strain + ":");
            double price = scanner.nextDouble();

            System.out.println("Enter format for malt " + strain + ":");
            String format = scanner.next();

            maltList.add(new Malt(strain, quantity, price, format));
        }
    }




    }



