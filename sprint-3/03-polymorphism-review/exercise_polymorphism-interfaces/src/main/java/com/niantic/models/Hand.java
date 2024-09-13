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
        int sum = cards.stream()
                        .map(card -> card.getPointValue())
                        .reduce(0, (temp, value) -> temp + value);

        return sum;
    }

    public void Sort()
    {
        // Todo: Exercise 2: implement this sort method

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
