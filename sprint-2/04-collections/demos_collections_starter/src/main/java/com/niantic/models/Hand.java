package com.niantic.models;

import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getPointValue()
    {
        // return sum of all card points
        int sum = 0;

        for(Card card : cards)
        {
            sum += card.getPointValue();
        }
        return sum;
    }

    public int getCardCount()
    {
        return cards.size();
    }


    public void dealTo(Card card)
    {
        cards.add(card);
    }
}
