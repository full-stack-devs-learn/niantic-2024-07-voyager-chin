package com.niantic.application;

import com.niantic.models.Student;
import com.niantic.services.StudentFileService;
import com.niantic.services.StudentService;

import java.io.File;
import java.util.List;

public class StudentsApp
{
    private static StudentService studentService = new StudentFileService();

    public static void main(String[] args)
    {
        displayAllStudents();
    }

    private static void displayAllStudents()
    {
        List<Student> students = studentService.getAllStudents();

        students.forEach(System.out::println);
    }

    public static void processFile(String fileName)
    {

        List<Student> students = studentService.getStudents(fileName);

        System.out.println();
        System.out.println(fileName);
        System.out.println("-".repeat(30));
        students.forEach(student -> {
            System.out.println(student);
        });
    }
}
