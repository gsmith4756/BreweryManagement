package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Yeast extends Ingredient {

    private int ID;
    private static int count = 0;
    String name;
    String format;

    public Yeast(String name,double quantity,double price,String format){
        super(quantity,price,"Yeast");
        this.ID = count;
        count++;
        this.name = name;
        this.format = format;
    }

    //Getters

    public int getID(){
        return ID;
    }
    public String getFormat(){
        return format;
    }

    public String getName(){
        return name;
    }
}
