package com.niantic.part_2_objects;

public class MathTest
{
    // Declare private variables for MathTest
    private int score;
    private int possiblePoint;
    private String studentName;


    // Parameterized constructor:
    public MathTest(int possiblePoint, String studentName)
    {
        this.possiblePoint = possiblePoint;
        this.studentName = studentName;
    }


    // Public 'getters' and 'setters':
    public int getScore() { return score; }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getPossiblePoints() { return possiblePoint; }

    public String getStudentName() { return studentName; }

    public int getPercent()
    {
        double percentage = (double) score / possiblePoint * 100;
        return (int) percentage;
    }

    public String getLetterGrade()
    {
        if (getPercent() >= 90)
        {
            return "A";
        }
        else if (getPercent() >= 80) {
            return "B";
        }
        else if (getPercent() >= 70) {
            return "C";
        }
        else if (getPercent() >= 60) {
            return "D";
        }
        else
        {
            return "F";
        }
    }
}
