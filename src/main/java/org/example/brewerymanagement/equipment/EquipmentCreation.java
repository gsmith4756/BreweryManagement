package org.example.brewerymanagement.equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipmentCreation {

    static List<FermentationVessel> fermentationVesselList = new ArrayList<>();
    static List<MashTun> mashTunList = new ArrayList<>();
    static List<CanningLine> canningLineList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void creationMethod() {
        //Request input for which type of Equipment to create
        System.out.println("Which type of equipment do you want to create?");
        System.out.println("1. Fermentation Vessel");
        System.out.println("2. Mash Tun");
        System.out.println("3. Canning Line");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createFermentationVessel();
                break;
            case 2:
                createMashTun();
                break;
            case 3:
                createCanningLine();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void createFermentationVessel() {
        System.out.println("Enter the number of fermentation vessels to create:");
        int numOfVessels = scanner.nextInt();

        for (int i = 0; i < numOfVessels; i++) {
            System.out.println("Enter vessel ID for fermentation vessel " + (i + 1) + ":");
            String vesselId = scanner.next();



            fermentationVesselList.add(new FermentationVessel(vesselId /*, other attributes */));
        }
    }

    public static void createMashTun() {

    }

    public static void createCanningLine() {

    }
}