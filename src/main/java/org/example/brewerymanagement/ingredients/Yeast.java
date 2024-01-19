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

    //default constructor
    public Yeast() {
        super(null,0.0,0.0);
    }

    //getters

    public int getID(){
        return ID;
    }
    public String getFormat(){
        return format;
    }

    public void setFormat(String format) {
        this.format=format;
    }
}
