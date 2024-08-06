package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();

        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for(var suit: suits)
        {
            for(var face: faces)
            {
                cards.add(new Card(suit, face));
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public Card dealCard()
    {
        Card card = cards.removeFirst();
        return card;
    }
}
