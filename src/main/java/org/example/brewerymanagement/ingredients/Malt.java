package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Malt extends Ingredient {

    private String name;
    private String format;
    public Malt(String name, double quantity,double price,String format){
        super(quantity,price,"Malt");
        this.name=name;
        this.format=format;
    }

    //Getters
    public String getName(){
        return name;
    }
    public String getFormat(){
        return format;
    }
}
