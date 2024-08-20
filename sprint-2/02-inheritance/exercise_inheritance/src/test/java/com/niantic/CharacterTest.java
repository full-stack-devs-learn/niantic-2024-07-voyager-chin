package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest
{


    @Test
    public void newCharacter_shouldNot_beDefeated()
    {
        // arrange
        int health = 50;

        // act
        var champ = new Character("Champ", health, 1, 100);

        // assert
        assertEquals(health, champ.getHealth(), "The character was created with 50 health and has not taken a hit.");
        assertFalse(champ.isDefeated(), "Because a new character should not be defeated");
    }

    @Test
    public void attack_should_diminishEnemyHealth()
    {
        // arrange
        var champ = new Character("Champ", 50, 1, 100);
        var enemy = new Character("Villain", 50, 1, 100);

        // act
        champ.attack(enemy);

        // assert
        var expectedHealth = 40;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the champ attacked the enemy");
    }

    @Test
    public void attack_shouldNot_bePossible_forDefeatedCharacter()
    {
        // arrange
        var champ = new Character("Champ", 0, 1, 100);
        var enemy = new Character("Villain", 50, 1, 100);

        // act
        champ.attack(enemy);

        // assert
        var expectedHealth = 50;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the champ is defeated and should not be able to attack");

    }

    @Test
    public void attack_should_defeatEnemy()
    {
        // arrange
        var champ = new Character("Champ", 50, 1, 100);
        var enemy = new Character("Villain", 50, 1, 100);

        // act
        champ.attack(enemy);
        champ.attack(enemy);
        champ.attack(enemy);
        champ.attack(enemy);
        champ.attack(enemy);

        // assert
        var expectedHealth = 0;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the champ attacked the enemy");
        assertTrue(enemy.isDefeated(), "The enemy has taken too many hits and should be defeated.");
    }

    @Test
    public void levelUp_should_addHealth()
    {
        // arrange
        var champ = new Character("Champ", 50, 1, 100);

        // act
        champ.levelUp();

        // assert
        var expectedHealth = 60;
        var actualHealth = champ.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the champ leveled up");
    }

    @Test
    public void levelUp_should_notChangeHealth_OrLevel_forDefeatedCharacter()
    {
        // arrange
        var champ = new Character("Champ", 10, 1, 100);
        champ.takeDamage(10);

        // act
        champ.levelUp();

        // assert
        assertTrue(champ.isDefeated(), "The champ should have been defeated");
        assertEquals(1, champ.getLevel(), "The level should not have changed for a defeated character");
        assertEquals(0, champ.getHealth(), "A defeated character should not be able to regain health.");
    }
}