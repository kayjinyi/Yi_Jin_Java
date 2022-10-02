package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterIfTest {
    private ConverterIf converterIf;
    @Before
    public void resetConverterIf(){
        converterIf = new ConverterIf();
    }
    @Test
    public void shouldReturnMonth(){
        //Act and arrange

        int[] months = new int[]{0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        //Assert
        assertEquals("Jan",converterIf.convertMonth(1));
        assertEquals("Feb",converterIf.convertMonth(2));
        assertEquals("March",converterIf.convertMonth(3));
        assertEquals("April",converterIf.convertMonth(4));
        assertEquals("May",converterIf.convertMonth(5));
        assertEquals("June",converterIf.convertMonth(6));
        assertEquals("July",converterIf.convertMonth(7));
        assertEquals("August",converterIf.convertMonth(8));
        assertEquals("Sep",converterIf.convertMonth(9));
        assertEquals("October",converterIf.convertMonth(10));
        assertEquals("Nov",converterIf.convertMonth(11));
        assertEquals("Dec",converterIf.convertMonth(12));
        assertEquals("not a month",converterIf.convertMonth(87));
    }
    @Test
    public void shouldReturnDay(){
        //Act, arrange, assert
        assertEquals("Sunday", converterIf.convertDay(1));
        assertEquals("Monday", converterIf.convertDay(2));
        assertEquals("Tuesday", converterIf.convertDay(3));
        assertEquals("Wednesday", converterIf.convertDay(4));
        assertEquals("Thursday", converterIf.convertDay(5));
        assertEquals("Friday", converterIf.convertDay(6));
        assertEquals("Saturday", converterIf.convertDay(7));
        assertEquals("not a day", converterIf.convertDay(8));
        assertEquals("not a day", converterIf.convertDay(123));



    }


}