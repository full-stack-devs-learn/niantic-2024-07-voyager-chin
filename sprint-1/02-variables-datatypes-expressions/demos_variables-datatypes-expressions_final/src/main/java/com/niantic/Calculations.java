package com.niantic;

public class Calculations
{
    public static void main(String[] args)
    {

        // Calculate how many donuts per student
        int numberOfStudents = 4;
        int numberOfDonuts = 22;

        int donutsPerStudent = numberOfDonuts / numberOfStudents;
        int remainingDonuts = numberOfDonuts % numberOfStudents;
        double donutsPerStudentDouble = (double)numberOfDonuts / numberOfStudents;

        System.out.println("Number of donuts per student");
        System.out.println("Total donuts:       " + numberOfDonuts);
        System.out.println("Total students:     " + numberOfStudents);
        System.out.println("Donuts per student: " + donutsPerStudent);
        System.out.println("Remaining Donuts:   " + remainingDonuts);
        System.out.println();
        System.out.println("Donuts per student (double): " + donutsPerStudentDouble);
    }
}
