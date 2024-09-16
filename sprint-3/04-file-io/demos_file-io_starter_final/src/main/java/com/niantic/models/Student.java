package com.niantic.models;

public class Student
{
    private String firstName;
    private String lastName;
    private double gpa;

    public Student(String firstName, String lastName, double gpa)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    public Student()
    {
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

    public double getGpa()
    {
        return gpa;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s (%.2f)", firstName, lastName, gpa);
    }
}
