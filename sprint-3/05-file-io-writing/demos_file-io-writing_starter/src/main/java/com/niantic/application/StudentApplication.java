package com.niantic.application;

import com.niantic.models.Student;
import com.niantic.services.StudentFileService;
import com.niantic.services.StudentService;
import com.niantic.ui.UserInput;

import java.util.List;

public class StudentApplication implements Runnable
{
    private final StudentService studentService = new StudentFileService();
    private final UserInput ui = new UserInput();

    @Override
    public void run()
    {
        while(true)
        {
            int choice = ui.homeScreenSelection();

            switch(choice)
            {
                case 1:
                    listClasses();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }

    private void listClasses()
    {
        var files = studentService.getFiles();
        ui.displayClasses(files);
    }

    private void displayStudent()
    {
        var files = studentService.getFiles();
        ui.displayClasses(files);
        int choice = ui.getIntInput("Please select a file: ");

        String filename = files.get(choice);
        processFile(filename);
    }

    private void displayAllStudents()
    {
        List<Student> students = studentService.getAllStudents();

        students.forEach(System.out::println);
    }

    public void processFile(String fileName)
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
