package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        // Create ArrayList to hold requested TestScore
        ArrayList<TestScore> requestedTestScores = new ArrayList<>();

        // Create a for loop to get each value from testScores
        for (TestScore testScore : testScores)
        {
            // Check if the test name of testScore matches the testName parameter
            if (testScore.getTestName() == testName)
            {
                // add testScore to the new ArrayList if matched
                requestedTestScores.add(testScore);
            }
        }

        // Return the ArrayList with matching testscores
        return requestedTestScores;
    }

    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        // Create ArrayList to hold requested student scores
        ArrayList<TestScore> studentScores = new ArrayList<>();

        // Create a for loop to get each value from testScores
        for (TestScore testScore : testScores)
        {
            // Add matching scores of student to the created ArrayList
            if ( testScore.getStudentName() == student)
            {
                studentScores.add(testScore);
            }
        }

        // Return all scores for the requested student
        return studentScores;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        int highestScore = 0;

        // Get value of each testScore using a for loop
        for (TestScore testScore : testScores)
        {
            // Replace the value of highestScore if testScore is higher
            if (testScore.getScore() > highestScore)
            {
                highestScore = testScore.getScore();
            }
        }

        // Return highest score
        return highestScore;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        int lowestScore = 100; // Assuming 100 is the highest possible score

        // Get value of each testScore using a for loop
        for (TestScore testScore : testScores)
        {
            // Replace the value of highestScore if testScore is lower
            if (testScore.getScore() < lowestScore)
            {
                lowestScore = testScore.getScore();
            }
        }

        // Return lowest score
        return lowestScore;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int sum = 0;

        // Get each testScore using for loop
        for (TestScore testScore : testScores)
        {
            // Add each score to the sum variable
            sum += testScore.getScore();
        }

        // Get average using sum and size of ArrayList
        double averageScore = sum / testScores.size();

        // Return average of all test scores
        return (int) averageScore;
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int highestScoreByTest = 0;

        // Get each testScore using for loop
        for (TestScore testScore : testScores)
        {
            // Check if testName matches and is higher than the variable
            if (testScore.getTestName() == testName && testScore.getScore() > highestScoreByTest)
            {
                // If score is higher, replace the value in the variable
                highestScoreByTest = testScore.getScore();
            }
        }

        // Return the highest score of specified testName
        return highestScoreByTest;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int lowestScoreByTest = 100; // Assuming 100 is the highest possible score

        // Get each testScore using for loop
        for (TestScore testScore : testScores)
        {
            // Check if testName matches and is lower than the variable
            if (testScore.getTestName() == testName && testScore.getScore() < lowestScoreByTest)
            {
                // If score is lower, replace the value in the variable
                lowestScoreByTest = testScore.getScore();
            }
        }

        // Return the lowest score of specified testName
        return lowestScoreByTest;
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        // Create ArrayList that will hold specified scores
        ArrayList<Integer> matchingTestScores = new ArrayList<>();

        // Add to array list the test scores that matched specified test name
        for (TestScore testScore : testScores)
        {
            if (testScore.getTestName() == testName)
            {
                matchingTestScores.add(testScore.getScore());
            }
        }

        int sum = 0;

        // Get sum of specified scores
        for (int matchingScore : matchingTestScores)
        {
            sum += matchingScore;
        }

        // Calculate average score
        double averageScore = sum / matchingTestScores.size();

        // Return average score of specified test name
        return (int) averageScore;
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int highestScoreByStudent = 0;

        // Get value of each score
        for (TestScore testScore : testScores)
        {
            if (testScore.getScore() > highestScoreByStudent && testScore.getStudentName() == student)
            {
                // Replace variable if score is higher than variable AND matches specified student
                highestScoreByStudent = testScore.getScore();
            }
        }

        // Return highest score of specified student
        return highestScoreByStudent;
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        int lowestScoreByStudent = 100; // Assuming 100 is the highest possible score

        // Get value of each score
        for (TestScore testScore : testScores)
        {
            if (testScore.getScore() < lowestScoreByStudent && testScore.getStudentName() == student)
            {
                // Replace variable if score is lower than variable AND matches specified student
                lowestScoreByStudent = testScore.getScore();
            }
        }

        // Return lowest score of specified student
        return lowestScoreByStudent;
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<Integer> studentScores = new ArrayList<>();

        // Get test scores of specified student and add to the new ArrayList
        for (TestScore testScore : testScores)
        {
            if (testScore.getStudentName() == student)
            {
                studentScores.add(testScore.getScore());
            }
        }

        int sum = 0;

        // Get score sum of specified student
        for (int studentScore : studentScores)
        {
            sum += studentScore;
        }

        // Calculate average score
        double averageScoreByStudent = sum / studentScores.size();

        // Return average score of specified student
        return (int) averageScoreByStudent;
    }
}
