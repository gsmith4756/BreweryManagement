package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IngredientCreation {

    List<Hop> hopsList = new ArrayList<Hop>();

   public static void creationMethod(){


   }

   public void createHop(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of hops to create:");
        int numOfHops = scanner.nextInt();

        for (int i = 0; i < numOfHops; i++) {
            System.out.println("Enter quantity for hop " + (i + 1) + ":");
            double quantity = scanner.nextDouble();

            System.out.println("Enter price for hop " + (i + 1) + ":");
            double price = scanner.nextDouble();

            System.out.println("Enter harvest date for hop " + (i + 1) + ":");
            String harvestDate = scanner.next();

            System.out.println("Enter IBU for hop " + (i + 1) + ":");
            int IBU = scanner.nextInt();

            hopsList.add(new Hop(quantity, price, harvestDate, IBU));
        }
    }


    }



