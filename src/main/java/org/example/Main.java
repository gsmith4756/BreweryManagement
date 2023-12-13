package org.example;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static ArrayList<FermentationVessel> fvList = new ArrayList<FermentationVessel>();
    public static ArrayList<MashTun> mtList = new ArrayList<MashTun>();

    public static ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Hey, welcome to your brewery!");
        System.out.println("Let's create some FVs, how many do you have?");
        createEquipment(myObj.nextInt(), "FV");
        myObj.nextLine();
        System.out.println("Great! How many mash tuns?");
        createEquipment(myObj.nextInt(), "MT");
        myObj.nextLine();
        String input = null;
        while(input !="exit") {
            System.out.println("Which equipment list would you like to view? (FV/MT/all)");
            input = myObj.nextLine();
            listEquipment(input);
        }
    }

    public static void createEquipment(int numToCreate, String type) {

        for (int i = 0; i < numToCreate; i++) {
            switch (type) {
                case "FV":
                    fvList.add(new FermentationVessel());
                    break;
                case "MT":
                    mtList.add(new MashTun());
                    break;
                default:

            }

        }
    }


    public static void listEquipment(String type) {
        System.out.println(type);
        switch(type){
            case "FV":
                for(FermentationVessel fv:fvList) {
                    System.out.println("FV " + fv.getID());
                }
                break;
            case "MT":
                for(MashTun mt :mtList) {
                    System.out.println("MT " + mt.getID());
                }
                break;
            default:
        }

    }

    public static void listAllEquipment(){

    }


}
