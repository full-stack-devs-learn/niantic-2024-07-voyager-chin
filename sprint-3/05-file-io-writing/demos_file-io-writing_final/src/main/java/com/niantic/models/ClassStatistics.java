package com.niantic.models;

import java.util.List;

public class ClassStatistics
{
    private String className;
    private List<Student> students;

    public ClassStatistics(String className, List<Student> students)
    {
        this.className = className;
        this.students = students;
    }

    public String getClassName()
    {
        return className;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public double getLowGpa()
    {
        return students.stream().mapToDouble(Student::getGpa).min().getAsDouble();
    }

    public double getHighGpa()
    {
        return students.stream().mapToDouble(Student::getGpa).max().getAsDouble();
    }

    public double getLAverageGpa()
    {
        return students.stream().mapToDouble(Student::getGpa).average().getAsDouble();
    }
}
