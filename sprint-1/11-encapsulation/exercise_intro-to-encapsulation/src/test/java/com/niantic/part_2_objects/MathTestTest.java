package com.niantic.part_2_objects;

import com.niantic.ReflectionBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class MathTestTest extends ReflectionBase<MathTest>
{
    Class<MathTest> klass;

    @BeforeEach
    void setup()
    {
        klass = MathTest.class;
    }

    @Test
    public void mathTest_shouldNotHave_parameterlessConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass);

        // assert
        assertNull(constructor, "\nThere should NOT be a parameterless constructor.\n");
    }

    @Test
    public void mathTest_shouldHave_parameterizedConstructor()
    {
        // arrange
        // act
        var constructor = getConstructor(klass, Integer.TYPE, String.class);

        // assert
        assertNotNull(constructor, "\nThere should be a parameterized constructor (int possiblePoint, String studentName).\n");
    }

    @Test
    public void mathTest_shouldHave_getPossiblePoints()
    {
        // arrange
        // act
        var method = getMethod(klass, "getPossiblePoints");

        // assert
        assertNotNull(method, "\nThere should be a getPossiblePoints getter method.\n");
    }

    @Test
    public void mathTest_shouldNotHave_setPossiblePoints()
    {
        // arrange
        // act
        var method = getMethod(klass, "setPossiblePoints", Integer.TYPE);

        // assert
        assertNull(method, "\nThere should NOT be a setPossiblePoints setter method.\n");
    }

    @Test
    public void mathTest_shouldHave_getStudentName()
    {
        // arrange
        // act
        var method = getMethod(klass, "getStudentName");

        // assert
        assertNotNull(method, "\nThere should be a getStudentName getter method.\n");
    }

    @Test
    public void mathTest_shouldNotHave_setStudentName()
    {
        // arrange
        // act
        var method = getMethod(klass, "setStudentName", String.class);

        // assert
        assertNull(method, "\nThere should NOT be a setStudentName setter method.\n");
    }

    @Test
    public void mathTest_shouldHave_getScore()
    {
        // arrange
        // act
        var method = getMethod(klass, "getScore");

        // assert
        assertNotNull(method, "\nThere should be a getScore getter method.\n");
    }

    @Test
    public void mathTest_shouldHave_setScore()
    {
        // arrange
        // act
        var method = getMethod(klass, "setScore", Integer.TYPE);

        // assert
        assertNotNull(method, "\nThere should NOT be a setScore setter method - with int input.\n");
    }

    @Test
    public void mathTest_shouldHave_getPercent()
    {
        // arrange
        // act
        var method = getMethod(klass, "getPercent");

        // assert
        assertNotNull(method, "\nThere should be a getPercent getter method.\n");
    }

    @Test
    public void mathTest_shouldHave_getLetterGrade()
    {
        // arrange
        // act
        var method = getMethod(klass, "getLetterGrade");

        // assert
        assertNotNull(method, "\nThere should be a getLetterGrade getter method.\n");
    }

    @Test
    public void getPercent_should_calculatePercent() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, String.class);
        var setScore = getMethod(klass, "setScore", Integer.TYPE);
        var getPercent = getMethod(klass, "getPercent");
        var instance = constructor.newInstance(100, "John");
        setScore.invoke(instance, 95);

        // act
        Object result = getPercent.invoke(instance);
        int actual = (int)result;

        // assert
        assertEquals(95,actual, "\nPossible: 100 - Score: 95 - Should be 95%");
    }

    @Test
    public void getLetterGrade_should_calculateGradeFor_A() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, String.class);
        var setScore = getMethod(klass, "setScore", Integer.TYPE);
        var getLetterGrade = getMethod(klass, "getLetterGrade");
        var instance = constructor.newInstance(100, "John");
        setScore.invoke(instance, 95);

        // act
        Object result = getLetterGrade.invoke(instance);
        String actual = (String)result;

        // assert
        assertEquals("A",actual, "\nPossible: 100 - Score: 95 - Should be A");
    }

    @Test
    public void getLetterGrade_should_calculateGradeFor_B() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, String.class);
        var setScore = getMethod(klass, "setScore", Integer.TYPE);
        var getLetterGrade = getMethod(klass, "getLetterGrade");
        var instance = constructor.newInstance(100, "John");
        setScore.invoke(instance, 89);

        // act
        Object result = getLetterGrade.invoke(instance);
        String actual = (String)result;

        // assert
        assertEquals("B",actual, "\nPossible: 100 - Score: 89 - Should be B");
    }

    @Test
    public void getLetterGrade_should_calculateGradeFor_C() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, String.class);
        var setScore = getMethod(klass, "setScore", Integer.TYPE);
        var getLetterGrade = getMethod(klass, "getLetterGrade");
        var instance = constructor.newInstance(100, "John");
        setScore.invoke(instance, 79);

        // act
        Object result = getLetterGrade.invoke(instance);
        String actual = (String)result;

        // assert
        assertEquals("C",actual, "\nPossible: 100 - Score: 79 - Should be C");
    }

    @Test
    public void getLetterGrade_should_calculateGradeFor_D() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, String.class);
        var setScore = getMethod(klass, "setScore", Integer.TYPE);
        var getLetterGrade = getMethod(klass, "getLetterGrade");
        var instance = constructor.newInstance(100, "John");
        setScore.invoke(instance, 69);

        // act
        Object result = getLetterGrade.invoke(instance);
        String actual = (String)result;

        // assert
        assertEquals("D",actual, "\nPossible: 100 - Score: 69 - Should be D");
    }

    @Test
    public void getLetterGrade_should_calculateGradeFor_F() throws InvocationTargetException, IllegalAccessException, InstantiationException
    {
        // arrange
        var constructor = getConstructor(klass, Integer.TYPE, String.class);
        var setScore = getMethod(klass, "setScore", Integer.TYPE);
        var getLetterGrade = getMethod(klass, "getLetterGrade");
        var instance = constructor.newInstance(100, "John");
        setScore.invoke(instance, 59);

        // act
        Object result = getLetterGrade.invoke(instance);
        String actual = (String)result;

        // assert
        assertEquals("F",actual, "\nPossible: 100 - Score: 59 - Should be F");
    }
}