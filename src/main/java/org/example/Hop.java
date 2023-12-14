package org.example;
import java.util.*;

public class Hop extends Ingredient{

    List<Hop> list = new ArrayList<Hop>();
    private String harvestDate;
    private int IBU;

    Hop(double quantity,double price,String harvestDate,int IBU){
        super(quantity,price,"Hop");
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
