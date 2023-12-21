package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Yeast extends Ingredient {

    String strain;
    String format;

    Yeast(String strain,double quantity,double price,String format){
        super(quantity,price,"Yeast");
        this.strain=strain;
        this.format = format;
    }

    public String getFormat(){
        return format;
    }
}
