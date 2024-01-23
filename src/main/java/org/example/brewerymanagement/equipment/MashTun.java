package org.example.brewerymanagement.equipment;

import org.example.brewerymanagement.equipment.Equipment;

public class MashTun extends Equipment {

    private int capacity;

    public MashTun(String name,String dateOfPurchase, int capacity) {
        super(name, dateOfPurchase);
        this.capacity = capacity;
    }

    //default constructor for mapping

    public MashTun(){
        super(null,null);
    }

    //Getters

    public int getID(){
        return super.getID();
    }
    public int getCapacity() {
        return capacity;
    }

    public boolean isInUse(){
        return super.isInUse();
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

