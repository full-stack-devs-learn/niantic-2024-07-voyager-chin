package com.nianatic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseChallengeTests
{
    private ExerciseChallenge ex;

    @BeforeEach
    public void setup()
    {
        ex = new ExerciseChallenge();
    }


    @ParameterizedTest
    @CsvSource({
            "Samuel Black, , Black, Samuel, ",
            "Glen Carter Williamson, ,glen.c.williamson",
            "Glen Williamson, Jr, glen.williamson",
            "Glen Carter Williamson, Jr, glen.c.williamson",
    })
    @Order(1)
    public void test01_createUserName_ShouldReturn_ProperlyFormattedUserName(String fullName, String suffix, String expected)
    {
        // arrange
        fullName = suffix == null ? fullName : fullName + ", " + suffix;

        // act
        var actual = ex.reformatName(fullName);

        // arrange
        System.out.println("1) Re-format the name to match the standard pattern");
        System.out.println("   Input Name: " + fullName);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, Belinda Carter",
            "15, Howard Jones",
            "31, Grant Ward"
    })
    @Order(4)
    public void test04_createXml_ShouldReturn_WellFormatedXml(String idIn, String name)
    {
        // arrange
        int id = Integer.parseInt(idIn);
        String expected = String.format("{ \"id\": %d, \"name\": \"%s\" }", id, name);

        // act
        var actual = ex.createJSON(id, name);

        // arrange
        System.out.println("2) Create a JSON string for a customer");
        System.out.println("   Inputs");
        System.out.println("     id: " + id);
        System.out.println("     name: " + name);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }
}