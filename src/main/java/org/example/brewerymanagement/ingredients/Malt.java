package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Malt extends Ingredient {

    private String name;
    private String colour;
    public Malt(String name, double quantity,double price,String colour){
        super(quantity,price,"Malt");
        this.name=name;
        this.colour=colour;
    }

    //Getters
    public String getName(){
        return name;
    }
}
