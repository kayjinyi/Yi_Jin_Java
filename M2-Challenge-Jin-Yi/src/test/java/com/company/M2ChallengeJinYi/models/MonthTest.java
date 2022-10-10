package com.company.M2ChallengeJinYi.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashMap;
import java.util.Map;

public class MonthTest {

    private Map<Integer, CountForCheckingMonthServedRandom> numberCounts;
    private Month month;
    @BeforeEach
    public void setup() {
        month = new Month();
        numberCounts = new HashMap<Integer, CountForCheckingMonthServedRandom>();
    }
    @RepeatedTest(value = 100)
    public void createRandomMonth() {
        int samples = 10000;
        double deviation = 0.05;
        for (int i = 0; i < 12 * samples; i++) {

            int number = month.randomMonth();
            CountForCheckingMonthServedRandom numberCount = numberCounts.computeIfAbsent(number , CountForCheckingMonthServedRandom::new);
            numberCount.inc();
        }
        int lowerBound = (int) Math.floor((double) samples * (1.0 - deviation));
        int upperBound = (int) Math.floor((double) samples * (1.0 + deviation));
        for (CountForCheckingMonthServedRandom numberCount : numberCounts.values()) {
            numberCount.assertInBetween(lowerBound, upperBound);
        }
    }

}