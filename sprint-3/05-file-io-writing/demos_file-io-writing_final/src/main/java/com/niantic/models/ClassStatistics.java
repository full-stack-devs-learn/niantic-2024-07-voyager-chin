package com.niantic.models;

import java.util.*;

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
        var lowestGpa =  students.stream()
                       .filter(s -> s.getGpa() <0)
                       .mapToDouble(Student::getGpa)
                        .min();

        if (lowestGpa.isPresent())
            return lowestGpa.getAsDouble();
        else
            return 0.0;

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
