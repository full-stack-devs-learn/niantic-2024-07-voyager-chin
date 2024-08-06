package com.niantic.exercises;

import com.niantic.models.TestScore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part_2_TestScores_Tests
{
    TestScores testScores;

    ArrayList<TestScore> allScores = new ArrayList<>();

    ArrayList<TestScore> scores1 = new ArrayList<>();
    ArrayList<TestScore> scores2 = new ArrayList<>();
    ArrayList<TestScore> scores3 = new ArrayList<>();

    ArrayList<TestScore> scoresJoel = new ArrayList<>();
    ArrayList<TestScore> scoresZoe = new ArrayList<>();
    ArrayList<TestScore> scoresJohn = new ArrayList<>();
    ArrayList<TestScore> scoresSandra = new ArrayList<>();
    ArrayList<TestScore> scoresWilson = new ArrayList<>();
    ArrayList<TestScore> scoresChloe = new ArrayList<>();
    ArrayList<TestScore> scoresGabby = new ArrayList<>();



    TestScore test1_score1 = new TestScore("Intro to Java", "Joel", 95);
    TestScore test1_score2 = new TestScore("Intro to Java", "Zoe", 98);
    TestScore test1_score3 = new TestScore("Intro to Java", "John", 87);
    TestScore test1_score4 = new TestScore("Intro to Java", "Sandra", 88);
    TestScore test1_score5 = new TestScore("Intro to Java", "Wilson", 92);
    TestScore test1_score6 = new TestScore("Intro to Java", "Chloe", 82);
    TestScore test1_score7 = new TestScore("Intro to Java", "Gabby", 78);

    TestScore test2_score1 = new TestScore("Beginning SQL", "Joel", 89);
    TestScore test2_score2 = new TestScore("Beginning SQL", "Zoe", 92);
    TestScore test2_score3 = new TestScore("Beginning SQL", "John", 88);
    TestScore test2_score4 = new TestScore("Beginning SQL", "Sandra", 79);
    TestScore test2_score5 = new TestScore("Beginning SQL", "Wilson", 85);
    TestScore test2_score6 = new TestScore("Beginning SQL", "Chloe", 100);
    TestScore test2_score7 = new TestScore("Beginning SQL", "Gabby", 90);

    TestScore test3_score1  = new TestScore("CSS Fundamentals", "Joel", 99);
    TestScore test3_score2  = new TestScore("CSS Fundamentals", "Zoe", 95);
    TestScore test3_score3  = new TestScore("CSS Fundamentals", "John", 90);
    TestScore test3_score4  = new TestScore("CSS Fundamentals", "Sandra", 89);
    TestScore test3_score5  = new TestScore("CSS Fundamentals", "Wilson", 99);
    TestScore test3_score6  = new TestScore("CSS Fundamentals", "Chloe", 92);
    TestScore test3_score7  = new TestScore("CSS Fundamentals", "Gabby", 93);

    @BeforeEach
    public void setup()
    {
        testScores = new TestScores();

        scores1.add(test1_score1);
        scores1.add(test1_score2);
        scores1.add(test1_score3);
        scores1.add(test1_score4);
        scores1.add(test1_score5);
        scores1.add(test1_score6);
        scores1.add(test1_score7);

        scores2.add(test2_score1);
        scores2.add(test2_score2);
        scores2.add(test2_score3);
        scores2.add(test2_score4);
        scores2.add(test2_score5);
        scores2.add(test2_score6);
        scores2.add(test2_score7);

        scores3.add(test3_score1);
        scores3.add(test3_score2);
        scores3.add(test3_score3);
        scores3.add(test3_score4);
        scores3.add(test3_score5);
        scores3.add(test3_score6);
        scores3.add(test3_score7);

        scoresJoel.add(test1_score1);
        scoresJoel.add(test2_score1);
        scoresJoel.add(test3_score1);

        scoresZoe.add(test1_score2);
        scoresZoe.add(test2_score2);
        scoresZoe.add(test3_score2);

        scoresJohn.add(test1_score3);
        scoresJohn.add(test2_score3);
        scoresJohn.add(test3_score3);

        scoresSandra.add(test1_score4);
        scoresSandra.add(test2_score4);
        scoresSandra.add(test3_score4);

        scoresWilson.add(test1_score5);
        scoresWilson.add(test2_score5);
        scoresWilson.add(test3_score5);

        scoresChloe.add(test1_score6);
        scoresChloe.add(test2_score6);
        scoresChloe.add(test3_score6);

        scoresGabby.add(test1_score7);
        scoresGabby.add(test2_score7);
        scoresGabby.add(test3_score7);

        allScores.addAll(scores1);
        allScores.addAll(scores2);
        allScores.addAll(scores3);
    }

    @Test
    public void getScoresByTest_should_return_scoresForTheSelectedTest()
    {
        // arrange
        var expected = scores1;
        var testName = "Intro to Java";

        // act
        var actual = testScores.getScoresByTest(allScores, testName);

        // assert
        assertEquals(expected, actual, "Searched for test \"" + testName + "\"");
    }

    @Test
    public void getScoresByStudent_should_return_scoresForTheSelectedStudent()
    {
        // arrange
        var expected = scoresWilson;
        var studentName = "Wilson";

        // act
        var actual = testScores.getScoresByStudent(allScores, studentName);

        // assert
        assertEquals(expected, actual, "Searched for student \"" + studentName + "\"");
    }

    @Test
    public void getHighestScore_should_return_theHighestScore()
    {
        // arrange
        var expected = allScores.stream()
                                .map(TestScore::getScore)
                                .reduce(Integer::max)
                                .orElse(0);

        // act
        var actual = testScores.getHighestScore(allScores);

        // assert
        assertEquals(expected, actual, "The highest overall score in the list is " + expected);
    }

    @Test
    public void getLowestScore_should_return_theLowestScore()
    {
        // arrange
        var expected = allScores.stream()
                                .map(TestScore::getScore)
                                .reduce(Integer::min)
                                .orElse(0);

        // act
        var actual = testScores.getLowestScore(allScores);

        // assert
        assertEquals(expected, actual, "The lowest overall score in the list is " + expected);
    }

    @Test
    public void getAverageScore_should_return_theAverageScore()
    {
        // arrange
        var expectedSum = allScores.stream()
                                   .map(TestScore::getScore)
                                   .reduce(Integer::sum)
                                   .orElse(0);
        int expected = expectedSum / allScores.size();

        // act
        var actual = testScores.getAverageScore(allScores);

        // assert
        assertEquals(expected, actual, "The average overall score in the list is " + expected);
    }

    @Test
    public void getHighestScoreByTest_should_return_theHighestScore_byTestName()
    {
        // arrange
        var testName = "Intro to Java";
        var expected = allScores.stream()
                                .filter(s -> s.getTestName().equals(testName))
                                .map(TestScore::getScore)
                                .reduce(Integer::max)
                                .orElse(0);

        // act
        var actual = testScores.getHighestScoreByTest(allScores, testName);

        // assert
        assertEquals(expected, actual, "The highest overall score for " + testName + " is " + expected);
    }

    @Test
    public void getLowestScoreByTest_should_return_theLowestScore_byTestName()
    {
        // arrange
        var testName = "Intro to Java";
        var expected = allScores.stream()
                                .filter(s -> s.getTestName().equals(testName))
                                .map(TestScore::getScore)
                                .reduce(Integer::min)
                                .orElse(0);

        // act
        var actual = testScores.getLowestScoreByTest(allScores, testName);

        // assert
        assertEquals(expected, actual, "The lowest overall score for " + testName + " is " + expected);
    }

    @Test
    public void getAverageScoreByTest_should_return_theAverageScore_byTestName()
    {
        // arrange
        var testName = "Intro to Java";
        var expectedSum = allScores.stream()
                                   .filter(s -> s.getTestName().equals(testName))
                                   .map(TestScore::getScore)
                                   .reduce(Integer::sum)
                                   .orElse(0);
        int expected = expectedSum / scores1.size();

        // act
        var actual = testScores.getAverageScoreByTest(allScores, testName);

        // assert
        assertEquals(expected, actual, "The average overall score for " + testName + " is " + expected);
    }


    @Test
    public void getHighestScoreByStudent_should_return_theHighestScore_byStudentName()
    {
        // arrange
        var studentName = "Sandra";
        var expected = allScores.stream()
                                .filter(s -> s.getStudentName().equals(studentName))
                                .map(TestScore::getScore)
                                .reduce(Integer::max)
                                .orElse(0);

        // act
        var actual = testScores.getHighestScoreByStudent(allScores, studentName);

        // assert
        assertEquals(expected, actual, "The highest overall score for " + studentName + " is " + expected);
    }

    @Test
    public void getLowestScoreByStudent_should_return_theLowestScore_byStudentName()
    {
        // arrange
        var studentName = "Sandra";
        var expected = allScores.stream()
                                .filter(s -> s.getStudentName().equals(studentName))
                                .map(TestScore::getScore)
                                .reduce(Integer::min)
                                .orElse(0);

        // act
        var actual = testScores.getLowestScoreByStudent(allScores, studentName);

        // assert
        assertEquals(expected, actual, "The lowest overall score for " + studentName + " is " + expected);
    }

    @Test
    public void getAverageScoreByStudent_should_return_theAverageScore_byStudentName()
    {
        // arrange
        var studentName = "Sandra";
        var expectedSum = allScores.stream()
                                   .filter(s -> s.getStudentName().equals(studentName))
                                   .map(TestScore::getScore)
                                   .reduce(Integer::sum)
                                   .orElse(0);
        int expected = expectedSum / scoresSandra.size();

        // act
        var actual = testScores.getAverageScoreByStudent(allScores, studentName);

        // assert
        assertEquals(expected, actual, "The average overall score for " + studentName + " is " + expected);
    }
}