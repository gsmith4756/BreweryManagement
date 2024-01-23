package org.example.brewerymanagement.equipment;

import org.example.brewerymanagement.dbconnection.CLDAO;
import org.example.brewerymanagement.dbconnection.FVDAO;
import org.example.brewerymanagement.dbconnection.MTDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipmentCreation {

/* Replaced with mySQL DB
    static List<FermentationVessel> fermentationVesselList = new ArrayList<>();
    static List<MashTun> mashTunList = new ArrayList<>();
    static List<CanningLine> canningLineList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void creationMethod(Connection connection) throws SQLException {
        //Request input for which type of Equipment to create (to be replaced with UI)
        System.out.println("Which type of equipment do you want to create?");
        System.out.println("1. Fermentation Vessel");
        System.out.println("2. Mash Tun");
        System.out.println("3. Canning Line");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createFermentationVessel(connection);
                break;
            case 2:
                createMashTun(connection);
                break;
            case 3:
                createCanningLine(connection);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void createFermentationVessel(Connection connection) throws SQLException {
        System.out.println("Enter the number of fermentation vessels to create:");
        int numOfVessels = scanner.nextInt();
        System.out.println("Enter the date of purchase:");
        String dateOfPurchase = scanner.next();
        System.out.println("Enter the capacity:");
        int capacity = scanner.nextInt();

        FVDAO fvDAO = new FVDAO(connection);

        for (int i = 0; i < numOfVessels; i++) {
            fvDAO.create(new FermentationVessel(dateOfPurchase,capacity));
        }
    }

    public static void createMashTun(Connection connection) {
        System.out.println("Enter the number of mash tuns to create:");
        int numOfMashTuns = scanner.nextInt();

        MTDAO mtDAO = new MTDAO(connection);

        System.out.println("Enter the date of purchase:");
        String dateOfPurchase = scanner.next();
        System.out.println("Enter the capacity:");
        int capacity = scanner.nextInt();

        for (int i = 0; i < numOfMashTuns; i++) {

            mtDAO.create(new MashTun(dateOfPurchase,capacity));
        }

    }

    public static void createCanningLine(Connection connection) throws SQLException {
        System.out.println("Enter the number of canning lines to create:");
        int numOfCanningLines = scanner.nextInt();

        CLDAO clDAO = new CLDAO(connection);

        System.out.println("Enter the date of purchase:");
        String dateOfPurchase = scanner.next();

        System.out.println("Enter container type");
        String containerType = scanner.next();

        for (int i = 0; i < numOfCanningLines; i++) {

            clDAO.create(new CanningLine(containerType,dateOfPurchase));
        }

    }


 */
}