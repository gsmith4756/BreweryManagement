package org.example.brewerymanagement.equipment;

public class Equipment {

    private int ID;
    private static int count = 0;
    private String type;
    private boolean inUse = false;
    private String dateOfPurchase;

    public Equipment(String type, String dateOfPurchase){
        ID = ++count;
        this.type = type;
        this.dateOfPurchase = dateOfPurchase;

    }

    //Getters
    public int getID(){
        return ID;
    }
    public String getType() { return type; }
    public boolean IsInUse(){ return inUse; }
    public String getDateOfPurchase(){ return dateOfPurchase;}

    //Setters
    public void setInUse(boolean inUse){
        this.inUse = inUse;
    }


}
