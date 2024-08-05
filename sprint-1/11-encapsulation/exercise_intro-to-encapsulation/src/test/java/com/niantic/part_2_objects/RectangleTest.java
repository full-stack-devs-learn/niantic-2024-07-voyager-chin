package com.niantic.part_2_objects;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RectangleTest extends ReflectionBase<Rectangle>
{
    Class<Rectangle> klass;

    @BeforeEach
    void setup()
    {
        klass = Rectangle.class;
    }

    @Test
    public void rectangle_shouldHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterless constructor.\n");
    }

    @Test
    public void rectangle_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int, int).\n");
    }

    @Test
    public void rectangle_shouldHave_getWidth()
    {
        // arrange
        // act
        var method = getMethod(klass, "getWidth");

        // assert
        assertNotNull(method, "\nThere should be a getWidth getter method.\n");
    }

    @Test
    public void rectangle_shouldHave_setWidth()
    {
        // arrange
        // act
        var method = getMethod(klass, "setWidth", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setWidth setter method - with int input.\n");
    }

    @Test
    public void rectangle_shouldHave_getHeight()
    {
        // arrange
        // act
        var method = getMethod(klass, "getWidth");

        // assert
        assertNotNull(method, "\nThere should be a getHeight getter method.\n");
    }

    @Test
    public void rectangle_shouldHave_setHeight()
    {
        // arrange
        // act
        var method = getMethod(klass, "setWidth", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setHeight setter method - with int input.\n");
    }

    @Test
    public void rectangle_shouldHave_getArea()
    {
        // arrange
        // act
        var method = getMethod(klass, "getArea");

        // assert
        assertNotNull(method, "\nThere should be a getArea getter method.\n");
    }

    @Test
    public void getArea_should_calculateArea() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, Integer.TYPE);
        var method = getMethod(klass, "getArea");
        var instance = constructor.newInstance(10,5);

        // act
        Object result = method.invoke(instance);
        int actual = (int)result;

        // assert
        assertEquals(50,actual, "\nWidth 10 and Height 5 should create an area of 50");
    }

}