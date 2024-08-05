package com.niantic.part_2_objects;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CircleTest extends ReflectionBase<Circle>
{

    Class<Circle> klass;

    @BeforeEach
    void setup()
    {
        klass = Circle.class;
    }

    @Test
    public void circle_shouldHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterless constructor.\n");
    }

    @Test
    public void circle_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int).\n");
    }

    @Test
    public void circle_shouldHave_getRadius()
    {
        // arrange
        // act
        var method = getMethod(klass, "getRadius");

        // assert
        assertNotNull(method, "\nThere should be a getRadius getter method.\n");
    }

    @Test
    public void circle_shouldHave_setRadius()
    {
        // arrange
        // act
        var method = getMethod(klass, "setRadius", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setRadius setter method - with int input.\n");
    }

    @Test
    public void circle_shouldHave_getArea()
    {
        // arrange
        // act
        var method = getMethod(klass, "getArea");

        // assert
        assertNotNull(method, "\nThere should be a getArea getter method.\n");
    }

    @Test
    public void circle_shouldHave_getDiameter()
    {
        // arrange
        // act
        var method = getMethod(klass, "getDiameter");

        // assert
        assertNotNull(method, "\nThere should be a getDiameter getter method.\n");
    }

    @Test
    public void circle_shouldHave_getCircumference()
    {
        // arrange
        // act
        var method = getMethod(klass, "getCircumference");

        // assert
        assertNotNull(method, "\nThere should be a getCircumference getter method.\n");
    }

    @Test
    public void getArea_should_calculateArea() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE);
        var method = getMethod(klass, "getArea");
        var instance = constructor.newInstance(10);

        // act
        Object result = method.invoke(instance);
        double actual = (double)result;

        // assert
        assertEquals(314.15,actual, .2, "\nRadius 10 should create an area of 314.15");
    }

    @Test
    public void getDiameter_should_calculateDiameter() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE);
        var method = getMethod(klass, "getDiameter");
        var instance = constructor.newInstance(10);

        // act
        Object result = method.invoke(instance);
        int actual = (int)result;

        // assert
        assertEquals(20,actual, "\nRadius 10 should create a diameter of 20");
    }

    @Test
    public void getCircumference_should_calculateCircumferece() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE);
        var method = getMethod(klass, "getCircumference");
        var instance = constructor.newInstance(10);

        // act
        Object result = method.invoke(instance);
        double actual = (double)result;

        // assert
        assertEquals(62.83,actual, .2, "\nRadius 10 should create an circumference of 62.83");
    }
}