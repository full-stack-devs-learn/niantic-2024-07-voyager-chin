package com.niantic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ClairesCookiesTest
{

    @ParameterizedTest
    @CsvSource({
            "1, 12.95",
            "2, 25.90",
            "5, 64.75"
    })
    public void calculateSubtotal_Tests(String quantityIn, String expectedIn)
    {
        // arrange
        int quantity = Integer.parseInt(quantityIn);
        double expected = Double.parseDouble(expectedIn);
        ClairesCookies shop = new ClairesCookies();

        // act
        double actual = shop.calculateSubtotal(quantity);

        // assert
        String message = String.format("\nBecause %d dozen cookies were ordered\n", quantity);
        assertEquals(expected, actual, .2, message);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 13.69",
            "2, 27.39",
            "5, 68.47"
    })
    public void calculateTotal_Tests(String quantityIn, String expectedIn)
    {
        // arrange
        int quantity = Integer.parseInt(quantityIn);
        double expected = Double.parseDouble(expectedIn);
        ClairesCookies shop = new ClairesCookies();

        // act
        double actual = shop.calculateTotal(quantity);

        // assert
        String message = String.format("\nBecause %d dozen cookies were ordered\n", quantity);
        assertEquals(expected, actual, .2, message);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, 45.31",
            "0, 3, 2, 77.99",
            "3, 1, 0, 55.84",
            "2, 0, 2, 61.12"
    })
    public void calculateQuickOrder_Tests(String snickerIn, String chocolateIn, String frostedIn, String expectedIn)
    {
        // arrange
        int snicker = Integer.parseInt(snickerIn);
        int chocolate = Integer.parseInt(chocolateIn);
        int frosted = Integer.parseInt(frostedIn);
        double expected = Double.parseDouble(expectedIn);
        ClairesCookies shop = new ClairesCookies();

        // act
        double actual = shop.calculateQuickOrder(snicker, chocolate, frosted);

        // assert
        String message = String.format("\nBecause the order had: %d snicker-doodles, %d chocolate-chip and %d frosted\n", snicker, chocolate, frosted);
        assertEquals(expected, actual, .2, message);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true, true, 16.87",
            "2, true, false, 29.50",
            "3, false, true, 47.43",
            "5, true, false, 73.76"
    })
    public void calculateCustomOrder_Tests(String quantityIn, String hasChocolateIn, String hasFrostingIn, String expectedIn)
    {
        // arrange
        int quantity = Integer.parseInt(quantityIn);
        boolean hasChocolateChips = Boolean.parseBoolean(hasChocolateIn);
        boolean hasFrosting = Boolean.parseBoolean(hasFrostingIn);
        double expected = Double.parseDouble(expectedIn);
        ClairesCookies shop = new ClairesCookies();

        // act
        double actual = shop.calculateCustomOrder(quantity, hasChocolateChips, hasFrosting);

        // assert
        String message = String.format("\nBecause %d dozen cookies were ordered \nchocolate chips: %s \nfrosting: %s\n", quantity, hasChocolateChips, hasFrosting);
        assertEquals(expected, actual, .2, message);
    }

}