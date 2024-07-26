package com.niantic;

import java.util.Scanner;

public class Main
{
    private static Scanner userInput = new Scanner(System.in);
    private static int[] scores = new int[0];

    public static void main(String[] args)
    {
        while(true)
        {
            int choice = getHomeSelection();

            switch(choice)
            {
                case 1:
                    createNewTestScores();
                    break;
                case 2:
                    calculateAverage();
                    break;
                case 3:
                    findHighestScore();
                    break;
                case 4:
                    findLowestScore();
                    break;
                case 5:
                    System.out.println("Thanks for playing!");
                    System.out.println("Good bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }

    public static int getHomeSelection()
    {
        System.out.println();
        System.out.println("Welcome to <<Enter app name>>!");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Enter new test scores");
        System.out.println("2) Calculate the class average");
        System.out.println("3) Find the highest score");
        System.out.println("4) Find the lowest score");
        System.out.println("0) Exit");

        System.out.print("Please select an option:");
        return Integer.parseInt(userInput.nextLine());
    }

    private static void createNewTestScores()
    {
        System.out.println("Enter code to create a new array and ask for test scores");
    }

    private static void calculateAverage()
    {
        System.out.println("Add logic to calculate the average of all test scores, and display it");
    }

    private static void findHighestScore()
    {
        System.out.println("Find the highest score of all tests and display it");
    }

    private static void findLowestScore()
    {
        System.out.println("Find the lowest score of all tests and display it");
    }
}