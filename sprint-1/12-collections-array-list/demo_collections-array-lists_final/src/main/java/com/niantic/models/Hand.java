package com.niantic.models;

import java.util.ArrayList;

public class Hand
{
    private String playerName;
    private ArrayList<Card> cards;
    private int value = 0;

    public Hand(String playerName)
    {
        this.playerName = playerName;
        cards = new ArrayList<>();
    }

    public void deal(Card card)
    {
        cards.add(card);
        value += card.getPointValue();
    }

    public int getValue()
    {
        return value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
