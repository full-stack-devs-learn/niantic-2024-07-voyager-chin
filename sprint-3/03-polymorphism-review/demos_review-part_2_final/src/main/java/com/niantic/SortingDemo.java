package com.niantic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDemo
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Emily","Williams",3.51));
        students.add(new Student("Sarah","Johnson",2.31));
        students.add(new Student("John","Smith",2.05));
        students.add(new Student("Anna","Williams",3.02));
        students.add(new Student("Jane","Garcia",3.96));
        students.add(new Student("David","Jones",3.24));
        students.add(new Student("Laura","Brown",2.97));
        students.add(new Student("Chris","Martinez",3.4));
        students.add(new Student("Michael","Davis",2.43));
        students.add(new Student("James","Miller",3.08));

        // this method requires that the objects implement Comparable<T>
        Collections.sort(students, new StudentNameComparer());

        // sorting using streams
        var sortedList = students.stream()
                                 .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                                 .toList();

        sortedList.forEach(System.out::println);
    }
}
