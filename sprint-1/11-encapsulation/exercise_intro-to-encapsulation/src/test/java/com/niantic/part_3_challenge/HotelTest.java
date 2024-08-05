package com.niantic.part_3_challenge;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest extends ReflectionBase<Hotel>
{
    Class<Hotel> klass;

    @BeforeEach
    void setup()
    {
        klass = Hotel.class;
    }

    @Test
    public void hotel_shouldNotHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNull(constructor, "\nThere should NOT be a parameterless constructor.\n");
    }

    @Test
    public void hotel_shouldHave_parameterizedConstructor_with2params()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int numberOfRooms, int numberOfSuites).\n");
    }

    @Test
    public void hotel_shouldHave_parameterizedConstructor_with4params()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites).\n");
    }

    @Test
    public void hotel_shouldHave_getNumberOfRooms()
    {
        // arrange
        // act
        var method = getMethod(klass, "getNumberOfRooms");

        // assert
        assertNotNull(method, "\nThere should be a getNumberOfRooms method.\n");
    }

    @Test
    public void hotel_shouldHave_getNumberOfSuites()
    {
        // arrange
        // act
        var method = getMethod(klass, "getNumberOfSuites");

        // assert
        assertNotNull(method, "\nThere should be a getNumberOfSuites method.\n");
    }

    @Test
    public void hotel_shouldHave_getAvailableRooms()
    {
        // arrange
        // act
        var method = getMethod(klass, "getAvailableRooms");

        // assert
        assertNotNull(method, "\nThere should be a getAvailableRooms method.\n");
    }

    @Test
    public void hotel_shouldHave_getAvailableSuites()
    {
        // arrange
        // act
        var method = getMethod(klass, "getAvailableSuites");

        // assert
        assertNotNull(method, "\nThere should be a getAvailableSuites method.\n");
    }

    @Test
    public void hotel_shouldHave_makeReservation()
    {
        // arrange
        // act
        var method = getMethod(klass, "makeReservation", Integer.TYPE, Boolean.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a makeReservation method - (int numberOfRooms, boolean isSuite).\n");
    }

    @Test
    public void makeReservation_should_allowSuite_whenAvailable() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var makeReservation = getMethod(klass, "makeReservation", Integer.TYPE, Boolean.TYPE);
        var instance = constructor.newInstance(20,10,10,5);
        var getAvailableSuites = getMethod(klass, "getAvailableSuites");

        // act
        Object result = makeReservation.invoke(instance, 2, true);
        boolean actual = (boolean)result;
        Object newRoomsResult = getAvailableSuites.invoke(instance);
        int actualRooms = (int)newRoomsResult;

        // assert
        assertTrue(actual, "There are 10 suites, 5 are booked, I should be able to make a reservation for 2");
        assertEquals(3, actualRooms, "\nWith 5 available suites, if I book 2, there should be 3 available suites.");
    }

    @Test
    public void makeReservation_shouldNot_allowSuite_whenNoRoomsAvailable() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var makeReservation = getMethod(klass, "makeReservation", Integer.TYPE, Boolean.TYPE);
        var instance = constructor.newInstance(20,10,10,10);
        var getAvailableSuites = getMethod(klass, "getAvailableSuites");

        // act
        Object result = makeReservation.invoke(instance, 2, true);
        boolean actual = (boolean)result;
        Object newRoomsResult = getAvailableSuites.invoke(instance);
        int actualRooms = (int)newRoomsResult;

        // assert
        assertFalse(actual, "There are 10 suites, 10 are booked, I should NOT be able to make a reservation for 2");
        assertEquals(0, actualRooms, "\nWith 0 available suites, if I try to book 2, there should still be 0 available suites.");
    }

    @Test
    public void makeReservation_should_allowRooms_whenAvailable() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var makeReservation = getMethod(klass, "makeReservation", Integer.TYPE, Boolean.TYPE);
        var instance = constructor.newInstance(20,10,10,5);
        var getAvailableRooms = getMethod(klass, "getAvailableRooms");

        // act
        Object result = makeReservation.invoke(instance, 2, false);
        boolean actual = (boolean)result;
        Object newRoomsResult = getAvailableRooms.invoke(instance);
        int actualRooms = (int)newRoomsResult;

        // assert
        assertTrue(actual, "There are 20 rooms, 10 are booked, I should be able to make a reservation for 2");
        assertEquals(8, actualRooms, "\nWith 10 available suites, if I book 2, there should be 8 available suites.");
    }

    @Test
    public void makeReservation_shouldNot_allowRooms_whenNoRoomsAvailable() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        var makeReservation = getMethod(klass, "makeReservation", Integer.TYPE, Boolean.TYPE);
        var instance = constructor.newInstance(20,10,20,10);
        var getAvailableRooms = getMethod(klass, "getAvailableRooms");

        // act
        Object result = makeReservation.invoke(instance, 2, false);
        boolean actual = (boolean)result;
        Object newRoomsResult = getAvailableRooms.invoke(instance);
        int actualRooms = (int)newRoomsResult;

        // assert
        assertFalse(actual, "There are 20 rooms, all 10 are booked, I should NOT be able to make a reservation for 2");
        assertEquals(0, actualRooms, "\nWith 0 available rooms, if I try to book 2, there should still be 0 available suites.");
    }

}