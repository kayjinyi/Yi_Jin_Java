package com.company;

public class ConverterApplication{
    public static void main(String[] args) {

    ConverterIf converterIf1 = new ConverterIf();
    System.out.println(converterIf1.convertMonth(5));
    System.out.println(converterIf1.convertDay(4));
    System.out.println(converterIf1.convertMonth(89));
    System.out.println(converterIf1.convertDay(222));

    ConverterSwitch converterSwitch1 = new ConverterSwitch();
    System.out.println(converterSwitch1.convertMonth(3));
    System.out.println(converterSwitch1.convertDay(2));
   ;
    }

}

