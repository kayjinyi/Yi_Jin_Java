package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    @Before
    public void Setup(){
        calculator = new Calculator();
    }
    @Test
    public void shouldSumOfTwoInteger(){
        //Act, Arrange, assert
        int expectedValue = 78;
        assertEquals(expectedValue, calculator.add(22,56));
    }
    @Test
    public void shouldSumOfTwoDouble(){
        //Act, Arrange, assert
        double expectedValue = 78.0;
        assertEquals(expectedValue, calculator.add(21.5,56.5), 0.001);
    }
    @Test
    public void shouldDifferenceOfTwoInteger(){
        //Act, Arrange, assert
        int expectedValue = -34;
        assertEquals(expectedValue, calculator.subtract(22,56));
    }
    @Test
    public void shouldSDifferenceOfDouble(){
        //Act, Arrange, assert
        double expectedValue = 2.9;
        assertEquals(expectedValue, calculator.subtract(7,4.1), 0.001);
    }
    @Test
    public void shouldProductOfTwoInteger(){
        //Act, Arrange, assert
        int expectedValue = 112;
        assertEquals(expectedValue, calculator.multiply(2,56));
    }
    @Test
    public void shouldProductOfTwoDouble(){
        //Act, Arrange, assert
        double expectedValue = 10.0;
        assertEquals(expectedValue, calculator.multiply(2.5,4.0), 0.001);
    }
    @Test
    public void shouldQuotientOfTwoInteger(){
        //Act, Arrange, assert
        int expectedValue = 22;
        assertEquals(expectedValue, calculator.divide(44,2));
    }
    @Test
    public void shouldQuotientOfTwoDouble(){
      //Act, Arrange, assert
        double expectedValue = 2.0;
        assertEquals(expectedValue, calculator.divide(11.2,5.6), 0.001);
    }

}