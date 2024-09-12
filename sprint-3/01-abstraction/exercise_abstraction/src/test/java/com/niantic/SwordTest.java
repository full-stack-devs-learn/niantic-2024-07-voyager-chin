package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest
{
    Sword sword;

    @BeforeEach
    public void setup()
    {
        sword = new Sword("Excalibur", 10);
    }

    @Test
    public void attack_shouldDeliver_defaultDamage()
    {
        //Arrange
        int expectedDamage = 10;

        //Act
        int actualDamage = sword.getDamage();

        //Assert
        assertEquals(expectedDamage, actualDamage, "Because damage should return default damage of 10");
    }

    @Test
    public void attack_shouldAdd_tenPercentCharge()
    {
        //Arrange
        int expectedCharge = 20;

        //Act
        sword.attack();
        sword.attack();
        int actualCharge = sword.getPercentCharged();

        //Assert
        assertEquals(expectedCharge, actualCharge, "Because percentCharge should be 20 after attacking 2x");
    }

    @Test
    public void percentCharged_cannotExceed_hundredPercent()
    {
        //Arrange
        int expectedPercentCharged = 100;

        //Act
        for (int i = 0; i < 12; i++) {
            sword.attack();
        }
        int actualPercentCharged = sword.getPercentCharged();

        //Assert
        assertEquals(expectedPercentCharged, actualPercentCharged, "Because percent charged cannot exceed 100%");
    }

    @ParameterizedTest
    @CsvSource({"100,40", "70,20", "30,10", "0, 0"})
    void powerAttack_shouldDeliver_correctDamage(int percentCharged, int expectedPercentCharged)
    {
        sword.setPercentCharged(percentCharged);
        int actualPowerDamage = sword.powerAttack();

        assertEquals(expectedPercentCharged, actualPowerDamage, "Because < 50% just performs a regular attack, 50% - 90% delivers double blow, 100% delivers 4x blow");
    }

    @ParameterizedTest
    @CsvSource({"100,0", "70,35", "30,30", "0, 0"})
    void powerAttack_shouldReduce_correctCharge(int percentCharged, int expectedPercentCharged)
    {
        sword.setPercentCharged(percentCharged);
        sword.powerAttack();
        int actualPercentCharged = sword.getPercentCharged();

        assertEquals(expectedPercentCharged, actualPercentCharged);
    }

    @Test
    void getRange_shouldReturn_1()
    {
        int expectedRange = 1;
        int actualRange = sword.getRange();

        assertEquals(expectedRange, actualRange, "Because sword range should be 1");
    }
}