package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest
{
    private Knight knight;
    private Character villain;

    @BeforeEach
    public void setup()
    {
        knight = new Knight("Lancelot", 80, 10, 75, 50);
        villain = new Character("Villain", 80, 10, 75);
    }

    // getArmor() returns the amount of mana of the wizard
    @Test
    void getArmor_shouldReturn_correctArmor()
    {
        // Arrange
        int expectedArmor = 50;

        // Act
        int actualArmor = knight.getArmor();

        // Assert
        assertEquals(expectedArmor, actualArmor, "Because new Knight was created with 50 armor as argument");
    }

    //@Override takeDamage() is overridden to add logic to allow the armor to deflect a blow
    @Test
    void takeDamage_shouldBe_deflectedByArmor()
    {
        // Arrange
        int expectedHealth = 30;

        // Act
        for (int i = 0; i < 10; i++) {
            if(!knight.isDefeated()) { villain.attack(knight); }
        }
        int actualHealth = knight.getHealth();

        // Assert
        assertEquals(expectedHealth, actualHealth, "Because knight should still have remaining health if he started with armor.");
    }

    // @Override levelUp() should perform all of the levelUp functions of a character
    @Test
    void overrideLevelUp_shouldPerform_allCharacterLevelUp()
    {
        // Arrange
        int expectedLevel = 11;
        int expectedHealth = 90;

        // Act
        knight.levelUp();
        int actualLevel = knight.getLevel();
        int actualHealth = knight.getHealth();

        // Assert
        assertEquals(expectedLevel, actualLevel, "Because levelUp() should increase the level by 1 points");
        assertEquals(expectedHealth, actualHealth, "Because levelUp() should increase the armor by 10 points");

    }

    //levelUp() should also increase the armor by 5 points
    @Test
    void overrideLevelUp_shouldIncrease_armorBy5Points()
    {
        // Arrange
        int expectedArmor = 55;

        // Act
        knight.levelUp();
        int actualArmor = knight.getArmor();

        // Assert
        assertEquals(expectedArmor, actualArmor, "Because levelUp() should increase the armor by 5 points");
    }

    //@Override specialAbility() for the wizard should return Armor Shield
    @Test
    void specialAbility_shouldReturn_ArmorShield()
    {
        // Arrange
        String expectedReturn = "Armor Shield";

        // Act
        String actualReturn = knight.specialAbility();

        // Assert
        assertEquals(expectedReturn, actualReturn);
    }
}