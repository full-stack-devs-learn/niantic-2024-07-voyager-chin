package com.niantic.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReducersTests extends TestBase
{
    Filters filters;
    Reducers reducers;

    @BeforeEach
    public void init()
    {
        filters = new Filters();
        reducers = new Reducers();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 28722.71",
            "Ernst Handel, 113236.68",
            "Que Delcia, 6973.63"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void totalSales_shouldCalculate_totalSales_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.totalSales(filteredList);

        // assert
        assertEquals(expected, actual, "Because the sales total should be for company: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 598.38",
            "Ernst Handel, 1110.16",
            "Que Delcia, 290.56"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void averageSalesPerLineItem_shouldCalculate_averageSales_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.averageSalesPerLineItem(filteredList);

        // assert
        assertEquals(expected, actual, .1, "Because the calculation for average sales should be for company: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 18.83",
            "Ernst Handel, 24.92",
            "Que Delcia, 17.69",
            "Alfreds Futterkiste, 26.41"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void averageSalesPerItem_shouldCalculate_averageItemSalesAmount_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.averageSalesPerItem(filteredList);

        // assert
        assertEquals(expected, actual, .1, "Because the calculation for average item sales amount should be for company: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 1525",
            "Ernst Handel, 4543",
            "Que Delcia, 394",
            "Alfreds Futterkiste, 174"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void totalItemCount_shouldCalculate_theTotalNumberOfItemsPurchased_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.totalItemCount(filteredList);

        // assert
        assertEquals(expected, actual, "Because the calculation for average item sales amount should be for company: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 31.77",
            "Ernst Handel, 44.53",
            "Que Delcia, 16.41",
            "Alfreds Futterkiste, 14.5"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void averageItemCount_shouldCalculate_theTotalNumberOfItemsPurchased_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.averageItemCount(filteredList);

        // assert
        assertEquals(expected, actual, .1, "Because the calculation for average item sales amount should be for company: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 3080",
            "Ernst Handel, 6360",
            "Que Delcia, 1000",
            "Alfreds Futterkiste, 878"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void maxLineItem_shouldReturn_theHighestPricedLineItem_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.maxLineItem(filteredList);

        // assert
        assertEquals(expected, actual, .1, "Because the calculation for average item sales amount should be for company: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 13.5",
            "Ernst Handel, 40",
            "Que Delcia, 29.2",
            "Alfreds Futterkiste, 24"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void minLineItem_shouldReturn_theLowestPricedLineItem_forTheGivenList(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Double.parseDouble(expectedIn);
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // act
        var actual = reducers.minLineItem(filteredList);

        // assert
        assertEquals(expected, actual, .1, "Because the calculation for average item sales amount should be for company: " + companyName);
    }
}