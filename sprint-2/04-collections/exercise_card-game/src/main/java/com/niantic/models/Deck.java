package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards ;

    public Deck()
    {
        // build the deck of cards
        cards = new ArrayList<>();

        // Card numbers for 2 player game
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

        for (int number: numbers)
        {
            Card card = new Card(number);
            cards.add(card);
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
