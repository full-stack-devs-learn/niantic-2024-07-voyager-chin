package com.niantic.part_1;

public class Quiz
{
    private int score;
    private final int possiblePoints;
    private final String studentName;

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getPossiblePoints()
    {
        return possiblePoints;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public Quiz(int possiblePoints, String studentName)
    {
        this.possiblePoints = possiblePoints;
        this.studentName = studentName;
    }

    public int getPercent()
    {
        return score / possiblePoints * 100;
    }

    public String getLetterGrade()
    {
        int percent = getPercent();

        if(percent > 90) return "A";
        else if(percent > 80) return "B";
        else if(percent > 70) return "C";
        else if(percent > 50) return "D";
        else return "F";
    }
}
