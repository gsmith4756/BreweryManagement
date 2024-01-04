package org.example.brewerymanagement.equipment;

public class Equipment {

    private int ID;
    private static int count = 0;


    private String type;
    private boolean inUse = false;
    private int quantity = 0;

    Equipment(String type){
        inUse = false;
        ID = ++count;
        this.type = type;

    }

    public int getID(){
        return ID;
    }


}