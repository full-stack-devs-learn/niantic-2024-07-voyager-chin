package com.nianatic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class ExercisesChallengeTest
{
    ExercisesChallenge exercises;

    private final int[] intArray1 = {1,2,3};
    private final int[] intArray2 = {13};
    private final int[] intArray3 = new int[0];
    private final int[] intArray4 = {0,1,1,2,3,5,8,13};

    private final int[][] intMultiArray1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };
    private final int[][] intMultiArray2 = {
            {1,2},
            {3,4,5,6},
            {7,8,9}
    };
    private final int[][] intMultiArray3 = {
            {1,2,3,4},
            {5,6,7,8,9}
    };

    private final String[] names = {"Ron", "Lisa", "Kent", "Michelle"};
    private final String[] namesReversed = {"Michelle", "Kent", "Lisa", "Ron"};

    @BeforeEach
    void setUp()
    {
        exercises = new ExercisesChallenge();
    }


    @ParameterizedTest
    @CsvSource({
            "1,3",
            "2,13",
            "3,0",
            "4,1"
    })
    @Order(1)
    void test01_sumFirst2Numbers(String arrayNumber, String expectedIn)
    {
        // arrange
        int expected = Integer.parseInt(expectedIn);
        int[] array = switch (arrayNumber)
        {
            case "1" -> intArray1;
            case "2" -> intArray2;
            case "3" -> intArray3;
            default -> intArray4;
        };


        // act
        int actual = exercises.sumFirst2Numbers(array);

        // assert
        System.out.println("1) Return the sum of the first 2 numbers: ");
        System.out.print("Original array: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));
        System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    void test02_reverseNames_ShouldReturn_ArrayWithNamesReveresed()
    {
        // arrange
        // act
        var actual = exercises.reverseNames(names);

        // assert
        System.out.println("2) Reverse all names and return the new array");
        System.out.println("Original: [ " + String.join(", ", names) + " ]");
        System.out.println("Expected: [ " + String.join(", ", namesReversed) + " ]");
        assertArrayEquals(namesReversed, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1","2","3"
    })
    @Order(3)
    void test03_combineArrays_ShouldReturn_OneDimensionalArray_WithAllValues(String arrayNumber)
    {
        // arrange
        int[][] array = switch (arrayNumber)
        {
            case "1" -> intMultiArray1;
            case "2" -> intMultiArray2;
            default -> intMultiArray3;
        };
        int[] expected = {1,2,3,4,5,6,7,8,9};


        // act
        int[] actual = exercises.combineArrays(array);

        // assert
        System.out.println("3) Combine and return all numbers in a one dimensional array: ");
        System.out.println("Original arrays: \n[");
        for (int[] nums : array)
        {
            System.out.print("    [ ");
            Arrays.stream(nums).forEach(n -> System.out.print(n + ", "));
            System.out.println("],");
        }
        System.out.println("]");
        System.out.println("Expected: [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ]\n");
        assertArrayEquals(expected, actual);
    }
}