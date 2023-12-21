package org.example.brewerymanagement.ingredients;

import java.util.*;

public class Hop extends Ingredient {

    List<Hop> list = new ArrayList<Hop>();

    private String variety;
    private String harvestDate;
    private int IBU;

    Hop(String variety,double quantity,double price,String harvestDate,int IBU){
        super(quantity,price,"Hop");
        this.variety=variety;
        this.harvestDate=harvestDate;
        this.IBU=IBU;
    }

    public String getHarvestDate(){
        return harvestDate;
    }

    public int getIBU(){
        return IBU;
    }
}
