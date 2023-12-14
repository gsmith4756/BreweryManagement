package org.example;

public class Malt extends Ingredient{

    String colour;
    Malt(double quantity,double price,String colour){
        super(quantity,price,"Malt");
        this.colour=colour;
    }
}
