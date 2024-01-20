package org.example.brewerymanagement.equipment;

public class Equipment {

    private int ID;
    private static int count = 0;
    private String name;
    private boolean inUse = false;
    private String dateOfPurchase;

    public Equipment(String name, String dateOfPurchase){
        ID = ++count;
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;

    }

    //Getters
    public int getID(){
        return ID;
    }
    public String getName() { return name; }
    public boolean IsInUse(){ return inUse; }
    public String getDateOfPurchase(){ return dateOfPurchase;}

    //Setters
    public void setInUse(boolean inUse){
        this.inUse = inUse;
    }


}
