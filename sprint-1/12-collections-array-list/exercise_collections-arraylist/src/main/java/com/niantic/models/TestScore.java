package com.niantic.models;

public class TestScore
{
    private String testName;
    private String studentName;
    private int score;

    public TestScore(String testName, String studentName, int score)
    {
        this.testName = testName;
        this.studentName = studentName;
        this.score = score;
    }

    public TestScore()
    {
    }

    public String getTestName()
    {
        return testName;
    }

    public void setTestName(String testName)
    {
        this.testName = testName;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
