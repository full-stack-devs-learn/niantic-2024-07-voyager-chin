package com.niantic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponTest extends ReflectionBase<Weapon>
{

    Class<Weapon> klass;

    @BeforeEach
    void setup()
    {
        klass = Weapon.class;
    }

    @Test
    public void weapon_shouldBe_Abstract()
    {
        // arrange
        int modifiers = klass.getModifiers();

        // act/assert
        assertTrue(Modifier.isAbstract(modifiers));
    }

    @Test
    public void weapon_should_haveAttack()
    {
        // arrange
        // act
        var method = getMethod(klass, "attack");

        // assert
        assertNotNull(method, "\nWeapon should have attack method");
    }

    @Test
    public void attack_shouldBe_abstract()
    {
        // arrange
        // act
        var method = getMethod(klass, "attack");
        int modifiers = method.getModifiers();

        // assert
        assertTrue(Modifier.isAbstract(modifiers));
    }

    @Test
    public void weapon_should_havePowerAttack()
    {
        // arrange
        // act
        var method = getMethod(klass, "powerAttack");

        // assert
        assertNotNull(method, "\nWeapon should have powerAttack method");
    }

    @Test
    public void powerAttack_shouldBe_abstract()
    {
        // arrange
        // act
        var method = getMethod(klass, "powerAttack");
        int modifiers = method.getModifiers();

        // assert
        assertTrue(Modifier.isAbstract(modifiers));
    }


    @Test
    public void weapon_should_haveGetRange()
    {
        // arrange
        // act
        var method = getMethod(klass, "getRange");

        // assert
        assertNotNull(method, "\nWeapon should have getRange method");
    }

    @Test
    public void getRange_shouldBe_abstract()
    {
        // arrange
        // act
        var method = getMethod(klass, "getRange");
        int modifiers = method.getModifiers();

        // assert
        assertTrue(Modifier.isAbstract(modifiers));
    }
}
