package com.niantic.models.players;

import com.niantic.models.cards.Card;
import com.niantic.models.hands.BlackJackHand;
import com.niantic.models.hands.Hand;

public class Player
{
    private String name;
    private BlackJackHand hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new BlackJackHand();
    }

    public void deal(Card card)
    {
        hand.deal(card);
    }

    public String getName()
    {
        return name;
    }

    public Hand showHand()
    {
        hand.show();
        return hand;
    }

    public int getHandValue()
    {
        return hand.getValue();
    }
}
