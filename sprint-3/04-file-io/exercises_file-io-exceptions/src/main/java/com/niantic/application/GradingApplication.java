package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.util.Arrays;
import java.util.List;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private int selection;

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    displayAllStudentStatistics();
                    break;
                case 5:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles()
    {
        // todo: 1 - get and display all student file names
        String[] files = gradesService.getFileNames();

        System.out.println();
        System.out.println("All Student Files:");
        System.out.println();

        try
        {
            for (int i = 0; i < files.length; i++) {
                System.out.println(i+1 + ") " + files[i]);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files

        displayAllFiles();

        selection = UserInput.fileSelection();

        // find file name String based on number input from file selection
        String[] files = gradesService.getFileNames();
        String selectedFile = files[selection-1];

        // use file name to get assignment
        List<Assignment> assignments = gradesService.getAssignments(selectedFile);
        String firstName = assignments.getFirst().getFirstName().substring(0,1).toUpperCase() +
                           assignments.getFirst().getFirstName().substring(1).toLowerCase();
        String lastName = assignments.getFirst().getLastName().substring(0,1).toUpperCase() +
                          assignments.getFirst().getLastName().substring(1).toLowerCase();

        System.out.println();
        System.out.println("Student Name: " + firstName + " " + lastName);
        System.out.println();
        System.out.println(String.format("%-30s %2s", "Assignment", "Score"));
        System.out.println("------------------------------------");
        for(Assignment assignment : assignments)
        {
            System.out.println(String.format("%-30s (%2d)", assignment.getAssignmentName(), assignment.getScore()));
        }
        System.out.println("------------------------------------");
    }

    private void displayStudentAverages()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)

        displayFileScores();

        // find file name String based on number input from file selection
        String[] files = gradesService.getFileNames();
        String selectedFile = files[selection-1];

        // use file name to get assignment
        List<Assignment> assignments = gradesService.getAssignments(selectedFile);
        String firstName = assignments.getFirst().getFirstName().substring(0,1).toUpperCase() +
                assignments.getFirst().getFirstName().substring(1).toLowerCase();
        String lastName = assignments.getFirst().getLastName().substring(0,1).toUpperCase() +
                assignments.getFirst().getLastName().substring(1).toLowerCase();

        var scores = assignments.stream().map(Assignment::getScore).sorted().toList();

        int lowScore = scores.getFirst();
        int highScore = scores.getLast();
        int averageScore = scores.stream().reduce(0, (subtotal, score) -> subtotal + score) / scores.size();

        System.out.println();
        System.out.println("Student Statistics: " + firstName + " " + lastName);
        System.out.println("Low Score: " + lowScore);
        System.out.println("High Score: " + highScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println();

        System.out.print("Go back to Main Menu?");
        UserInput.waitForUser();
    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }
}
