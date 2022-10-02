package com.company;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstableTest {

    private Constable constable1;

    @Before
    public void setUp(){
        constable1 = new Constable();
    }

    @Test
    public void shouldReturnConstableValue(){
        //act, arrange, assert
        assertEquals(60, constable1.strength);
        assertEquals(100, constable1.health);
        assertEquals(60, constable1.stamina);
        assertEquals(20, constable1.speed);
        assertEquals(5, constable1.attackPower);
        assertEquals(false, constable1.isRunning());
        assertEquals(false, constable1.isArrested());
    }
}