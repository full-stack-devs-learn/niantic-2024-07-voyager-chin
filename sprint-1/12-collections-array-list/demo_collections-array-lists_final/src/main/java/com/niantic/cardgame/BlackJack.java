package com.niantic.cardgame;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Hand;

public class BlackJack
{
    private Deck deck;

    public BlackJack()
    {
        deck = new Deck();
    }

    public void play()
    {
        deck.shuffle();
        Hand player1 = new Hand("Elena");
        Hand player2 = new Hand("Charletta");


        for (int i = 0; i < 2; i++)
        {
            Card card = deck.dealCard();
            player1.deal(card);

            card = deck.dealCard();
            player2.deal(card);
        }

        System.out.println(player1.getPlayerName() + ": " +  player1.getValue());
        System.out.println(player2.getPlayerName() + ": " +  player2.getValue());

    }
}
