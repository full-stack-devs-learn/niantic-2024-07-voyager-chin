package com.niantic.services;

import com.niantic.models.ClassStatistics;
import com.niantic.models.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportService
{
    public void createClassSummaryReport(ClassStatistics statistics)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String fileName = "reports/" + today.format(formatter) + "_" + statistics.getClassName().replace(" ", "_") + ".txt";

        File file = new File(fileName);

        try (PrintWriter out = new PrintWriter(file))
        {
            out.println(statistics.getClassName());
            out.println("-".repeat(30));
            out.printf("Low GPA:                 %.2f\n", statistics.getLowGpa());
            out.printf("High GPA:                %.2f\n", statistics.getHighGpa());
            out.printf("Average GPA:             %.2f\n", statistics.getLAverageGpa());
            out.println("-".repeat(30));
            statistics.getStudents().forEach(student -> out.println(student));
        }
        catch (FileNotFoundException e)
        {

        }
    }
}
