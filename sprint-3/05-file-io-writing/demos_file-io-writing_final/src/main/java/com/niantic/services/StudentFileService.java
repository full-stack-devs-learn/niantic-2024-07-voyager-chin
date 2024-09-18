package com.niantic.services;

import com.niantic.models.Student;

import java.io.File;
import java.util.*;

public class StudentFileService implements StudentService
{
    @Override
    public List<String> getFiles()
    {
        File directory = new File("files");
        String[] files = directory.list();

        return Arrays.stream(files).sorted().toList();
    }

    @Override
    public List<Student> getStudents(String fileName)
    {
        File file = new File("files/" + fileName);

        List<Student> students = new ArrayList<>();

        try(Scanner reader = new Scanner(file))
        {
            // this skips the header row
            reader.nextLine();

            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                var columns = line.split(",");

                String firstName = columns[0];
                String lastName = columns[1];
                double gpa = Double.parseDouble(columns[2]);

                Student student = new Student(firstName, lastName, gpa);
                students.add(student);
            }
        }
        catch (Exception e)
        {
            // swallow exception
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();

        var files = getFiles();

        files.forEach(file -> students.addAll(getStudents(file)));

        return students;
    }

    public List<Student> filterStudentsByGpa(double gpa)
    {
        List<Student> students = getAllStudents();
        return students.stream().filter(s -> s.getGpa() >= gpa).toList();
    }
}
