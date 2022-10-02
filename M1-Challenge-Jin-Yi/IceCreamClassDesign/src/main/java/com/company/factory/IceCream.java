package com.company.factory;

public class IceCream {

    private String flavor;
   private double salePrice;
   private double productionCost;
   private String productionTime;
   private String ingredients;

    public IceCream() {
    }

    public IceCream(String flavor, double salePrice, double productionCost, String productionTime, String ingredients) {
        this.flavor = flavor;
        this.salePrice = salePrice;
        this.productionCost = productionCost;
        this.productionTime = productionTime;
        this.ingredients = ingredients;
    }

    public void raisePriceByThree(){
        this.salePrice += 3;
        System.out.println("The price right now is " + this.salePrice);
    }

    public double calculatingProfit(){
        return this.salePrice - this.productionCost;
    }

    public String changeProductionTime(String string){
        this.productionTime = string;
        return this.productionTime;
    }


    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
        this.productionTime = productionTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
