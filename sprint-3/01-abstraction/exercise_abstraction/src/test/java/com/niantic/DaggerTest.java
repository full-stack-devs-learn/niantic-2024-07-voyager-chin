package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DaggerTest
{
    private Dagger dagger;
    private Dagger dagger0;

    @BeforeEach
    public void setup()
    {
        dagger = new Dagger("Silver", 5, 2);
        dagger0 = new Dagger("Bronze", 5, 0);
    }

    @Test
    void attack_shouldDeliver_defaultDamage_ifDaggersExist()
    {
        // Arrange
        int expectedDamage = 5;
        int expectedNoDamage = 0;
        // Act
        int actualDamage = dagger.attack();
        int actualNoDamage = dagger0.attack();
        // Assert
        assertEquals(expectedDamage, actualDamage, "Because ");
        assertEquals(expectedNoDamage, actualNoDamage, "Because there are no daggers in the bag");
    }

    @Test
    void regularAttack_shouldNot_reduceDaggerCount()
    {
        // Arrange
        int expectedCount = 2;
        // Act
        dagger.attack();
        int actualCount = dagger.getDaggerCount();
        // Assert
        assertEquals(expectedCount, actualCount, "Because daggerCount should not reduce on regular attack");
    }

    @Test
    void attack_shouldAdd_percentChargeBy20Percent()
    {
        // Arrange
        int expectedCharge = 40;
        // Act
        dagger.attack();
        dagger.attack();
        int actualCharge = dagger.getPercentCharged();
        // Assert
        assertEquals(expectedCharge, actualCharge, "Because each throw charges the percentCharged by 20%");
    }

    @ParameterizedTest
    @CsvSource({"0,0", "99, 0", "100, 15"})
    void powerAttack_shouldReturn_3xDefaultDamage(int daggerCharge, int expectedDamage)
    {
        // Arrange
        dagger.setPercentCharged(daggerCharge);
        // Act
        int actualDamage = dagger.powerAttack();
        // Assert
        assertEquals(expectedDamage, actualDamage, "Because power attack can only be used on charge 100 and have 3x default damage");
    }

    @Test
    void powerAttack_shouldReduce_daggerCountBy1()
    {
        // Arrange
        int expectedCount = 1;
        dagger.setPercentCharged(100);
        // Act
        dagger.powerAttack();
        int actualCount = dagger.getDaggerCount();
        // Assert
        assertEquals(expectedCount, actualCount, "Because a dagger cannot be retrieved from a power attack");
    }

    @Test
    void getRange_shouldReturn_10()
    {
        // Arrange
        int expectedRange = 10;
        // Act
        int actualRange = dagger.getRange();
        // Assert
        assertEquals(expectedRange, actualRange, "Because getRange() returns 10");
    }

    @Test
    void addDagger_shouldAdd_add1ToDaggerCount()
    {
        // Arrange
        int expectedCount = 3;
        // Act
        dagger.addDagger();
        int actualCount = dagger.getDaggerCount();
        // Assert
        assertEquals(expectedCount, actualCount, "Because it should add another dagger to the daggerCount");
    }
}