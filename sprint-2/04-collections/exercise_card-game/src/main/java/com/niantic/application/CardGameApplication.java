package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;

public class CardGameApplication
{
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    
    public void run()
    {
        addPlayers();
        dealCards();
        UserInterface.displayAllPlayersCards(players);
    }

    private void dealCards()
    {
        deck.shuffle();

        for (int i = 0; i < 2; i++)
        {
            for(Player player : players)
            {
                Card card = deck.takeCard();
                player.dealTo(card);
            }
        }
    }

    private void addPlayers()
    {
        players.add(new Player("One"));
        players.add(new Player("Two"));
    }
}
