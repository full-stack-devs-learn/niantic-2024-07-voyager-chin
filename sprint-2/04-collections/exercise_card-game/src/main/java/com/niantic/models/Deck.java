package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        // build the deck of cards
        cards = new ArrayList<>();

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] colors = {"Red", "Blue", "Green", "Yellow"};

        for(String color : colors)
        {
            for(int number : numbers)
            {
                Card card = new Card(color,number);
                cards.add(card);
            }
        }
    }

    public int getCardCount()
    {
        return cards.size();
    }

    public Card takeCard()
    {
        Card card = cards.removeFirst();
        return card;
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}
