package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Malt extends Ingredient {


    private String format;
    public Malt(String name, double quantity,double price,String format){
        super(name, quantity,price);
        this.format = format;
    }

    //Getters
    public String getFormat(){
        return format;
    }

    public String getName(){
        return super.getName();
    }
}
