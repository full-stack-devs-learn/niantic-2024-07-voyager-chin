package com.niantic.part_3_challenge;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class RefrigeratorTest extends ReflectionBase<Refrigerator>
{
    Class<Refrigerator> klass;

    @BeforeEach
    void setup()
    {
        klass = Refrigerator.class;
    }

    @Test
    public void refrigerator_shouldNotHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNull(constructor, "\nThere should NOT be a parameterless constructor.\n");
    }

    @Test
    public void refrigerator_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int currentTemperature, int maxCapacity).\n");
    }

    @Test
    public void refrigerator_shouldHave_getCurrentTemperature()
    {
        // arrange
        // act
        var method = getMethod(klass, "getCurrentTemperature");

        // assert
        assertNotNull(method, "\nThere should be a getCurrentTemperature getter method.\n");
    }

    @Test
    public void refrigerator_shouldHave_getMaxCapacity()
    {
        // arrange
        // act
        var method = getMethod(klass, "getMaxCapacity");

        // assert
        assertNotNull(method, "\nThere should be a getMaxCapacity getter method.\n");
    }

    @Test
    public void refrigerator_shouldHave_isDoorOpen()
    {
        // arrange
        // act
        var method = getMethod(klass, "isDoorOpen");

        // assert
        assertNotNull(method, "\nThere should be a isDoorOpen getter method.\n");
    }

    @Test
    public void refrigerator_shouldHave_openDoor()
    {
        // arrange
        // act
        var method = getMethod(klass, "openDoor");

        // assert
        assertNotNull(method, "\nThere should be a openDoor method.\n");
    }

    @Test
    public void refrigerator_shouldHave_addItem()
    {
        // arrange
        // act
        var method = getMethod(klass, "addItem", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a addItem method - with int input.\n");
    }

    @Test
    public void refrigerator_shouldHave_removeItem()
    {
        // arrange
        // act
        var method = getMethod(klass, "removeItem", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a removeItem method - with int input.\n");
    }

    @Test
    public void addItem_should_allowUsersToAddToFridge() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);
        var openDoor = getMethod(klass, "openDoor");
        var addItem = getMethod(klass, "addItem", Integer.TYPE);
        var instance = constructor.newInstance(30, 100);
        openDoor.invoke(instance);

        // act
        Object result = addItem.invoke(instance, 50);
        boolean actual = (boolean)result;

        // assert
        assertTrue(actual, "\nCapacity of 100 should allow adding item of size 50");
    }

    @Test
    public void addItem_shouldNot_allowUsersToAddToFridge_whenClosed() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);
        var addItem = getMethod(klass, "addItem", Integer.TYPE);
        var instance = constructor.newInstance(30, 100);
        // don't open door

        // act
        Object result = addItem.invoke(instance, 50);
        boolean actual = (boolean)result;

        // assert
        assertFalse(actual, "\nItems cannot be added when the door is closed");
    }

    @Test
    public void addItem_shouldNot_allowUsersToAddToFridge_whenThereIsNoRoom() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);
        var openDoor = getMethod(klass, "openDoor");
        var addItem = getMethod(klass, "addItem", Integer.TYPE);
        var instance = constructor.newInstance(30, 100);
        openDoor.invoke(instance);

        // act
        Object result = addItem.invoke(instance, 150);
        boolean actual = (boolean)result;

        // assert
        assertFalse(actual, "\nCapacity of 100 should NOT allow adding item of size 150");
    }

    @Test
    public void removeItem_should_changeAvailableCapacity() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);
        var openDoor = getMethod(klass, "openDoor");
        var getAvailableCapacity = getMethod(klass, "getAvailableCapacity");
        var addItem = getMethod(klass, "addItem", Integer.TYPE);
        var removeItem = getMethod(klass, "removeItem", Integer.TYPE);
        var instance = constructor.newInstance(30, 100);
        openDoor.invoke(instance);
        addItem.invoke(instance, 50);

        // act
        removeItem.invoke(instance, 25);
        Object result = getAvailableCapacity.invoke(instance);
        int actual = (int)result;

        // assert
        assertEquals(75, actual, "\nCapacity: 100 - Available Capacity: 50 - Remove Capacity: 25 - New Available Capacity Should be: 75");
    }
}