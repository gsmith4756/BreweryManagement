package org.example.brewerymanagement.ingredients;
import java.util.*;

public abstract class Ingredient {

    private String name;
    private double quantity;
    private double price;


    Ingredient(String name,double quantity,double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void setQuantity(double newQuantity){
        quantity = newQuantity;
    }

    public double getQuantity(){
        return quantity;
    }

    public void addQuantity(double amountToAdd){
        quantity += amountToAdd;
    }

    public void removeQuantity(double amountToRemove){
        quantity -= amountToRemove;
    }

    public void setPrice(double newPrice){
        quantity = newPrice;
    }

    public double getPrice(){
        return price;
    }

    public void addPrice(double amountToAdd){
        price += amountToAdd;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
