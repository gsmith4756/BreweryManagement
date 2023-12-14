package org.example;
import java.util.*;

public abstract class Ingredient {
    private double quantity;
    private double price;
    private String type;

    Ingredient(double quantity,double price, String type){
        this.quantity = quantity;
        this.price = price;
        this.type = type;
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

    public String getType(){
        return type;
    }
}
