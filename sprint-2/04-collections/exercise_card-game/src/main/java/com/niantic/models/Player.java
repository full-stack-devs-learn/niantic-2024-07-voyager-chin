package com.niantic.models;

import java.util.ArrayList;

public class Player
{
    private String name;
    private Hand hand;
    private Penalty penalty;

    public Player(String name)
    {
        this.name = name;
        hand = new Hand();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void dealTo(Card card)
    {
        hand.dealTo(card);
    }

    public int getHandValue()
    {
        return hand.getPointValue();
    }

    public Hand getHand()
    {
        return hand;
    }

    public Card playCardFromHand(Card card)
    {
        hand.playCardFromHand(card);
        return card;
    }

    public ArrayList<Card> getPenaltyCards(ArrayList<Card> cards)
    {
        penalty.getPenaltyCards(cards);
        return cards;
    }

    public int getPenaltyPoints()
    {
        int penaltyPoints = penalty.getPenaltyPoints();
        return penaltyPoints;
    }
}
