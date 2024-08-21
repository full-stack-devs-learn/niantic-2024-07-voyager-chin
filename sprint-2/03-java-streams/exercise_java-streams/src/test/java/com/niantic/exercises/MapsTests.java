package com.niantic.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapsTests extends TestBase
{
    Maps maps;

    @BeforeEach
    public void init()
    {
        maps = new Maps();
    }

    @Test
    public void mapCompanyNames_shouldReturn_distinctListOfCompanyNames_inAlphabeticalOrder()
    {
        // arrange
        var orders = loadOrders();
        var expected = 89;
        var expectedFirst = "Alfreds Futterkiste";
        var expectedLast = "Wolski  Zajazd";

        // act
        var list = maps.mapCompanyNames(orders);

        // assert
        assertEquals(expected, list.size(), "");
        var actualFirst = list.getFirst();
        var actualLast = list.getLast();
        assertEquals(expectedFirst, actualFirst, "The first item should be sorted alphabetically");
        assertEquals(expectedLast, actualLast, "The last item should be sorted alphabetically");
    }

    @Test
    public void mapCategories_shouldReturn_distinctListOfCategories_inAlphabeticalOrder()
    {
        // arrange
        var orders = loadOrders();
        var expected = 8;
        var expectedFirst = "Beverages";
        var expectedLast = "Seafood";

        // act
        var list = maps.mapCategories(orders);

        // assert
        assertEquals(expected, list.size(), "There are only 8 distinct categories in the file");
        var actualFirst = list.getFirst();
        var actualLast = list.getLast();
        assertEquals(expectedFirst, actualFirst, "The first item should be sorted alphabetically");
        assertEquals(expectedLast, actualLast, "The last item should be sorted alphabetically");
    }

    @Test
    public void mapProducts_shouldReturn_distinctListOfProducts_inAlphabeticalOrder()
    {
        // arrange
        var orders = loadOrders();
        var expected = 77;
        var expectedFirst = "Alice Mutton";
        var expectedLast = "Zaanse koeken";

        // act
        var list = maps.mapProducts(orders);

        // assert
        assertEquals(expected, list.size(), "There are 77 distinct products in the file");
        var actualFirst = list.getFirst();
        var actualLast = list.getLast();
        assertEquals(expectedFirst, actualFirst, "The first item should be sorted alphabetically");
        assertEquals(expectedLast, actualLast, "The last item should be sorted alphabetically");
    }

    @Test
    public void mapYears_shouldReturn_distinctListOfYears_inNumericalOrder()
    {
        // arrange
        var orders = loadOrders();
        var expected = 3;
        var expectedFirst = "2021";
        var expectedLast = "2023";

        // act
        var list = maps.mapYears(orders);

        // assert
        assertEquals(expected, list.size(), "There are 3 distinct order years in the file");
        var actualFirst = list.getFirst();
        var actualLast = list.getLast();
        assertEquals(expectedFirst, actualFirst, "The first item should be sorted alphabetically");
        assertEquals(expectedLast, actualLast, "The last item should be sorted alphabetically");
    }

    @Test
    public void mapOrderIds_shouldReturn_distinctListOfOrderIds_inNumericalOrder()
    {
        // arrange
        var orders = loadOrders();
        var expected = 830;
        var expectedFirst = "10248";
        var expectedLast = "11077";

        // act
        var list = maps.mapOrderIds(orders);

        // assert
        assertEquals(expected, list.size(), "There are 3 distinct order years in the file");
        var actualFirst = list.getFirst();
        var actualLast = list.getLast();
        assertEquals(expectedFirst, actualFirst, "The first item should be sorted alphabetically");
        assertEquals(expectedLast, actualLast, "The last item should be sorted alphabetically");
    }

}