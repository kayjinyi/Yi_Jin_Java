package com.company;

import com.company.factory.IceCream;

public class App {
    public static void main(String[] args) {

        com.company.factory.IceCream iceCreamFromFactory = new com.company.factory.IceCream("Nuts", 5.5, 3.2, "2022-5-18", "milk");
        iceCreamFromFactory.raisePriceByThree();
        System.out.println("The profit of production of 500 iceCream is " + 500*iceCreamFromFactory.calculatingProfit());
        System.out.println("The production time right now is " + iceCreamFromFactory.changeProductionTime("2022-10-01"));




        com.company.pointofsale.IceCream iceCreamFromPointOfSale = new com.company.pointofsale.IceCream("Vanilla",5.5, 300 );
        iceCreamFromPointOfSale.doublePrice();
        iceCreamFromPointOfSale.quantityOfCinema();
        iceCreamFromPointOfSale.changeFlavor("Chocolate");
    }
}
