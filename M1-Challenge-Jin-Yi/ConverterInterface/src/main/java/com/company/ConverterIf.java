package com.company;

public class ConverterIf implements Converter {
    @Override
    public String toString() {
        return "ConverterIf{}";
    }

    public String convertMonth(int monthNumber){
        if(monthNumber == 1){
            return "Jan";
        } else if (monthNumber == 2){
            return "Feb";
        } else if (monthNumber == 3){
            return "March";
        } else if (monthNumber == 4){
            return "April";
        } else if (monthNumber == 5){
            return "May";
        } else if (monthNumber == 6){
            return "June";
        } else if (monthNumber == 7){
            return "July";
        } else if (monthNumber == 8){
            return "August";
        } else if (monthNumber == 9){
            return "Sep";
        } else if (monthNumber == 10){
            return "October";
        } else if (monthNumber == 11){
            return "Nov";
        } else if (monthNumber == 12){
            return "Dec";
        } else {
            return "not a month";
        }
    }

    public String convertDay(int dayNumber){
        if(dayNumber == 1){
            return "Sunday";
        } else if(dayNumber == 2){
            return "Monday";
        } else if(dayNumber == 3){
            return "Tuesday";
        } else if(dayNumber == 4){
            return "Wednesday";
        } else if(dayNumber == 5){
            return "Thursday";
        } else if(dayNumber == 6){
            return "Friday";
        } else if(dayNumber == 7){
            return "Saturday";
        } else {
            return "not a day";
        }
    }
}

//ConverterIf is class activity done with classmates