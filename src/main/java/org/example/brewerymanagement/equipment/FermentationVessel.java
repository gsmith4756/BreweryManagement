package org.example.brewerymanagement.equipment;

import org.example.brewerymanagement.equipment.Equipment;

public class FermentationVessel extends Equipment {

    private int capacity;

    public FermentationVessel(String name,String dateOfPurchase,int capacity) {
        super(name,dateOfPurchase);
        this.capacity=capacity;

    }

    public FermentationVessel() {
        super(null,null);
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