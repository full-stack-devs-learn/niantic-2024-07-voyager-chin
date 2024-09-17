package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService
{

    @Override
    public String[] getFileNames()
    {
        File directory = new File("files/");
        try
        {
            String[] files = directory.list();
            Arrays.sort(files);
            return files;
        }
        catch (Exception e)
        {
            return new String[0];
        }

    }

    @Override
    public List<Assignment> getAssignments(String fileName)
    {
        File file = new File("files/" + fileName);
        List<Assignment> assignments = new ArrayList<>();

        // Assignment(int number, String firstName, String lastName, String assignmentName, int score)
        try (Scanner reader = new Scanner(file))
        {
            // skips the header row
            reader.nextLine();

            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                var columns = line.split(",");
                int number = Integer.parseInt(columns[0]);
                String firstName = columns[1];
                String lastName = columns[2];
                String assignmentName = columns[3];
                int score = Integer.parseInt(columns[4]);

                Assignment assignment = new Assignment(number, firstName, lastName, assignmentName, score);
                assignments.add(assignment);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames)
    {
        List<Assignment> allAssignments = new ArrayList<>();

        for(String file : fileNames)
        {
            List<Assignment> assignments = getAssignments(file);

            for(Assignment assignment: assignments)
            {
                allAssignments.add(assignment);
            }
        }

        return allAssignments;
    }
}
