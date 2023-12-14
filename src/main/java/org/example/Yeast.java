package org.example;

public class Yeast extends Ingredient{

    String format;

    Yeast(double quantity,double price,String format){
        super(quantity,price,"Yeast");
        this.format = format;
    }

    public String getFormat(){
        return format;
    }
}
