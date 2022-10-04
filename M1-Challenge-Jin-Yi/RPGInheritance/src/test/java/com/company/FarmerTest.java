package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmerTest {
    private Farmer farmer1;

    @Before
    public void setUp(){
        farmer1 = new Farmer("good", "farmer1");
    }
    @Test
    public void shouldReturnFarmerValue(){
        //act, arrange, assert
        assertEquals(false, farmer1.isPlowing());
        assertEquals(false, farmer1.isHarvesting());
        assertEquals(75, farmer1.strength);
        assertEquals(100, farmer1.health);
        assertEquals(75, farmer1.stamina);
        assertEquals(10, farmer1.speed);
        assertEquals(1, farmer1.attackPower);
        assertEquals(false, farmer1.running);
        assertEquals(false, farmer1.arrested);

    }

}