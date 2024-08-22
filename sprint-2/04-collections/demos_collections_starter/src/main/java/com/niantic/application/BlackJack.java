package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;

public class BlackJack
{
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    Player winner = new Player("no winner");
    
    public void run()
    {
        addPlayers();
        dealCards();
        UserInterface.displayAllPlayersCards(players);
        findWinner();
        UserInterface.displayWinner(winner);
    }

    private void findWinner()
    {
        for (Player player: players)
        {
            int points = player.getHandValue();
            if(points > winner.getHandValue() && points <= 21 )
            {
                winner = player;
            }
        }
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
        players.add(new Player("Emily"));
        players.add(new Player("Lucas"));
        players.add(new Player("Sophia"));
        players.add(new Player("Mason"));
    }
}
