package com.niantic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{

    // The lazy example
    @Test
    public void add()
    {
        Calculator calculator = new Calculator();
        assertEquals(13, calculator.add(10,3));
    }

    @Test
    public void add_shouldReturn_theSumOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        int firstNumber = 10;
        int secondNumber = 3;
        double expected = 13;

        // act
        double actual = calculator.add(firstNumber,secondNumber);

        // assert
        assertEquals(expected, actual, "Because it should have added 10 + 3");

    }

    @Test
    public void subtract_shouldReturn_theDifferenceOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        int firstNumber = 10;
        int secondNumber = 3;
        double expected = 7;

        // act
        double actual = calculator.subtract(firstNumber, secondNumber);

        // assert
        assertEquals(expected, actual, "Because it should have calculated 10 - 3");

    }

    @Test
    public void multiply_shouldReturn_theProductOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        int firstNumber = 10;
        int secondNumber = 3;
        double expected = 30;

        // act
        double actual = calculator.multiply(firstNumber, secondNumber);

        // assert
        assertEquals(expected, actual, "Because it should have calculated 10 * 3");

    }

    @Test
    public void divide_shouldReturn_theQuotientOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        int firstNumber = 10;
        int secondNumber = 3;
        double expected = 3.333;

        // act
        double actual = calculator.divide(firstNumber, secondNumber);

        // assert
        assertEquals(expected, actual, .1, "Because it should have calculated 10 / 3");

    }

}