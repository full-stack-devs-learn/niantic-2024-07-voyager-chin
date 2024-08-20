package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest extends ReflectionBase<Wizard>
{
    Class<Wizard> klass;

    @BeforeEach
    void setup()
    {
        klass = Wizard.class;
    }

    @Test
    public void wizard_should_extendCharacter() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 200, 1, 200, 100);

        // act
        assertInstanceOf(Character.class, champ, "\nWizard should extend Character");
    }

    @Test
    public void wizard_shouldHave_correctConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);

        // assert
        assertNotNull(constructor, "\nWizard should have a public constructor with (String name, int health, int level, int experience, int mana)");
    }

    @Test
    public void wizard_shouldHave_getMana()
    {
        // arrange
        // act
        var method = getMethod(klass, "getMana");

        // assert
        assertNotNull(method, "\nWizard should have a getMana() getter method");
    }

    @Test
    public void wizard_shouldNotHave_setMana()
    {
        // arrange
        // act
        var method = getMethod(klass, "setMana", Integer.TYPE);

        // assert
        assertNull(method, "\nWizard should NOT have a setMana(int manage) setter method");
    }

    @Test
    public void wizard_shouldHave_castSpell()
    {
        // arrange
        // act
        var method = getMethod(klass, "castSpell", Character.class);

        // assert
        assertNotNull(method, "\nWizard should have a castSpell(Character character) method");
    }

    @Test
    public void wizard_shouldHave_regenerateMana()
    {
        // arrange
        // act
        var method = getMethod(klass, "regenerateMana", Integer.TYPE);

        // assert
        assertNotNull(method, "\nWizard should have a regenerateMana(int mana) method");
    }

    @Test
    public void attack_should_useBaseCharacterLogic() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 200, 1, 200, 100);
        var attack = getMethod(klass, "attack", Character.class);

        var enemy = new Character("Villain", 50, 1, 100);

        // act
        attack.invoke(champ, enemy);

        // assert
        var expectedHealth = 40;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the wizard attacked without using a spell.");

    }

    @Test
    public void castSpell_should_useCastSpellLogic() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 200, 1, 200, 100);
        var castSpell = getMethod(klass, "castSpell", Character.class);

        var enemy = new Character("Villain", 50, 1, 100);

        // act
        castSpell.invoke(champ, enemy);

        // assert
        var expectedHealth = 30;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the wizard attacked with a spell.");

    }

    @Test
    public void castSpell_shouldNot_workWithoutMana() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 200, 1, 200, 0);
        var castSpell = getMethod(klass, "castSpell", Character.class);

        var enemy = new Character("Villain", 50, 1, 100);

        // act
        castSpell.invoke(champ, enemy);

        // assert
        var expectedHealth = 50;
        var actualHealth = enemy.getHealth();
        assertEquals(expectedHealth, actualHealth, "Because the wizard had no mana, and can't cast a spell.");

    }

    @Test
    public void levelUp_should_increase_healthLevelAndMana() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 200, 1, 200, 100);
        var getMana = getMethod(klass, "getMana");

        // act
        champ.levelUp();

        // assert
        Object mana = getMana.invoke(champ);

        var expectedHealth = 210;
        var expectedLevel = 2;
        var expectedMana = 110;

        var actualHealth = champ.getHealth();
        var actualLevel = champ.getLevel();
        var actualMana = (int)mana;

        assertEquals(expectedHealth, actualHealth, "Because the wizard leveled up which should have added health.");
        assertEquals(expectedLevel, actualLevel, "Because the wizard leveled up.");
        assertEquals(expectedMana, actualMana, "Because the wizard leveled up which should have added mana.");

    }

    @Test
    public void levelUp_shouldNot_increase_healthLevelOfMana_forDefeatedWizard() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 0, 1, 200, 100);
        var getMana = getMethod(klass, "getMana");

        // act
        champ.levelUp();

        // assert
        Object mana = getMana.invoke(champ);

        var expectedHealth = 0;
        var expectedLevel = 1;
        var expectedMana = 100;

        var actualHealth = champ.getHealth();
        var actualLevel = champ.getLevel();
        var actualMana = (int)mana;

        assertEquals(expectedHealth, actualHealth, "Because the wizard should NOT have leveled up.");
        assertEquals(expectedLevel, actualLevel, "Because the wizard should NOT have leveled up.");
        assertEquals(expectedMana, actualMana, "Because the wizard should NOT have leveled up.");

    }

    @Test
    public void regenerateMana_should_increaseMana() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 200, 1, 200, 0);
        var regenerateMana = getMethod(klass, "regenerateMana", Integer.TYPE);
        var getMana = getMethod(klass, "getMana");

        // act
        regenerateMana.invoke(champ, 10);

        // assert
        Object mana = getMana.invoke(champ);

        var expectedMana = 10;

        var actualMana = (int)mana;

        assertEquals(expectedMana, actualMana, "Wizard should get 10 extra units of mana with regenerate call.");

    }

    @Test
    public void regenerateMana_shouldNot_increaseMana_forDefeatedWizard() throws InvocationTargetException, InstantiationException, IllegalAccessException
    {
        // arrange
        var constructor = getConstructor(klass, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var champ = constructor.newInstance("Gandalf", 0, 1, 200, 0);
        var regenerateMana = getMethod(klass, "regenerateMana", Integer.TYPE);
        var getMana = getMethod(klass, "getMana");

        // act
        regenerateMana.invoke(champ, 10);

        // assert
        Object mana = getMana.invoke(champ);

        var expectedMana = 0;

        var actualMana = (int)mana;

        assertEquals(expectedMana, actualMana, "Defeated Wizard should NOT get 10 extra units of mana with regenerate call.");

    }

}