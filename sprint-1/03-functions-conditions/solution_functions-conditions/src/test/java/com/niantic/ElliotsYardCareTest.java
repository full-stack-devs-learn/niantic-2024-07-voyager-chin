package com.niantic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ElliotsYardCareTest
{

    @ParameterizedTest
    @CsvSource({
            "100, 50, false, 12.50",
            "100, 50, true, 15",
            "75, 75, true, 16.88"
    })
    public void calculateCost_Test(String widthIn, String lengthIn, String isTrimmingIn, String expectedIn)
    {
        // arrange
        int width = Integer.parseInt(widthIn);
        int length = Integer.parseInt(lengthIn);
        boolean isTrimming = Boolean.parseBoolean(isTrimmingIn);
        double expected = Double.parseDouble(expectedIn);
        ElliotsYardCare service = new ElliotsYardCare();

        // act
        double actual = service.calculateCost(width, length, isTrimming);

        // assert
        String message = String.format("""
                        Inputs:
                         -- width: %d
                         -- length: %d
                         -- trimming: %s
                        """,
                width, length, isTrimming);
        assertEquals(expected, actual, .2, message);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 50, false, 2.5",
            "100, 50, true, 3.75",
            "75, 75, true, 4.22",
            "100, 75, true, 5.62"
    })
    public void calculateTime_Test(String widthIn, String lengthIn, String isTrimmingIn, String expectedIn)
    {
        // arrange
        int width = Integer.parseInt(widthIn);
        int length = Integer.parseInt(lengthIn);
        boolean isTrimming = Boolean.parseBoolean(isTrimmingIn);
        double expected = Double.parseDouble(expectedIn);
        ElliotsYardCare service = new ElliotsYardCare();

        // act
        double actual = service.calculateTime(width, length, isTrimming);

        // assert
        String message = String.format("""
                        Inputs:
                         -- width: %d
                         -- length: %d
                         -- trimming: %s
                        """,
                width, length, isTrimming);
        assertEquals(expected, actual, .2, message);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 50, false, 50",
            "100, 50, true, 75",
            "75, 75, true, 75",
            "100, 75, true, 100"
    })
    public void calculatePrice_Test(String widthIn, String lengthIn, String isTrimmingIn, String expectedIn)
    {
        // arrange
        int width = Integer.parseInt(widthIn);
        int length = Integer.parseInt(lengthIn);
        boolean isTrimming = Boolean.parseBoolean(isTrimmingIn);
        double expected = Double.parseDouble(expectedIn);
        ElliotsYardCare service = new ElliotsYardCare();

        // act
        double actual = service.calculatePrice(width, length, isTrimming);

        // assert
        String message = String.format("""
                        Inputs:
                         -- width: %d
                         -- length: %d
                         -- trimming: %s
                        """,
                width, length, isTrimming);
        assertEquals(expected, actual, .2, message);
    }


    @ParameterizedTest
    @CsvSource({
            "100, 50, false, 50, 37.50",
            "100, 50, true, 50, 35",
            "75, 75, true, 50, 33.12",
            "150, 100, true, 75, 30"
    })
    public void calculateProfit_Test(String widthIn, String lengthIn, String isTrimmingIn, String amountChargedIn, String expectedIn)
    {
        // arrange
        int width = Integer.parseInt(widthIn);
        int length = Integer.parseInt(lengthIn);
        boolean isTrimming = Boolean.parseBoolean(isTrimmingIn);
        int amountCharged = Integer.parseInt(amountChargedIn);
        double expected = Double.parseDouble(expectedIn);
        ElliotsYardCare service = new ElliotsYardCare();

        // act
        double actual = service.calculateProfit(width, length, isTrimming, amountCharged);

        // assert
        String message = String.format("""
                        Inputs:
                         -- width: %d
                         -- length: %d
                         -- trimming: %s
                         -- amount charged: %d
                        \n""",
                width, length, isTrimming, amountCharged);
        assertEquals(expected, actual, .2, message);
    }

}