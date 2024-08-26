package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.Player;
import com.niantic.models.Table;

import java.util.ArrayList;

public class UserInterface
{

    public static void displayWelcome()
    {
        System.out.println();
        System.out.println("----------------- Welcome to -----------------");
        System.out.println("\n" +
                "    __    _   _ _                     _   _ \n" +
                "   / /   | \\ | (_)                   | | | |\n" +
                "  / /_   |  \\| |_ _ __ ___  _ __ ___ | |_| |\n" +
                " | '_ \\  | . ` | | '_ ` _ \\| '_ ` _ \\| __| |\n" +
                " | (_) | | |\\  | | | | | | | | | | | | |_|_|\n" +
                "  \\___/  |_| \\_|_|_| |_| |_|_| |_| |_|\\__(_)\n" +
                "                                            \n" +
                "                                            \n");
        System.out.println("-------------- Lite Version 1.0 --------------");
        System.out.println();
        System.out.println("Instructions:");
        System.out.println("     Setup: Each player will draw 10 cards to their hand. There will be 4 starting cards on the table.\n" +
                "     Play a Card: On your turn, place a card from your hand onto one of the game rows according to the rules.\n" +
                "     The card must be put on a row where the latest card is lower than the played card.\n" +
                "     If multiple rows have the latest card lower to the played card, the card must be put on the row where the latest card is the closest to the played card (the highest of the lower cards).\n" +
                "     Avoid Rows with 5 cards: Try not to place your card to rows that will cause you to pick up cards from the rows.\n" +
                "     If your card is lower than ALL the end cards, you are required to take ALL cards in the row that is automatically selected to have the lowest penalty points.Then place your card to restart the row.\n" +
                "     Score Points: The goal is to minimize your score by making strategic moves and avoiding penalties.\n" +
                "     End of Game: The game ends when the hand is empty, and the player with the lowest penalty score wins.\n" +
                "     For more details: You may visit https://boardgamemanuals.fandom.com/wiki/6_Nimmt!");
    }


    public static void displayTableCards(Table table)
    {
        System.out.println("-".repeat(70));
        System.out.println("                      Table Cards                      ");
        System.out.println("-  ".repeat(24));

        // ROW A
        System.out.print(" A: ");
        var rowA = table.getRowA();
        rowA.stream().forEach(card -> System.out.print(card.getValue() + " | "));
        System.out.println();

        // ROW B
        System.out.print(" B: ");
        var rowB = table.getRowB();
        rowB.stream().forEach(card -> System.out.print(card.getValue() + " | "));
        System.out.println();

        // ROW C
        System.out.print(" C: ");
        var rowC = table.getRowC();
        rowC.stream().forEach(card -> System.out.print(card.getValue() + " | "));
        System.out.println();

        // ROW D
        System.out.print(" D: ");
        var rowD = table.getRowD();
        rowD.stream().forEach(card -> System.out.print(card.getValue() + " | "));
        System.out.println();

    }

    public static void displayPlayedCards(ArrayList<Player> players)
    {
        // Display chosen cards for both players per round
        System.out.println("All Players");
        System.out.println("-".repeat(70));
        for (Player player : players)
        {
            System.out.println(player.getName() + ": " + player.getHandValue());
            System.out.println();
        }
    }

    // Display player cards
    public static void displayHandCards(Player player)
    {
        System.out.println("-".repeat(70));
        System.out.print("Hand Cards: ");
        var hand = player.getHand();
        var cards = hand.getCards();

        cards.stream().forEach(card -> System.out.print(card.getValue() + " | "));
        System.out.println();
        System.out.println("-".repeat(70));

    }

    public static void displayWinner(Player winner)
    {
        System.out.println();
        System.out.println(ColorCodes.YELLOW + "*****************************************" + ColorCodes.RESET);
        System.out.println("           WINNER: " + winner.getName());
        System.out.println(ColorCodes.YELLOW + "*****************************************" + ColorCodes.RESET);
        System.out.println();
        System.out.println("Thanks for playing!");
    }

    public static void displayFinalScore(Player player)
    {
        System.out.println(player.getName() + " collected " + player.getPenaltyPoints() + " penalty points.");
    }

    // display penalty cards taken
    public static void displayPenaltyCardsTaken(Player player, String row)
    {
        System.out.println(player.getName() + " took penalty cards from Row " + row + ".");
    }

    // display played cards
    public static void displayPlayedCards(Player player, Card card)
    {

        System.out.println(player.getName() + " played card: " + card.getValue());
    }

    // display which card was placed to which row
    public static void displayCardPlacedToRow(Player player, Card card, String row)
    {
        System.out.println(player.getName() + " card " + card.getValue() + " was added to Row " + row);
    }
}
