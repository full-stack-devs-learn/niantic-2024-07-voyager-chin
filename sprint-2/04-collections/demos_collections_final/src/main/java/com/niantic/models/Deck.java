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

        String[] faces = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

        for(String suit : suits)
        {
            for(String face : faces)
            {
                Card card = new Card(suit,face);
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
