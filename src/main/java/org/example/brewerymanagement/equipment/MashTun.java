package org.example.brewerymanagement.equipment;

import org.example.brewerymanagement.equipment.Equipment;

public class MashTun extends Equipment {

    private int capacity;

    public MashTun(String dateOfPurchase, int capacity) {
        super("MT", dateOfPurchase);
        this.capacity = capacity;
    }

    //default constructor for mapping

    public MashTun(){
        super("MT",null);
    }

    //Getters

    public int getID(){
        return super.getID();
    }
    public int getCapacity() {
        return capacity;
    }

    public boolean isInUse(){
        return super.IsInUse();
    }

    //Setters

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void setId(int id) {
    }

    public void setDateOfPurchase(String dateOfPurchase) {
    }

    public void setType(String type) {
    }
}

