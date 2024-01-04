package org.example.brewerymanagement.ingredients;

import java.util.*;

public class Hop extends Ingredient {

    List<Hop> list = new ArrayList<Hop>();

    private int ID;
    private static int count = 0;
    private String name;
    private String harvestDate;
    private int IBU;

    public Hop(String name,double quantity,double price,String harvestDate,int IBU){
        super(quantity,price,"Hop");
        this.ID = count++;
        this.name=name;
        this.harvestDate=harvestDate;
        this.IBU=IBU;
    }

    //default constructor
    public Hop(){
        super(0.0,0.0,"");
    }

    //Getters

    public int getID(){return ID;}
    public String getName(){return name;}

    public String getHarvestDate(){
        return harvestDate;
    }

    public int getIBU(){
        return IBU;
    }

    //Setters

    public void setID(int ID){
        this.ID=ID;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setHarvestDate(String harvestDate){
        this.harvestDate=name;
    }

    public void setIBU(int IBU){
        this.IBU=IBU;
    }


}
