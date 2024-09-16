package com.niantic.models;

public class Assignment
{
    private int number;
    private String firstName;
    private String lastName;
    private String assignmentName;
    private int score;

    public Assignment(int number, String firstName, String lastName, String assignmentName, int score)
    {
        this.number = number;
        this.assignmentName = assignmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public Assignment()
    {
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getAssignmentName()
    {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName)
    {
        this.assignmentName = assignmentName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return String.format("%-3d %-30s %-5d", number, assignmentName, score);
    }
}
