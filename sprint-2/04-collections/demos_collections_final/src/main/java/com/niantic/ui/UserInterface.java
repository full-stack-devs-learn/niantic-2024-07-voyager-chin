package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.Player;

import java.util.ArrayList;

public class UserInterface
{
    public static void displayAllPlayersCards(ArrayList<Player> players)
    {
        System.out.println("All Players");
        System.out.println("-".repeat(30));
        for (Player player : players)
        {
            displayPlayerCards(player);
        }
    }

    public static void displayPlayerCards(Player player)
    {
        System.out.println(player.getName() + ": " + player.getHandValue());
        for (Card card : player.getHand().getCards())
        {
            System.out.println("  " + card.getFaceValue() + " of " + card.getSuit());
        }
        System.out.println();
    }

    public static void displayWinner(Player winner)
    {
        System.out.println();
        System.out.println(ColorCodes.YELLOW + "*****************************************" + ColorCodes.RESET);
        System.out.println("           WINNER: " + winner.getName());
        System.out.println(ColorCodes.YELLOW + "*****************************************" + ColorCodes.RESET);
    }
}
