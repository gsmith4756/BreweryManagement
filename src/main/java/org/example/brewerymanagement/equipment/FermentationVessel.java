package org.example.brewerymanagement.equipment;

import org.example.brewerymanagement.equipment.Equipment;

public class FermentationVessel extends Equipment {

    private int capacity;

    public FermentationVessel(String dateOfPurchase,int capacity) {
        super("FV",dateOfPurchase);
        this.capacity=capacity;

    }


    //Getters
    public int getCapacity() {
        return capacity;
    }

    //Setters

    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
}