package com.niantic;

import java.util.Scanner;

public class Main
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        backyardBasketBall();
        clairesCookies();
        elliotsYardCare();
    }

    private static void backyardBasketBall()
    {
        BackyardBasketball ballGames = new BackyardBasketball();

        int gamesWon = 13;
        int gamesLost = 0;
        int winningPercentage = ballGames.calculateWinningPercentage(gamesWon, gamesLost);
        System.out.println("Winning percentage: " + winningPercentage);

    }

    private static void clairesCookies()
    {

    }

    private static void elliotsYardCare()
    {

    }
}