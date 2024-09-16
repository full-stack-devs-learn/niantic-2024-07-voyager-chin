package com.niantic.services;

import com.niantic.models.Assignment;

import java.util.List;

public interface GradesService
{
    String[] getFileNames();

    List<Assignment> getAssignments(String fileName);

    List<Assignment> getAllAssignments(String[] fileNames);
}
