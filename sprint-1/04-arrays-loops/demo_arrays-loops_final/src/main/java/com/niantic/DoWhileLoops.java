package com.niantic;

import java.util.Scanner;

public class DoWhileLoops
{
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String playAgain;

        do
        {
            System.out.println("Welcome to our game...");
            System.out.println("Game over");
            System.out.println();

            System.out.print("Do you want to play again? (y/n) ");
            playAgain = userInput.nextLine();
        }
        while(playAgain.equalsIgnoreCase("y"));

    }
}
