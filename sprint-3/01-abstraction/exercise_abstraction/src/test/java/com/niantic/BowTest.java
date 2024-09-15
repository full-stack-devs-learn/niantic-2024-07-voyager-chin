package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.*;

class BowTest
{
    private Bow bow;
    private Bow bowPoison;
    private Bow bowExplosive;

    Timer timer = new Timer();
    boolean isArrowReplenished = false;
    int actualArrows = 0;
    boolean isChargeCompleted = false;
    int actualCharge = 0;

    @BeforeEach
    public void setup()
    {
        bow = new Bow("Crossbow", 5, "standard", 7);
        bowPoison = new Bow("Crossbow", 5, "poison", 7);
        bowExplosive = new Bow("Crossbow", 5, "explosive", 7);
    }

    @Test
    void attack_shouldReturn_correctDamage()
    {
        //arrange
        int expectedStandardDmg = 5;
        int expectedPoisonDmg = 10;
        int expectedExplosiveDmg = 15;

        //act
        int actualStandardDmg = bow.attack();
        int actualPoisonDmg = bowPoison.attack();
        int actualExplosiveDmg = bowExplosive.attack();

        //assert
        assertEquals(expectedStandardDmg, actualStandardDmg, "Because standard arrow should return default damage");
        assertEquals(expectedPoisonDmg, actualPoisonDmg, "Because poison arrow should return 2x damage");
        assertEquals(expectedExplosiveDmg, actualExplosiveDmg, "Because explosive arrow should return 3x damage");
    }

    @Test
    void arrows_shouldReplenish_everyFiveSeconds()
    {
        //arrange
        int initialArrows = bow.getArrowCount();
        int expectedArrows = initialArrows + 1;

        //act
        TimerTask updateArrows = new TimerTask() {
            @Override
            public void run() {
                actualArrows = bow.getArrowCount();
                isArrowReplenished = true;
            }
        };
        timer.schedule(updateArrows, 5500);
        while(!isArrowReplenished)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        //assert
        assertEquals(expectedArrows, actualArrows, "Because arrows are replenished 1 at a time in 5 second intervals");
    }

    @Test
    void percentCharge_shouldIncrease_everyTwoSeconds()
    {
        //arrange
        int initialCharge = bow.getPercentCharged();
        int expectedCharge = initialCharge + 20;

        //act
        TimerTask getCharge = new TimerTask() {
            @Override
            public void run() {
                actualCharge = bow.getPercentCharged();
                isChargeCompleted = true;
            }
        };
        timer.schedule(getCharge, 3000);
        while(!isChargeCompleted) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        //assert
        assertEquals(expectedCharge, actualCharge, "Because percentCharge increases by 20% every 2 seconds");
    }

    @Test
    void powerAttack_shouldDeliver_doubleAttackForFiveSeconds()
    {
        //arrange
        int expectedDamage = 490;
        int expectedChargeAfter = 0;
        //act
        bowPoison.setPercentCharged(100);
        int actualDamage = bowPoison.powerAttack();
        int actualChargeAfter = bowPoison.getPercentCharged();
        //assert
        assertEquals(expectedDamage, actualDamage, "Because power attack delivers double attack power for 5 seconds");
        assertEquals(expectedChargeAfter, actualChargeAfter, "Because power attack should reset percent charge");
    }

    @Test
    void getRange_shouldReturn_20()
    {
        //arrange
        int expectedRange = 20;
        //act
        int actualRange = bow.getRange();
        //assert
        assertEquals(expectedRange, actualRange, "Bow should return 20 range");
    }
}