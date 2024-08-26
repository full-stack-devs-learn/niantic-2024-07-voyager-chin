package com.niantic.models;

import java.util.ArrayList;

public class Penalty
{
    // Collect cards from rows and store them in variables
    ArrayList<Card> botPenaltyCards = new ArrayList<>();
    ArrayList<Card> playerPenaltyCards = new ArrayList<>();

    ArrayList<Card> penaltyCardsCollected = new ArrayList<>();

    public void getPenaltyCards(ArrayList<Card> cards)
    {
        for (Card card : cards)
        {
            penaltyCardsCollected.add(card);
        }
    }

    // Get penalty for bot
    public int getTotalBotPenalties()
    {
        ArrayList<Card> cards = botPenaltyCards;
        int total = 0;

        for(Card card : cards)
        {
            total += card.getValue();
        }
        return total;
    }

    // Get penalty for player
    public int getTotalPlayerPenalties()
    {
        ArrayList<Card> cards = playerPenaltyCards;

        int total = 0;

        for(Card card : cards)
        {
            total += card.getValue();
        }
        return total;
    }

    // get penalty points of any player
    public int getPenaltyPoints()
    {
        ArrayList<Card> cards = penaltyCardsCollected;
        int total = 0;

        for(Card card : cards)
        {
            total += card.getValue();
        }
        return total;
    }
}
