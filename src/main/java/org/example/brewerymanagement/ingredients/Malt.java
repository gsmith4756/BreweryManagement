package org.example.brewerymanagement.ingredients;

import org.example.brewerymanagement.ingredients.Ingredient;

public class Malt extends Ingredient {

    String variety;
    String colour;
    Malt(String variety, double quantity,double price,String colour){
        super(quantity,price,"Malt");
        this.variety=variety;
        this.colour=colour;
    }
}
