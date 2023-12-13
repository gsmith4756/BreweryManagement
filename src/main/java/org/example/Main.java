package org.example;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static int fvNumber;

    public static ArrayList<FermentationVessel> fvList = new ArrayList<FermentationVessel>();
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Hey, welcome to your brewery!");
        System.out.println("Let's create some FVs, how many do you have?");
        fvNumber=myObj.nextInt();
        createFV(fvNumber);
        listFVs();


        }

        public static void createFV(int numToCreate){
            for(int i = 0;i<numToCreate;i++){
                fvList.add(new FermentationVessel());
            }
        }

        public static void listFVs(){
            for(FermentationVessel fv:fvList){
                System.out.println(fv.getID());
            }

        }




    }
