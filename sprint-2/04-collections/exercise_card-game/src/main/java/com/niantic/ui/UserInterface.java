package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.Hand;
import com.niantic.models.Player;
import com.niantic.models.Table;

import java.util.Scanner;
import java.util.stream.Stream;

import java.util.ArrayList;
import java.util.Stack;

public class UserInterface
{
//    static Table table = new Table();


    public static void displayTableCards(Table table)
    {
        System.out.println("-".repeat(70));
        System.out.println("  Table Cards  ");
        System.out.println("-  ".repeat(24));
//        System.out.println();

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
//            for (Card card : player.getHand().getCards())
//            {
//                System.out.println("  " + card.getColor() + " " + card.getValue());
//            }
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

    // Get user input for number and row to play


    public static void displayWinner(Player winner)
    {
        System.out.println();
        System.out.println(ColorCodes.YELLOW + "*****************************************" + ColorCodes.RESET);
        System.out.println("           WINNER: " + winner.getName());
        System.out.println(ColorCodes.YELLOW + "*****************************************" + ColorCodes.RESET);
    }

    // display penalty cards taken
    public static void displayPenaltyCardsTaken(Player player, String row)
    {
        System.out.println(player.getName() + " has taken penalty cards from Row " + row + ".");
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

    // Ask user name

    // Instructions
    // Setup: Each player will draw 10 cards to their hand. There will be 4 starting card on the table.
    // Play a Card: On your turn, place a card from your hand onto one of the game rows according to the rules.
        // -- Choose card
            // -- Display user card and bot card
        // -- Choose row
        // -- Check if row has 5 cards, take
    // Avoid Rows with 5 cards: Be careful not to place your card to rows that will cause you to pick up cards from the rows.
    // NOTE: If your card is lower than ALL the end cards, you are required to take ALL cards in any row and place your card to start a new row.
    // Score Points: The goal is to minimize your score by making strategic moves and avoiding penalties.
    // End of Game: The game ends when the hand is empty, and the player with the lowest score wins.
    // For more details: You may visit https://boardgamemanuals.fandom.com/wiki/6_Nimmt!
}
