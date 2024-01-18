package org.example.brewerymanagement.equipment;

public class CanningLine extends Equipment {

    private String containerType;


    public CanningLine(String dateOfPurchase,String containerType){
        super("Canning Line",dateOfPurchase);
        this.containerType=containerType;
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
