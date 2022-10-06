package com.company;

import com.company.factory.IceCream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> facIngredients = new ArrayList<>(Arrays.asList("milk", "vanilla"));
        facIngredients.add("nuts");
        com.company.factory.IceCream iceCreamFromFactory = new com.company.factory.IceCream("Nuts", 5.5, 3.2, "2022-5-18", facIngredients);
        System.out.println(facIngredients);
        iceCreamFromFactory.raisePriceByThree();
        System.out.println("The profit of production of 500 iceCream is " + 500*iceCreamFromFactory.calculatingProfit());
        System.out.println("The production time right now is " + iceCreamFromFactory.changeProductionTime("2022-10-01"));
        iceCreamFromFactory.addIngredients("sugar");
        System.out.println("Add sugar then the ingredients will be " + iceCreamFromFactory.getIngredients());




        com.company.pointofsale.IceCream iceCreamFromPointOfSale = new com.company.pointofsale.IceCream("Vanilla",5.5, 300 );
        iceCreamFromPointOfSale.doublePrice();
        iceCreamFromPointOfSale.quantityOfCinema();
        iceCreamFromPointOfSale.changeFlavor("Chocolate");
    }
}
