package com.niantic.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class GradesFileServiceTest
{
    GradesFileService service;

    @BeforeEach
    public void setup()
    {
        service = new GradesFileService();
    }

    @org.junit.jupiter.api.Test
    void getFileNames_shouldReturn_arrayOfFileNames()
    {
        String[] expectedArray = {"student_1_anna_williams.csv"
                                , "student_2_david_jones.csv"
                                , "student_3_laura_brown.csv"
                                , "student_4_eric_walker.csv"
                                , "student_5_joshua_martin.csv"};

        String[] actualArray = service.getFileNames();

        assertArrayEquals(expectedArray, actualArray, "Because it should return all file names inside directory");
    }

    @org.junit.jupiter.api.Test
    void getAssignments_shouldReturn_studentAssignments()
    {
        int expectedCount = 15;
        int actualCount = service.getAssignments("student_5_joshua_martin.csv").size();

        assertEquals(expectedCount, actualCount, "Because it should return all assignments in the file");
    }

    @org.junit.jupiter.api.Test
    void getAllAssignments_shouldReturn_allAssignmentsInDirectory()
    {
        String[] fileNames = {"student_1_anna_williams.csv"
                            , "student_2_david_jones.csv"
                            , "student_3_laura_brown.csv"
                            , "student_4_eric_walker.csv"
                            , "student_5_joshua_martin.csv"};

        int expectedCount = 75;
        int actualCount = service.getAllAssignments(fileNames).size();

        assertEquals(expectedCount, actualCount, "Because it should return the total assignment count from all files");
    }
}