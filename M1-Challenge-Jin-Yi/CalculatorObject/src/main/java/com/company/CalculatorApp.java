package com.company;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println(calculator.add(1,1));
        System.out.println(calculator.subtract(23,52));
        System.out.println(calculator.multiply(34,2));
        System.out.println(calculator.divide(12,3));
        System.out.println(calculator.divide(12,7));
        System.out.println(calculator.add(3.4,2.3));
        System.out.println(calculator.multiply(6.7,4.4));
        System.out.println(calculator.subtract(5.5,0.5));
        System.out.println(calculator.divide(10.8,2.2));

    }
}
