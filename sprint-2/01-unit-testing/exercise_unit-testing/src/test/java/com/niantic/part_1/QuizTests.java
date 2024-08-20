package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizTests
{
    private Quiz quiz;

    @Test
    public void getPercentage_shouldCalculate_scorePercentage()
    {
        // Arrange
        int possiblePoints = 50;
        String studentName = "Spongebob";
        int expectedScore = 80;

        // Act
        quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(40);
        int actualScore = quiz.getPercent();

        // Assert
        assertEquals(expectedScore, actualScore, "Because correct percent of score:40 & possiblePoints:50 should be 80");
    }

    @Test
    public void getLetterGrade_shouldReturn_gradeBasedOnPercent()
    {
        // Arrange
        String expectedScoreA = "A";
        Quiz quizA = new Quiz(100, "studentA");
        String expectedScoreB = "B";
        Quiz quizB = new Quiz(100, "studentB");
        String expectedScoreC = "C";
        Quiz quizC = new Quiz(100, "studentC");
        String expectedScoreD = "D";
        Quiz quizD = new Quiz(100, "studentD");
        String expectedScoreF = "F";
        Quiz quizF = new Quiz(100, "studentF");

        // Act
        quizA.setScore(90);
        quizB.setScore(80);
        quizC.setScore(70);
        quizD.setScore(60);
        quizF.setScore(59);
        String actualScoreA = quizA.getLetterGrade();
        String actualScoreB = quizB.getLetterGrade();
        String actualScoreC = quizC.getLetterGrade();
        String actualScoreD = quizD.getLetterGrade();
        String actualScoreF = quizF.getLetterGrade();

        // Assert
        assertEquals(expectedScoreA, actualScoreA, "Because 90-100% score percent should return A");
        assertEquals(expectedScoreB, actualScoreB, "Because 80-89% score percent should return B");
        assertEquals(expectedScoreC, actualScoreC, "Because 80-89% score percent should return C");
        assertEquals(expectedScoreD, actualScoreD, "Because 80-89% score percent should return D");
        assertEquals(expectedScoreF, actualScoreF, "Because 80-89% score percent should return F");

    }

    @Test
    public void possiblePoints_shouldBe_positive()
    {
        //Arrange
        Quiz positivePossiblePoints = new Quiz(12, "Patrick");
        Quiz negativePossiblePoints = new Quiz(-10, "Squidward");
        int expectedPositivePossiblePoints = 12;
        int expectedNegativePossiblePoints = 0;

        //Act
        boolean isActualPositive = positivePossiblePoints.getPossiblePoints() >= 0;
        boolean isActualNegative = negativePossiblePoints.getPossiblePoints() >= 0;
        int actualPositivePossiblePoints = positivePossiblePoints.getPossiblePoints();
        int actualNegativePossiblePoints = negativePossiblePoints.getPossiblePoints();

        //Assert
        assertTrue(isActualPositive, "Because it should be True/positive if possiblePoints is 12");
        assertTrue(isActualNegative, "Because it should be True/positive if possiblePoints is -10");
        assertEquals(expectedPositivePossiblePoints, actualPositivePossiblePoints);
        assertEquals(expectedNegativePossiblePoints, actualNegativePossiblePoints);
    }

    @Test
    public void setScore_shouldBe_positive()
    {
        //Arrange
        Quiz quiz1 = new Quiz(12, "Sandy");
        Quiz quiz2 = new Quiz(10, "Gary");
        int expectedScoreQuiz1 = 0;
        int expectedScoreQuiz2 = 1;

        //Act
        quiz1.setScore(-1);
        quiz2.setScore(1);
        boolean isActualPositiveQuiz1 = quiz1.getScore() >= 0;
        boolean isActualPositiveQuiz2 = quiz2.getScore() >= 0;
        int actualScoreQuiz1 = quiz1.getScore();
        int actualScoreQuiz2 = quiz2.getScore();

        //Assert
        assertTrue(isActualPositiveQuiz1, "Because it should be True/positive if score is -1");
        assertTrue(isActualPositiveQuiz2, "Because it should be True/positive if score is 1");
        assertEquals(expectedScoreQuiz1, actualScoreQuiz1);
        assertEquals(expectedScoreQuiz2, actualScoreQuiz2);
    }

}