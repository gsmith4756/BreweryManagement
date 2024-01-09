package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Yeast extends Ingredient {

    private int ID;
    private static int count = 0;
    String strain;
    String format;

    public Yeast(String strain,double quantity,double price,String format){
        super(quantity,price,"Yeast");
        this.ID = count;
        count++;
        this.strain = strain;
        this.format = format;
    }

    //Getters

    public int getID(){
        return ID;
    }
    public String getFormat(){
        return format;
    }

    public String getStrain(){
        return strain;
    }
}
