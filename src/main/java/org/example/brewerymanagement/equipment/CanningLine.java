package org.example.brewerymanagement.equipment;

public class CanningLine extends Equipment {

    private String containerType;
    private String dateOfPurchase;

    public CanningLine(String dateOfPurchase){
        super("CL",dateOfPurchase);
    }

    //Getters

    public String getContainerType(){
        return containerType;
    }

    //Setters

    public void setContainerType(String containerType){
        this.containerType=containerType;
    }

}
