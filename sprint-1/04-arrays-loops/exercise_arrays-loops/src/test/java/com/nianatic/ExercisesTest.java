package com.nianatic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExercisesTest
{
    Exercises exercises;


    private final String[] fullWeek = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    private final String[] workWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
    private final String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    private final int[] intArray1 = {1,2,3};
    private final int[] intArray2 = {1,3,5,7,9};
    private final int[] intArray3 = {2,4,6,8,10};
    private final int[] intArray4 = {0,1,1,2,3,5,8,13};

    private final double[] doubleArray1 = {15.25, 2.34, 3.50};
    private final double[] doubleArray2 = {12.75, 10.25, 18.44, 9.20};
    private final double[] doubleArray3 = {24.80, 1.33, -8.44, 15.35};
    private final double[] doubleArray4 = {-13.2, -5.50, -0.25};

    @BeforeEach
    public void setup()
    {
        exercises = new Exercises();
    }

    @Test
    @Order(1)
    void test01_daysOfTheWeek_ShouldReturn_AllDaysOfTheWeek()
    {
        // arrange
        String[] expected = fullWeek;

        // act
        String[] actual = exercises.daysOfTheWeek();

        // assert
        System.out.println("1) Return days of the week");
        Arrays.stream(actual).forEach(a -> System.out.print(a + " "));
        System.out.println("\n");
        assertArrayEquals(expected, actual);

    }

    @Test
    @Order(2)
    void test02_monthsOfTheYear_ShouldReturn_AllMonthsOfTheYear()
    {
        // arrange
        var expected = months;

        // act
        String[] actual = exercises.monthsOfTheYear();

        // assert
        System.out.println("2) Return months of the year");
        Arrays.stream(actual).forEach(a -> System.out.print(a + " "));
        System.out.println("\n");
        assertArrayEquals(expected, actual);
    }

    @Test
    @Order(3)
    void test03_oneToFifty_ShouldReturn_50Numbers()
    {
        // arrange
        int expectedSize = 50;

        // act
        int[] actual = exercises.oneToFifty();

        // assert
        System.out.println("3) Return array 1 to 50");
        Arrays.stream(actual).forEach(a -> System.out.print(a + " "));
        System.out.println("\n");
        assertEquals(expectedSize,actual.length, "Because the function should have created the correct array size");
        assertEquals(1, actual[0], "Because the array should start with 1");
        assertEquals(50, actual[49], "Because the array should end with 50");

    }

    @Test
    @Order(4)
    void test04_evenNumbers_ShouldReturn_AllEvenNumbers_From1to200()
    {
        // arrange
        // act
        var actual = exercises.evenNumbers();

        // assert
        System.out.println("4) Return even numbers from 1 to 200");
        Arrays.stream(actual).forEach(a -> System.out.print(a + " "));
        System.out.println("\n");
        assertEquals(100, actual.length, "Because there should be 100 even numbers in the given range (1 - 200)");
        assertEquals(2, actual[0], "Because the array should start with 2");
        assertEquals(200, actual[99], "Because the array should end with 2000");

    }

    @ParameterizedTest
    @CsvSource({
            "full",
            "work"
    })
    @Order(5)
    void test05_firstDayOfWeek_ShouldReturn_TheFirstDayOfTheWeek_FromTheArray(String weekType)
    {
        // arrange
        var week = weekType.equalsIgnoreCase("full") ? fullWeek : workWeek;

        // act
        var actual = exercises.firstDayOfWeek(week);

        // assert
        System.out.println("5) Return first day of week for a " + weekType + " week");
        System.out.println(actual + "\n");
        assertEquals(week[0], actual);
    }

    @ParameterizedTest
    @CsvSource({
            "full",
            "work"
    })
    @Order(6)
    void test06_lastDayOfWeek_ShouldReturn_TheLastDayOfTheWeek_FromTheArray(String weekType)
    {
        // arrange
        var week = weekType.equalsIgnoreCase("full") ? fullWeek : workWeek;
        var lastIndex = week.length - 1;

        // act
        var actual = exercises.lastDayOfWeek(week);

        // assert
        System.out.println("6) Return last day of week for a " + weekType + " week");
        System.out.println(actual + "\n");
        assertEquals(week[lastIndex], actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,January",
            "5,May",
            "7,July"
    })
    @Order(7)
    void test07_monthName_ShouldReturn_TheCorrectNameOfTheMonth(String monthNumberInput, String expected)
    {
        // arrange
        int monthNumber = Integer.parseInt(monthNumberInput);

        // act
        var actual = exercises.monthName(months, monthNumber);

        // assert
        System.out.println("7) Return the month name for month number " + monthNumber );
        System.out.println(actual + "\n");
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Kent,true",
            "kent,true",
            "Jenny,false",
    })
    @Order(8)
    void test08_hasName_ShouldReturn_True_IfTheArrayContainsTheName(String searchName, String expectedInput)
    {
        // arrange
        boolean expected = Boolean.parseBoolean(expectedInput);
        String[] names = { "Ron", "Lisa", "Kent", "Michelle"};

        // act
        var actual = exercises.hasName(names, searchName);

        // assert
        System.out.println("8) Return true if the name was found in the array. \nSearch name: " + searchName );
        System.out.println(actual + "\n");
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Michelle,2",
            "Ron,3",
            "Jenny,0",
    })
    @Order(9)
    void test09_countName_ShouldReturn_CountOfTimes_NameIsInArray(String searchName, String expectedIn)
    {
        //arrange
        int expected = Integer.parseInt(expectedIn);
        String[] names = { "Ron", "Lisa", "Kent", "Michelle", "Wilbert", "Ron", "Michelle", "Agnes", "Maryann", "Preston", "Ron" };

        //act
        var actual = exercises.countName(names, searchName);

        //assert
        System.out.println("9) Return count of the name being searched. \nSearch name: " + searchName );
        System.out.println(actual + "\n");
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "1","2","3","4"
    })
    @Order(10)
    void test10_sumNumbers_ShouldReturn_TheSumOfAllNumbers(int arrayNumber)
    {
        // arrange
        int[] array = switch (arrayNumber)
        {
            case 1 -> intArray1;
            case 2 -> intArray2;
            case 3 -> intArray3;
            default -> intArray4;
        };
        int expected = Arrays.stream(array).sum();

        // act
        int actual = exercises.sumNumbers(array);

        // assert
        System.out.println("10) Return sum of the numbers: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));
        System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "1","2","3","4"
    })
    @Order(11)
    void test11_doubleEvens_ShouldReturn_TheSumOfEvenNumbers_Doubled(int arrayNumber)
    {
        // arrange
        int[] array = switch (arrayNumber)
        {
            case 1 -> intArray1;
            case 2 -> intArray2;
            case 3 -> intArray3;
            default -> intArray4;
        };
        int expected = Arrays.stream(array).filter(n -> n % 2 == 0).sum();
        expected *= 2;

        // act
        int actual = exercises.doubleEvens(array);

        // assert
        System.out.println("11) Return double the sum of only the even numbers: ");
        System.out.print("Original array: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));
        System.out.print("\nSum of: ");
        Arrays.stream(array).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,8",
            "3,10",
            "4,10"
    })
    @Order(12)
    void test12_sumEveryThird(String arrayNumber, String expectedIn)
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
        int actual = exercises.sumEveryThird(array);

        // assert
        System.out.println("12) Return double the sum of every third number: ");
        System.out.print("Original array: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));
        System.out.print("\nSum of: ");
        AtomicInteger counter = new AtomicInteger();
        Arrays.stream(array).filter(n -> (counter.getAndIncrement() % 3) == 0).forEach(n -> System.out.print(n + " "));
        System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual);

    }

    /*
    {15.25, 2.34, 3.50};
    {12.75, 10.25, 18.44, 9.20};
    {24.80, 1.33, -8.44, 15.35};
    {-13.2, -5.50, -0.25};
     */
    @ParameterizedTest
    @CsvSource({
            "1,7.03",
            "2,12.66",
            "3,8.26",
            "4,-6.32"
    })
    @Order(13)
    void test13_averagePrice_ShouldRetur_TheAverageOfAllPrices_InTheArray(String arrayNumber, String expectedIn)
    {
        // arrange
        double expected = Double.parseDouble(expectedIn);
        double[] array = switch (arrayNumber)
        {
            case "1" -> doubleArray1;
            case "2" -> doubleArray2;
            case "3" -> doubleArray3;
            default -> doubleArray4;
        };


        // act
        double actual = exercises.averagePrice(array);

        // assert
        System.out.println("13) Return the average price ");
        System.out.print("Prices: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual, .2);
    }

    /*
    {15.25, 2.34, 3.50};
    {12.75, 10.25, 18.44, 9.20};
    {24.80, 1.33, -8.44, 15.35};
    {-13.2, -5.50, -0.25};
     */
    @ParameterizedTest
    @CsvSource({
            "1,15.25",
            "2,18.44",
            "3,24.8",
            "4,-0.25"
    })
    @Order(14)
    void test14_highestValue_ShouldReturn_TheHighestValue_InTheArray(String arrayNumber, String expectedIn)
    {
        // arrange
        double expected = Double.parseDouble(expectedIn);
        double[] array = switch (arrayNumber)
        {
            case "1" -> doubleArray1;
            case "2" -> doubleArray2;
            case "3" -> doubleArray3;
            default -> doubleArray4;
        };


        // act
        double actual = exercises.highestValue(array);

        // assert
        System.out.println("14) Return the highest price ");
        System.out.print("Prices: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual, .2);
    }

    /*
    {15.25, 2.34, 3.50};
    {12.75, 10.25, 18.44, 9.20};
    {24.80, 1.33, -8.44, 15.35};
    {-13.2, -5.50, -0.25};
     */
    @ParameterizedTest
    @CsvSource({
            "1,2.34",
            "2,9.2",
            "3,-8.44",
            "4,-13.2"
    })
    @Order(15)
    void test15_lowestValue_ShouldReturn_TheLowestValue_InTheArray(String arrayNumber, String expectedIn)
    {
        // arrange
        double expected = Double.parseDouble(expectedIn);
        double[] array = switch (arrayNumber)
        {
            case "1" -> doubleArray1;
            case "2" -> doubleArray2;
            case "3" -> doubleArray3;
            default -> doubleArray4;
        };


        // act
        double actual = exercises.lowestValue(array);

        // assert
        System.out.println("15) Return the lowest price ");
        System.out.print("Prices: ");
        Arrays.stream(array).forEach(n -> System.out.print(n + " "));System.out.println("\nExpected: " + expected + "\n");
        assertEquals(expected, actual, .2);
    }
}