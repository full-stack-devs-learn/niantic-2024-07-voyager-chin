package com.niantic.application;

import com.niantic.models.ClassStatistics;
import com.niantic.models.Student;
import com.niantic.services.LoggingService;
import com.niantic.services.ReportService;
import com.niantic.services.StudentFileService;
import com.niantic.services.StudentService;
import com.niantic.ui.UserInput;

import java.util.Comparator;
import java.util.List;

public class StudentApplication implements Runnable
{
    private final StudentService studentService = new StudentFileService();
    private final UserInput ui = new UserInput();

    private final LoggingService errorLogger = new LoggingService("errors");
    private final LoggingService appLogger = new LoggingService("application");

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
                    displayClassDetails();
                    break;
                case 3:
                    displayAllClasses();
                    break;
                case 4:
                    createClassSummaryReport();
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }

    private void listClasses()
    {
        appLogger.logMessage("Listing all classes");
        var files = studentService.getFiles().stream().map(this::parseName).toList();

        ui.displayClasses(files);
    }

    private void displayClassDetails()
    {
        try
        {
            listClasses();
            int choice = ui.getIntInput("Please select a class: ") - 1;

            var files = studentService.getFiles();

            String filename = files.get(choice);
            appLogger.logMessage("Displaying " + filename + " class");
            processFile(filename);
        }
        catch(Exception e)
        {
            errorLogger.logMessage(e.getMessage());
        }
    }

    private void displayAllClasses()
    {
        appLogger.logMessage("Displaying all classes");
        List<Student> students = studentService.getAllStudents()
                                               .stream()
                                               .sorted(Comparator.comparing(Student::getFirstName))
                                               .toList();

        ui.displayStudents("All Classes",students);

    }

    public void processFile(String fileName)
    {

        List<Student> students = studentService.getStudents(fileName);

        var period = parseName(fileName);
        ui.displayStudents(period,students);
    }

    public void createClassSummaryReport()
    {
        listClasses();
        int choice = ui.getIntInput("Please select a class: ") - 1;

        var files = studentService.getFiles();
        String fileName = files.get(choice);
        var className = parseName(fileName);

        appLogger.logMessage("Create class summary report for " + className);

        List<Student> students = studentService.getStudents(fileName);
        ClassStatistics statistics = new ClassStatistics(className, students);

        ReportService service = new ReportService();

        service.createClassSummaryReport(statistics);

    }

    private String parseName(String fileName)
    {
        return fileName.substring(9, fileName.lastIndexOf(".")).replace("_", " ");
    }
}
