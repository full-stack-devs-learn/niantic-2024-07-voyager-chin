package com.niantic.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Part_1_ArrayListIntro_Tests
{
    ArrayListIntro exercises;

    @BeforeEach
    public void setup()
    {
        exercises = new ArrayListIntro();
    }

    @Test
    void getHeroesList_should_return_listWith5Names()
    {
        // arrange
        // act
        var list = exercises.getHeroesList();

        // assert
        assertNotNull(list, "The list should not be null");
        assertEquals(5, list.size(), "The list should have 5 names");
    }

    @Test
    void findEvens_should_return_filteredList_withOnlyEvenNumbers()
    {
        // arrange
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(new Integer[]{2,4,6}));

        // act
        var actual = exercises.findEvens(numbers);

        // assert
        assertEquals(expected.size(), actual.size(), "The original list has 3 even numbers");
        for(int number : expected)
        {
            assertTrue(actual.contains(number), "The number " + number + " should be in the returned list");
        }
    }

    @Test
    void sum_should_return_sumOfAllNumbers()
    {
        // arrange
        Integer[] nums = {1,2,3,4,5,6};
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(nums));
        int expected = 21;

        // act
        var actual = exercises.sum(numbers);

        // assert
        assertEquals(expected, actual, "1 + 2 + 3 + 4 + 5 + 6 = 21");
    }

    @Test
    void max_should_return_maxOfAllNumbers()
    {
        // arrange
        Integer[] nums = {3, 1, 59, -4, 81, 23};
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(nums));
        int expected = 81;

        // act
        var actual = exercises.max(numbers);

        // assert
        assertEquals(expected, actual, "Because 81 is the largest of [3,1,59,-4,81,23]");
    }

    @Test
    void min_should_return_minOfAllNumbers()
    {
        // arrange
        Integer[] nums = {3, 1, 59, -4, 81, 23};
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(nums));
        int expected = -4;

        // act
        var actual = exercises.min(numbers);

        // assert
        assertEquals(expected, actual, "Because -4 is the smallest of [3,1,59,-4,81,23]");
    }

    @Test
    void average_should_return_averageOfAllNumbers()
    {
        // arrange
        Integer[] nums = {3, 1, 59, -4, 81, 23};
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(nums));
        int expected = 27;

        // act
        var actual = exercises.average(numbers);

        // assert
        assertEquals(expected, actual, "Because 27 is the average of [3,1,59,-4,81,23]");
    }

    @Test
    void buildFibonacci_should_return_theFibonacciSequence()
    {
        // arrange

        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(0, 1, 1));
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3));
        ArrayList<Integer> expected4 = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8));
        ArrayList<Integer> expected5 = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21));

        // act
        var actual1 = exercises.buildFibonacci(2);
        var actual2 = exercises.buildFibonacci(3);
        var actual3 = exercises.buildFibonacci(5);
        var actual4 = exercises.buildFibonacci(7);
        var actual5 = exercises.buildFibonacci(9);

        // assert
        assertEquals(expected1.size(), actual1.size(), "The returned list should have " + expected1.size() + " fibonacci numbers");
        assertEquals(expected2.size(), actual2.size(), "The returned list should have " + expected2.size() + " fibonacci numbers");
        assertEquals(expected3.size(), actual3.size(), "The returned list should have " + expected3.size() + " fibonacci numbers");
        assertEquals(expected4.size(), actual4.size(), "The returned list should have " + expected4.size() + " fibonacci numbers");
        assertEquals(expected5.size(), actual5.size(), "The returned list should have " + expected5.size() + " fibonacci numbers");

        String expectedString1 = formatString(expected1);
        String expectedString2 = formatString(expected2);
        String expectedString3 = formatString(expected3);
        String expectedString4 = formatString(expected4);
        String expectedString5 = formatString(expected5);

        String actualString1 = formatString(actual1);
        String actualString2 = formatString(actual2);
        String actualString3 = formatString(actual3);
        String actualString4 = formatString(actual4);
        String actualString5 = formatString(actual5);

        assertEquals(expectedString1, actualString1, "Because we requested the first 2 fibonacci numbers");
        assertEquals(expectedString2, actualString2, "Because we requested the first 3 fibonacci numbers");
        assertEquals(expectedString3, actualString3, "Because we requested the first 5 fibonacci numbers");
        assertEquals(expectedString4, actualString4, "Because we requested the first 7 fibonacci numbers");
        assertEquals(expectedString5, actualString5, "Because we requested the first 9 fibonacci numbers");
    }

    private String formatString(ArrayList<Integer> numbers)
    {
        List<String> values = numbers.stream().map(String::valueOf).toList();
        return String.join(",",values);
    }
}