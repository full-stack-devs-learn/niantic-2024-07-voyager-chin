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
                    scores = createNewTestScores();
                    break;
                case 2:
                    calculateAverage(scores);
                    break;
                case 3:
                    findHighestScore(scores);
                    break;
                case 4:
                    findLowestScore(scores);
                    break;
                case 0:
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
        System.out.println("Welcome to the Scoring App!");
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

    private static int[] createNewTestScores()
    {
        //System.out.println("Enter code to create a new array and ask for test scores");

        //Display question to ask user the scoreCount
        System.out.println("How many test scores do you have? ");
        System.out.println();

        //Get user input for scoreCount
        int scoreCount = Integer.parseInt(userInput.nextLine());

        //Create a new array with size based on scoreCount
        int[] testScores = new int[scoreCount];

        //Create for loop to get scores
        for (int i = 0; i < scoreCount; i++) {
            System.out.println("Please enter score #" + (i+1) + ": ");
            //Each user input will be stored into the testScores array
            testScores[i] = Integer.parseInt(userInput.nextLine());
        }

        //Display a confirmation once user input is complete
        System.out.println("Thank you! Scores have been recorded.");
        System.out.println("------");

        //Display each score for user can view
        System.out.println("The scores are:");
        for (int score : testScores)
        {
        System.out.println(score);
        }

        System.out.println("----------------------------------");

        //Return the array of testScores
        return testScores;
    }

    private static void calculateAverage(int[] options)
    {
        //System.out.println("Add logic to calculate the average of all test scores, and display it");

        //Create variable that will store the sum
        int sum = 0;

        //Creates a loop that will add each value to sum
        for (int i = 0; i < options.length ; i++) {
            sum += options[i];
        }

        //Get average of sum using the array size
        int average = sum / options.length;

        //Display the average so user can view
        System.out.println("The average score is: " + average);

    }

    private static void findHighestScore(int[] options)
    {
        //System.out.println("Find the highest score of all tests and display it");

        //Create a variable that will store the highest value that will initially store the first index
        int highest = options[0];

        //Loop will compare each value to the currently stored value in the highest variable
        for (int option : options)
        {
            //If the current value is higher than the value in the highest variable:
            if (option > highest)
            {
                //the current value will replace the value in the highest variable
                highest = option;
            }
        }

        //Display the highest value for user to view
        System.out.println("The highest score is: " + highest);
    }

    private static void findLowestScore(int[] options)
    {
        //System.out.println("Find the lowest score of all tests and display it");

        //Create a variable that will store the lowest value that will initially store the first index
        int lowest = options[0];

        //Loop will compare each value to the currently stored value in the lowest variable
        for (int option : options)
        {
            //If the current value is higher than the value in the lowest variable:
            if (option < lowest)
            {
                //the current value will replace the value in the lowest variable
                lowest = option;
            }
        }

        //Display the lowest value for user to view
        System.out.println("The lowest score is: " + lowest);
    }
}