package com.niantic.part_1_sakila_dtos;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ActorTest extends ReflectionBase<Actor>
{
    Class<Actor> klass;

    @BeforeEach
    void setUp()
    {
        klass = Actor.class;
    }

    @Test
    public void actor_shouldHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterless constructor.\n");
    }

    @Test
    public void actor_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, String.class, String.class);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int, String, String).\n");
    }

    @Test
    public void actor_shouldHave_getActorId()
    {
        // arrange
        // act
        var method = getMethod(klass, "getActorId");

        // assert
        assertNotNull(method, "\nThere should be a getActorId getter method.\n");
    }

    @Test
    public void actor_shouldHave_getFirstName()
    {
        // arrange
        // act
        var method = getMethod(klass, "getFirstName");

        // assert
        assertNotNull(method, "\nThere should be a getFirstName getter method.\n");
    }

    @Test
    public void actor_shouldHave_getLastName()
    {
        // arrange
        // act
        var method = getMethod(klass, "getLastName");

        // assert
        assertNotNull(method, "\nThere should be a getLastName getter method.\n");
    }

    @Test
    public void actor_shouldHave_setActorId()
    {
        // arrange
        // act
        var method = getMethod(klass, "setActorId", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setActorId setter method - with int input.\n");
    }

    @Test
    public void actor_shouldHave_setFirstName()
    {
        // arrange
        // act
        var method = getMethod(klass, "setFirstName", String.class);

        // assert
        assertNotNull(method, "\nThere should be a setFirstName setter method - with String input.\n");
    }

    @Test
    public void actor_shouldHave_setLastName()
    {
        // arrange
        // act
        var method = getMethod(klass, "setLastName", String.class);

        // assert
        assertNotNull(method, "\nThere should be a setLastName setter method - with String input.\n");
    }


    @Test
    public void actor_shouldHave_getFullName()
    {
        // arrange
        // act
        var method = getMethod(klass, "getFullName");

        // assert
        assertNotNull(method, "\nThere should be a getFullName derived getter method.\n");
    }
}