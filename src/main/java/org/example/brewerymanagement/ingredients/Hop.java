package org.example.brewerymanagement.ingredients;

import java.util.*;

public class Hop extends Ingredient {

    List<Hop> list = new ArrayList<Hop>();

    private int ID;
    private static int count = 0;
    private String harvestDate;
    private int IBU;

    public Hop(String name,double quantity,double price,String harvestDate,int IBU){
        super(name,quantity,price);
        this.ID = count++;
        this.harvestDate=harvestDate;
        this.IBU=IBU;
    }

    //default constructor
    public Hop(){
        super(null,0.0,0.0);
    }

    //Getters

    public int getID(){return ID;}


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
        super.setName(name);
    }

    public void setHarvestDate(String harvestDate){
        this.harvestDate=harvestDate;
    }

    public void setIBU(int IBU){
        this.IBU=IBU;
    }


}
