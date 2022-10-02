package com.company.pointofsale;

import java.util.ArrayList;
import java.util.List;

public class IceCream {
    public String flavor;
    private double price;
    private int quantity;

    public IceCream() {
    }

    public IceCream(String flavor, double price, int quantity) {
        this.flavor = flavor;
        this.price = price;
        this.quantity = quantity;
    }

    public void doublePrice(){
        this.price *= 2;
        System.out.println("The price of IceCream after double is " + this.price);
    }

    public void quantityOfCinema (){
        this.quantity +=  500;
        System.out.println("The quantity of Cinema is " + this.quantity);
    }

    public void changeFlavor(String string){
        this.flavor = string;
        System.out.println("The flavor of IceCream right now is " + this.flavor);

    }


    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
