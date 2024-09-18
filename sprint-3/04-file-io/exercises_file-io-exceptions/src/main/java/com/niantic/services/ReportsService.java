package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportsService
{
    private static void ensureDirectoryExists(String path)
    {
        File directory = new File(path);
        if(!directory.exists())
        {
            directory.mkdir();
        }
    }

    public void createStudentSummaryReport(List<Assignment> assignments)
    {
        ensureDirectoryExists("reports");

        AssignmentStatistics stats = new AssignmentStatistics(assignments);

        String studentName = assignments.getFirst().getFirstName() + "_" + assignments.getFirst().getLastName();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "reports/" + today.format(formatter) + "_" + studentName + ".txt";

        File file = new File(fileName);

        List<Assignment> lowScoreAssignments = stats.getLowScoreAssignments();
        List<Assignment> highScoreAssignments = stats.getHighScoreAssignments();
        List<Assignment> averageScoreAssignments = stats.getAverageAssignments();

        try (FileOutputStream stream = new FileOutputStream(file, true);
             PrintWriter writer = new PrintWriter(stream))
        {
            writer.println(studentName.replace("_", " "));
            writer.println("-".repeat(40));
            writer.println();
            writer.println("-".repeat(40));
            writer.println(String.format("%-34s %3s", "Low Score", stats.getLowScore()));
            writer.println("-".repeat(40));
            for(Assignment assignment : lowScoreAssignments)
            {
                writer.println(String.format("%-3s %-30s %3s", assignment.getNumber(), assignment.getAssignmentName(), assignment.getScore()));
            }
            writer.println();
            writer.println("-".repeat(40));
            writer.println(String.format("%-34s %3s", "High Score", stats.getHighScore()));
            writer.println("-".repeat(40));
            for(Assignment assignment : highScoreAssignments)
            {
                writer.println(String.format("%-3s %-30s %3s", assignment.getNumber(), assignment.getAssignmentName(), assignment.getScore()));
            }
            writer.println();
            writer.println("-".repeat(40));
            writer.println(String.format("%-34s %3s", "Average Score", stats.getAverageScore()));
            writer.println("-".repeat(40));
            for(Assignment assignment : averageScoreAssignments)
            {
                writer.println(String.format("%-3s %-30s %3s", assignment.getNumber(), assignment.getAssignmentName(), assignment.getScore()));
            }
        }
        catch (IOException e)
        {

        }
    }

    public void createAllStudentSummaryReport(List<Assignment> assignments, int studentCount)
    {
        ensureDirectoryExists("reports");

        AssignmentStatistics stats = new AssignmentStatistics(assignments);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fileName = "reports/" + today.format(formatter) + "_all_students.txt";

        File file = new File(fileName);

        List<Assignment> lowScoreAssignments = stats.getLowScoreAssignments();
        List<Assignment> highScoreAssignments = stats.getHighScoreAssignments();
        List<Assignment> averageScoreAssignments = stats.getAverageAssignments();

        try (FileOutputStream stream = new FileOutputStream(file, true);
             PrintWriter writer = new PrintWriter(stream))
        {
            writer.println("All Assignments");
            writer.println("-".repeat(58));
            writer.println(String.format("%-53s %3s", "Total Students", studentCount));
            writer.println(String.format("%-53s %3s", "Total Assignments", stats.getAssignmentCount()));
            writer.println();
            writer.println("-".repeat(58));
            writer.println(String.format("%-53s %3s", "Low Score", stats.getLowScore()));
            writer.println("-".repeat(58));
            for(Assignment assignment : lowScoreAssignments)
            {
                writer.println(String.format("%-3s %-30s %-18s %3s", assignment.getNumber(), assignment.getAssignmentName(), assignment.getFirstName() + " " + assignment.getLastName(), assignment.getScore()));
            }
            writer.println();
            writer.println("-".repeat(58));
            writer.println(String.format("%-53s %3s", "High Score", stats.getHighScore()));
            writer.println("-".repeat(58));
            for(Assignment assignment : highScoreAssignments)
            {
                writer.println(String.format("%-3s %-30s %-18s %3s", assignment.getNumber(), assignment.getAssignmentName(), assignment.getFirstName() + " " + assignment.getLastName(), assignment.getScore()));
            }
            writer.println();
            writer.println("-".repeat(58));
            writer.println(String.format("%-53s %3s", "Average Score", stats.getAverageScore()));
            writer.println("-".repeat(58));
            for(Assignment assignment : averageScoreAssignments)
            {
                writer.println(String.format("%-3s %-30s %-18s %3s", assignment.getNumber(), assignment.getAssignmentName(), assignment.getFirstName() + " " + assignment.getLastName(), assignment.getScore()));
            }
        }
        catch (IOException e)
        {

        }
    }
}
