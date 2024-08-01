package com.nianatic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseTests
{
    private Exercises ex;

    @BeforeEach
    public void setup()
    {
        ex = new Exercises();
    }


    @ParameterizedTest
    @CsvSource({
            "Fancy, false, fancy",
            "chocolate, true, CHOCOLATE",
            "PARTY, false, party",
            "PARTY, true, PARTY",
            "MiXeDwOrd, false, mixedword"
    })
    @Order(1)
    public void test01_changeCase_ShouldReturn_AllUpperOrLowerCase_VersionOfTheWord(String word, String toUpperInput, String expected)
    {
        // arrange
        boolean toUpper = Boolean.parseBoolean(toUpperInput);

        // act
        var actual = ex.changeCase(word, toUpper);

        // arrange
        System.out.println("1) Change the word to UPPER or lower case");
        System.out.println("   Inputs");
        System.out.println("     word: " + word);
        System.out.println("     toUpperCase: " + toUpperInput);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "This is a paragraph, p, <p>This is a paragraph</p>",
            "Bold Text, strong, <strong>Bold Text</strong>",
            "Some famous quote, quote, <quote>Some famous quote</quote>",
            "Italicized, em, <em>Italicized</em>"
    })
    @Order(2)
    public void test02_createHtml_ShouleReturn_WellFormatedHTML(String phrase, String element, String expected)
    {
        // arrange
        // act
        var actual = ex.createHtml(phrase, element);

        // arrange
        System.out.println("2) Create well formatted HTML");
        System.out.println("   Inputs");
        System.out.println("     phrase: \"" + phrase + "\"");
        System.out.println("     element: " + element);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            ", p, <p />",
            "Text, strong, <strong>Text</strong>",
            ", quote, <quote />"
    })
    @Order(3)
    public void test03_moreHtml_ShouldReturn_WellFormatedHTML_WithSelfClosingTags(String phrase, String element, String expected)
    {
        // arrange
        phrase = phrase == null ? "" : phrase;

        // act
        var actual = ex.moreHtml(phrase, element);

        // arrange
        System.out.println("3) Create well formatted HTML with self closing empty elements");
        System.out.println("   Inputs");
        System.out.println("     phrase: \"" + phrase + "\"");
        System.out.println("     element: " + element);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, Belinda Carter, <customer><id>1</id><name>Belinda Carter</name></customer>",
            "15, Howard Jones, <customer><id>15</id><name>Howard Jones</name></customer>",
            "31, Grant Ward, <customer><id>31</id><name>Grant Ward</name></customer>"
    })
    @Order(4)
    public void test04_createXml_ShouldReturn_WellFormatedXml(String idIn, String name, String expected)
    {
        // arrange
        int id = Integer.parseInt(idIn);

        // act
        var actual = ex.createXml(id, name);

        // arrange
        System.out.println("4) Create well formatted and valid XML for a customer");
        System.out.println("   Inputs");
        System.out.println("     id: " + id);
        System.out.println("     name: " + name);
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
    @Order(5)
    public void test05_createXml_ShouldReturn_WellFormatedXml(String idIn, String name)
    {
        // arrange
        int id = Integer.parseInt(idIn);
        String expected = String.format("<customer>\n  <id>%d</id>\n  <name>%s</name>\n</customer>", id, name);

        // act
        var actual = ex.formattedXml(id, name);

        // arrange
        System.out.println("5) Create well formatted and valid XML for a customer");
        System.out.println("   Inputs");
        System.out.println("     id: " + id);
        System.out.println("     name: " + name);
        System.out.println("   Expected: \n" + expected);
        System.out.println();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "Glen, , Williamson, , Glen Williamson",
            "Glen, Carter, Williamson, , Glen Carter Williamson",
            "Glen, , Williamson, Jr, Glen Williamson",
            "Glen, Carter, Williamson, Jr, Glen Carter Williamson",
    })
    @Order(6)
    public void test06_formatFullName_ShouldReturn_ProperlyFormattedFullName(String first, String middle, String last, String suffix, String expected)
    {
        // arrange
        middle = middle == null ? "" : middle;
        suffix = suffix == null ? "" : suffix;
        expected = suffix.isEmpty() ? expected : expected + ", " + suffix;

        // act
        var actual = ex.formatFullName(first, middle, last, suffix);

        // arrange
        System.out.println("6) Properly format the name based on inputs");
        System.out.println("   Inputs");
        System.out.println("     First: " + first);
        System.out.println("     Middle: " + middle);
        System.out.println("     Last: " + last);
        System.out.println("     Suffix: " + suffix);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }

    /*

     * createUserName("Glen Williamson") => glen.williamson
     * createUserName("Glen Carter Williamson") => glen.c.williamson
     * createUserName("Glen Williamson, III") => glen.williamson
     */


    @ParameterizedTest
    @CsvSource({
            "Glen Williamson, glen.williamson",
            "Glen Carter Williamson, glen.c.williamson",
            "Glen Williamson| III, glen.williamson",
            "Miguel Bennett| Jr.| MBA, miguel.bennett"
    })
    @Order(7)
    public void test07_createUserName_ShouldReturn_ProperlyFormattedUserName(String fullName, String expected)
    {
        // arrange
        fullName = fullName.replace("|", ",");
        expected = expected.replace("|", ",");
        Exercises ex = new Exercises();

        // act
        var actual = ex.createUserName(fullName);

        // arrange
        System.out.println("7) Create user name");
        System.out.println("   Input Name: " + fullName);
        System.out.println("   Expected: " + expected);
        System.out.println();
        assertEquals(expected, actual);
    }

}