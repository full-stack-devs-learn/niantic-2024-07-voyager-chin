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

        System.out.println();
        System.out.print("Go back to Main Menu?");
        UserInput.waitForUser();
    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files

        displayAllFiles();

        int selection = UserInput.fileSelection();

        // find file name String based on number input from file selection
        String[] files = gradesService.getFileNames();
        String selectedFile = files[selection-1];

        // use file name to get assignment
        List<Assignment> assignments = gradesService.getAssignments(selectedFile);
        String studentName = parseStudentName(assignments.getFirst().getFirstName(), assignments.getFirst().getLastName());

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("Student Name: " + studentName);
        System.out.println("------------------------------------");
        System.out.println(String.format("%-30s %2s", "Assignment", "Score"));
        System.out.println("------------------------------------");
        for(Assignment assignment : assignments)
        {
            System.out.println(String.format("%-30s (%2d)", assignment.getAssignmentName(), assignment.getScore()));
        }
        System.out.println("------------------------------------");
        System.out.println();

        System.out.print("Go back to Main Menu?");
        UserInput.waitForUser();
    }

    private void displayStudentAverages()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)

        displayAllFiles();

        int selection = UserInput.fileSelection();

        // find file name String based on number input from file selection
        String[] files = gradesService.getFileNames();
        String selectedFile = files[selection-1];

        // use file name to get assignment
        List<Assignment> assignments = gradesService.getAssignments(selectedFile);
        String studentName = parseStudentName(assignments.getFirst().getFirstName(), assignments.getFirst().getLastName());

        var scores = assignments.stream().map(Assignment::getScore).sorted().toList();

        int lowScore = scores.getFirst();
        int highScore = scores.getLast();
        int averageScore = scores.stream().reduce(0, (subtotal, score) -> subtotal + score) / scores.size();

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("Student Statistics: " + studentName);
        System.out.println("Low Score: " + lowScore);
        System.out.println("High Score: " + highScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println("------------------------------------");
        System.out.println();

        System.out.print("Go back to Main Menu?");
        UserInput.waitForUser();
    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)

        String[] files = gradesService.getFileNames();
        List<Assignment> assignments = gradesService.getAllAssignments(files);

        var scores = assignments.stream().map(Assignment::getScore).sorted().toList();

        int lowScore = scores.getFirst();
        int highScore = scores.getLast();
        int averageScore = scores.stream().reduce(0, (subtotal, score) -> subtotal + score) / scores.size();
        int numberOfStudents = files.length;
        int numberOfAssignments = gradesService.getAssignments(files[0]).size();

        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("All Student Statistics");
        System.out.println("------------------------------------");
        System.out.println("Low Score: " + lowScore);
        System.out.println("High Score: " + highScore);
        System.out.println("Average Score: " + averageScore);
        System.out.println("Number of Students: " + numberOfStudents);
        System.out.println("Number of Assignments: " + numberOfAssignments);
        System.out.println("------------------------------------");
        System.out.println();

        System.out.print("Go back to Main Menu?");
        UserInput.waitForUser();
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private String parseStudentName(String firstName, String lastName)
    {
        firstName = firstName.substring(0,1).toUpperCase() +
                    firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0,1).toUpperCase() +
                   lastName.substring(1).toLowerCase();

        return firstName + " " + lastName;
    }
}
