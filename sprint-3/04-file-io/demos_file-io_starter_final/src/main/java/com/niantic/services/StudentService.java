package com.niantic.services;

import com.niantic.models.Student;

import java.util.List;

public interface StudentService
{
    List<Student> getStudents(String fileName);

    List<Student> getAllStudents();
}
