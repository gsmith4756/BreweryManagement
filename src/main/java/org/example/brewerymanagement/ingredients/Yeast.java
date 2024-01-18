package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Yeast extends Ingredient {

    private int ID;
    private static int count = 0;

    String format;

    public Yeast(String name,double quantity,double price,String format){
        super(name,quantity,price);
        this.ID = count;
        count++;
        this.format = format;
    }

    //Getters

    public int getID(){
        return ID;
    }
    public String getFormat(){
        return format;
    }

}
