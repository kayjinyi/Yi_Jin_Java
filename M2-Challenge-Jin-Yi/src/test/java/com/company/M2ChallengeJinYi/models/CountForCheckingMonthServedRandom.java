package com.company.M2ChallengeJinYi.models;
import static org.junit.Assert.assertTrue;
public class CountForCheckingMonthServedRandom {

        private int number;
        private int value = 0;
        public CountForCheckingMonthServedRandom(int number) {
            this.number = number;
        }
        public void inc() {
            value++;
        }
        public void assertInBetween(int lower, int upper) {
            assertTrue(number + " - " + value + " > " + lower, value >= lower);
            assertTrue(number + " - " + value + " < " + upper, value <= upper);
        }
    }

