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
        if (score < 0)
        {
            this.score = 0;
        }
        else
        {
            this.score = score;
        }
    }

    public int getPossiblePoints()
    {
        if (possiblePoints < 0)
        {
            return 0;
        }

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
        double percent = ((double) score / possiblePoints) * 100;
        return (int) percent;
    }

    public String getLetterGrade()
    {
        int percent = getPercent();

        if(percent >= 90) return "A";
        else if(percent >= 80) return "B";
        else if(percent >= 70) return "C";
        else if(percent >= 60) return "D";
        else return "F";
    }
}
