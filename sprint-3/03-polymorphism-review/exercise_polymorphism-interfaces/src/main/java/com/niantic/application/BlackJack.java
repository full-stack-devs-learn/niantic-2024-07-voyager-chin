package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;
import com.niantic.ui.UserInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BlackJack
{
    Scanner input = new Scanner(System.in);

    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    Player winner = new Player("no winner");
    
    public void run()
    {
        startGame();

        playHands();


        UserInterface.displayAllPlayersCards(players);

        findWinner();
        UserInterface.displayWinner(winner);
    }

    private void startGame()
    {
        // start the game
        addPlayers();
        dealCards();
    }

    private void playHands()
    {
        Queue<Player> queuedPlayers = new LinkedList<>(players);

        while (!queuedPlayers.isEmpty())
        {
            var player = queuedPlayers.poll();
            UserInterface.displayPlayerCards(player);

            System.out.println();
            System.out.print("Hit or Stand? (h/s)");
            String response = input.nextLine()
                                   .strip()
                                   .toLowerCase();

            if(response.equalsIgnoreCase("h"))
            {
                // deal another card
                Card card = deck.takeCard();
                player.dealTo(card);

                if(player.getHandValue() <= 21)
                {
                    // add player back to the queue
                    queuedPlayers.offer(player);
                }
            }
        }
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
