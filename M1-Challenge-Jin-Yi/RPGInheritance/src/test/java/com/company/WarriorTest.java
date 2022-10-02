package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {

    private Warrior warrior1;
    @Before
    public void setUp(){
        warrior1 = new Warrior();
    }
    @Test
    public void shouldReturnWarriorValue() {

        //act, arrange, assert

        assertEquals(75, warrior1.strength);
        assertEquals(100, warrior1.health);
        assertEquals(100, warrior1.stamina);
        assertEquals(50, warrior1.speed);
        assertEquals(10, warrior1.attackPower);
        assertEquals(100, warrior1.getShieldStrength());
        assertEquals(false, warrior1.isRunning());
        assertEquals(false, warrior1.isArrested());
    }

}