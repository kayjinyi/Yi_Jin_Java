package com.company;

public class ConverterSwitch  implements Converter{
    public String convertMonth(int monthNumber){

        switch(monthNumber) {
            case 1:
                return "Jan";

            case 2:
                return "Feb";

            case 3:
                return "March";

            case 4:
                return "April";

            case 5:
                return "May";

            case 6:
                return "June";

            case 7:
                return "July";

            case 8:
                return "August";

            case 9:
                return "Sep";

            case 10:
                return "Oct";

            case 11:
                return "Nov";

            case 12:
                return "Dec";

            default:
                return "not a month";
        }
    }

    public String convertDay(int dayNumber){

        switch(dayNumber) {
            case 1:
                return "Sunday";

            case 2:
                return "Monday";

            case 3:
                return "Tuesday";

            case 4:
                return "Wednesday";

            case 5:
                return "Thursday";

            case 6:
                return "Friday";

            case 7:
                return "Saturday";

            default:
                return "out of day!";
        }
    }
}
//ConverterSwitch is class activity done with classmates