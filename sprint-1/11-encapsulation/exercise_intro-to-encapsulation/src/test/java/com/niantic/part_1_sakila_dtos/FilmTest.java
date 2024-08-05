package com.niantic.part_1_sakila_dtos;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FilmTest extends ReflectionBase<Film>
{
    Class<Film> klass;

    @BeforeEach
    void setUp()
    {
        klass = Film.class;
    }

    @Test
    public void film_shouldHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterless constructor.\n");
    }

    @Test
    public void film_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Double.TYPE, Integer.TYPE, Double.TYPE, String.class, String.class);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (filmId, title, description, releaseYer, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures).\n");
    }

    @Test
    public void film_shouldHave_getFilmId()
    {
        // arrange
        // act
        var method = getMethod(klass, "getFilmId");

        // assert
        assertNotNull(method, "\nThere should be a getFilmId getter method.\n");
    }

    @Test
    public void film_shouldHave_getTitle()
    {
        // arrange
        // act
        var method = getMethod(klass, "getTitle");

        // assert
        assertNotNull(method, "\nThere should be a getTitle getter method.\n");
    }

    @Test
    public void film_shouldHave_getDescription()
    {
        // arrange
        // act
        var method = getMethod(klass, "getDescription");

        // assert
        assertNotNull(method, "\nThere should be a getDescription getter method.\n");
    }

    @Test
    public void film_shouldHave_getReleaseYear()
    {
        // arrange
        // act
        var method = getMethod(klass, "getReleaseYear");

        // assert
        assertNotNull(method, "\nThere should be a getReleaseYear getter method.\n");
    }

    @Test
    public void film_shouldHave_getLanguageId()
    {
        // arrange
        // act
        var method = getMethod(klass, "getLanguageId");

        // assert
        assertNotNull(method, "\nThere should be a getLanguageId getter method.\n");
    }

    @Test
    public void film_shouldHave_getRentalDuration()
    {
        // arrange
        // act
        var method = getMethod(klass, "getRentalDuration");

        // assert
        assertNotNull(method, "\nThere should be a getRentalDuration getter method.\n");
    }

    @Test
    public void film_shouldHave_getRentalRate()
    {
        // arrange
        // act
        var method = getMethod(klass, "getRentalRate");

        // assert
        assertNotNull(method, "\nThere should be a getRentalRate getter method.\n");
    }

    @Test
    public void film_shouldHave_getLength()
    {
        // arrange
        // act
        var method = getMethod(klass, "getLength");

        // assert
        assertNotNull(method, "\nThere should be a getLangth getter method.\n");
    }

    @Test
    public void film_shouldHave_getReplacementCost()
    {
        // arrange
        // act
        var method = getMethod(klass, "getReplacementCost");

        // assert
        assertNotNull(method, "\nThere should be a getReplacementCost getter method.\n");
    }

    @Test
    public void film_shouldHave_getRating()
    {
        // arrange
        // act
        var method = getMethod(klass, "getRating");

        // assert
        assertNotNull(method, "\nThere should be a getRating getter method.\n");
    }

    @Test
    public void film_shouldHave_getSpecialFeatures()
    {
        // arrange
        // act
        var method = getMethod(klass, "getSpecialFeatures");

        // assert
        assertNotNull(method, "\nThere should be a getSpecialFeatures getter method.\n");
    }


    // test setters


    @Test
    public void film_shouldHave_setFilmId()
    {
        // arrange
        // act
        var method = getMethod(klass, "setFilmId", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setFilmId setter method - with int input.\n");
    }

    @Test
    public void film_shouldHave_setTitle()
    {
        // arrange
        // act
        var method = getMethod(klass, "setTitle", String.class);

        // assert
        assertNotNull(method, "\nThere should be a setTitle setter method - with String input.\n");
    }

    @Test
    public void film_shouldHave_setDescription()
    {
        // arrange
        // act
        var method = getMethod(klass, "setDescription", String.class);

        // assert
        assertNotNull(method, "\nThere should be a setDescription setter method - with String input.\n");
    }

    @Test
    public void film_shouldHave_setReleaseYear()
    {
        // arrange
        // act
        var method = getMethod(klass, "setReleaseYear", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setReleaseYear setter method - with int input.\n");
    }

    @Test
    public void film_shouldHave_setLanguageId()
    {
        // arrange
        // act
        var method = getMethod(klass, "setLanguageId", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setLanguageId setter method - with int input.\n");
    }

    @Test
    public void film_shouldHave_setRentalDuration()
    {
        // arrange
        // act
        var method = getMethod(klass, "setRentalDuration", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setRentalDuration setter method - with int input.\n");
    }

    @Test
    public void film_shouldHave_setRentalRate()
    {
        // arrange
        // act
        var method = getMethod(klass, "setRentalRate", Double.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setRentalRate setter method - with double input.\n");
    }

    @Test
    public void film_shouldHave_setLength()
    {
        // arrange
        // act
        var method = getMethod(klass, "setLength", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setLength setter method - with int input.\n");
    }

    @Test
    public void film_shouldHave_setReplacementCost()
    {
        // arrange
        // act
        var method = getMethod(klass, "setReplacementCost", Double.TYPE);

        // assert
        assertNotNull(method, "\nThere should be a setReplacementCost setter method - with double input.\n");
    }

    @Test
    public void film_shouldHave_setRating()
    {
        // arrange
        // act
        var method = getMethod(klass, "setRating", String.class);

        // assert
        assertNotNull(method, "\nThere should be a setRating setter method - with String input.\n");
    }

    @Test
    public void film_shouldHave_setSpecialFeatures()
    {
        // arrange
        // act
        var method = getMethod(klass, "setSpecialFeatures", String.class);

        // assert
        assertNotNull(method, "\nThere should be a setSpecialFeatures setter method - with String input.\n");
    }

}