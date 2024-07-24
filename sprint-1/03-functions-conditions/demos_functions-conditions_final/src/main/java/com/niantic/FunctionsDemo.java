package com.niantic;

// you must import the java.util.Scanner package
import java.util.Scanner;

public class FunctionsDemo
{
    public static void main(String[] args)
    {
        // to get UserInput user a Scanner object
        Scanner userInput = new Scanner(System.in);

        // variables for
        int rank;
        String teamName;
        int q1, q2, q3, q4;

        // prompt the user for football team information
        System.out.print("Enter the team rank: ");
        rank = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Enter the team name: ");
        teamName = userInput.nextLine();

        System.out.print("Q1 score: ");
        q1 = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Q2 score: ");
        q2 = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Q3 score: ");
        q3 = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Q4 score: ");
        q4 = userInput.nextInt();
        userInput.nextLine();


        // use function to display team information
        System.out.println("Football Scores:");
        // use hard coded values for the first 2 teams
        displayTeamScores(1, "Georgia", 12, 14, 6, 7);
        displayTeamScores(2, "Alabama", 14, 17, 10, 14);
        // use the variables from the user input to display the 3rd team
        displayTeamScores(rank,teamName,q1,q2,q3,q4);



        // calculateFinalScore() can be called by
        // any other function.
        // Here we are using the calculateFinalScore
        // to calculate the total score of 4 card games
        System.out.println();
        System.out.println("Cards Games Total: ");
        int game1 = 3;
        int game2 = 4;
        int game3 = 5;
        int game4 = 6;
        int totalScore = calculateFinalScore(game1, game2, game3, game4);
        System.out.println("Game total: " + totalScore);


    }

    // function signature
    // displayTeamScores - the name of the function
    // void - return type
    // (int rank, ...) - inside of parenthesis - Parameters (variables)
    public static void displayTeamScores(int rank, String teamName, int q1, int q2, int q3, int q4)
    {
        int finalScore = calculateFinalScore(q1, q2, q3, q4);

        System.out.printf("(%d) %s \n", rank, teamName);
        System.out.println("-------------------------------");
        System.out.println(" Q1  Q2  Q3  Q4  Final");
        System.out.println(" --- --- --- --- -----");
        System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
        System.out.println();
    }

    public static int calculateFinalScore(int first, int second, int third, int fourth)
    {
        return first + second + third + fourth;
    }
}
