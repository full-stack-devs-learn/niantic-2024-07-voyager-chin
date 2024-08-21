package com.niantic.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FiltersTests extends TestBase
{
    Filters filters;

    @BeforeEach
    public void init()
    {
        filters = new Filters();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Frankenversand, 48",
            "Ernst Handel, 102",
            "Que Delcia, 24",
            "delcia, 24"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void filterByCompanyName_should_filterCorrectly(String companyName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Integer.parseInt(expectedIn);

        // act
        var filteredList = filters.filterByCompanyName(orders, companyName);

        // assert
        assertEquals(expected, filteredList.size(), "Because the search was for company name: " + companyName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Beverages, 404",
            "Confections, 334",
            "Dairy Products, 366",
            "DAIRY, 366"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void filterByCategory_should_filterCorrectly(String categtoryName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Integer.parseInt(expectedIn);

        // act
        var filteredList = filters.filterByCategory(orders, categtoryName);

        // assert
        assertEquals(expected, filteredList.size(), "Because the search was for category: " + categtoryName);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Geitost, 32",
            "Queso Cabrales, 38",
            "Perth Pasties, 30",
            "Ikura, 33",
            "Ravioli Angelo, 23",
            "ravioli, 23"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void filterByProduct_should_filterCorrectly(String productName, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var expected = Integer.parseInt(expectedIn);

        // act
        var filteredList = filters.filterByProduct(orders, productName);

        // assert
        assertEquals(expected, filteredList.size(), "Because the search was for product: " + productName);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "2020, 0",
            "2021, 405",
            "2022, 1059",
            "2023, 691",
            "2024, 0"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void filterByDateRange_should_filterCorrectly(String yearIn, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var year = Integer.parseInt(yearIn);
        var expected = Integer.parseInt(expectedIn);

        // act
        var filteredList = filters.filterByYear(orders, year);

        // assert
        assertEquals(expected, filteredList.size(), "Because the search was for year: " + year);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "10000, 0",
            "10250, 3",
            "10276, 2",
            "10301, 2"
    }, ignoreLeadingAndTrailingWhitespace = true)
    public void filterByOrderId_should_filterCorrectly(String orderIdIn, String expectedIn)
    {
        // arrange
        var orders = loadOrders();
        var orderId = Integer.parseInt(orderIdIn);
        var expected = Integer.parseInt(expectedIn);

        // act
        var filteredList = filters.filterByOrderId(orders, orderId);

        // assert
        assertEquals(expected, filteredList.size(), "Because the search was for orderId: " + orderId);
    }
}