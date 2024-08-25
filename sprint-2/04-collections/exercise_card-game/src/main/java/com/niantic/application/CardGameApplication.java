package com.niantic.application;

import com.niantic.models.*;
import com.niantic.ui.UserInterface;

import java.util.*;

public class CardGameApplication
{
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    Table table = new Table();
    Scanner input = new Scanner(System.in);
    Player winner = new Player("It's a tie!");
    
    public void run()
    {
        addPlayers();
        dealCards();
        setupTable();
        UserInterface.displayTableCards(table);
//        while(true)
//        {
//
//        }
//        UserInterface.displayHandCards(players.get(1));
        playHands();

        findWinner();
        UserInterface.displayWinner(winner);

    }

    // Get 4 Starting cards for Table
    public void setupTable()
    {
        deck.shuffle();

        Card card = deck.takeCard();
        table.addToRowA(card);

        card = deck.takeCard();
        table.addToRowB(card);

        card = deck.takeCard();
        table.addToRowC(card);

        card = deck.takeCard();
        table.addToRowD(card);

    }

    // Deal cards to each Player
    private void dealCards()
    {
        deck.shuffle();

        for (int i = 0; i < 10; i++)
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
        players.add(new Player("-Ultron-"));
        players.add(new Player("-YOU-"));
    }

    private void playHands()
    {
        for (int i = 0; i < 10; i++) // 10 rounds
        {
            Queue<Player> queuedPlayers = new LinkedList<>(players);

            while (!queuedPlayers.isEmpty())
            {
                var player = queuedPlayers.poll();
    //            UserInterface.displayPlayerCards(player);
                Card botCard;
                Card playerCard;


                if (player.getName().equalsIgnoreCase("-Ultron-"))
                {
                    // play random card or first card from bot hand
                    Hand hand = player.getHand();
                    ArrayList<Card> cards = hand.getCards();

                    Card card = cards.get(0); // bot defaults to getting first card from hand (can also be the highest value card for more difficulty)

                    botCard = player.playCardFromHand(card); // returns a card removed from hand

                    // add to table played card
                    table.playedCards(player, botCard);
                    System.out.println(player.getName() + " placed a card on the table.");

                    // add player back to queue
                    queuedPlayers.offer(player);

                }
                else
                {
                    // Display player hand cards
                    UserInterface.displayHandCards(players.get(1)); // displays card of user playing the game
                    // PUT A WHILE LOOP WHILE RESPONSE IS EMPTY
                    String response = "";

                    while(response.isEmpty())
                    {
                        System.out.println("Select a number card to play: ");
                        response = input.nextLine()
                                .strip()
                                .toLowerCase();

                        // Get player hand
                        Hand hand = player.getHand();
                        ArrayList<Card> cards = hand.getCards();

                        // convert response to card
                        Card card = new Card(Integer.parseInt(response));

                        // find index of selected card
                        // find card based on index
                        int index = cards.indexOf(card);

                        // Verify if response exists in hand
                        if (index >= 0)
                        {
                            // remove card from hand
                            card = cards.get(index); // put index of selected card

                            playerCard = player.playCardFromHand(card); // returns a card removed from hand

                            // add to table played card
                            table.playedCards(player, playerCard);

                            System.out.println(player.getName() + " placed a card on the table.");

                            // ADD BACK PLAYER TO QUEUE
                            queuedPlayers.offer(player);
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Sorry, you entered an invalid number.");
                            System.out.println("Please enter a valid number from your hand cards: ");
    //                        response = input.nextLine()
    //                                .strip()
    //                                .toLowerCase();
                        }
                    }

                }


    //            if(response.equalsIgnoreCase("h"))
    //            {
    //                // deal another card
    //                Card card = deck.takeCard();
    //                player.dealTo(card);
    //
    //                if(player.getHandValue() <= 21)
    //                {
    //                    // add player back to the queue
    //                    queuedPlayers.offer(player);
    //                }
    //            }
            }
        }
    }

    private void findWinner()
    {
        int botPenalty = players.get(0).getPenaltyPoints();
        int playerPenalty = players.get(1).getPenaltyPoints();

        if (botPenalty > playerPenalty)
        {
            winner = players.get(0);
        }
        else
        {
            winner = players.get(1);
        }

//        for (Player player: players)
//        {
//            int points = player.getPenaltyPoints();
//            if(points > winner.getHandValue() && points <= 21 )
//            {
//                winner = player;
//            }
//        }
    }

    // <editor-fold desc="Helpers">

    private void waitForUser()
    {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        input.nextLine();
    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return input.nextLine();
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    // </editor-fold>

    // Each turn, each player will select and show their cards
    // Lower card value will be put on the table rows first
    // Get the last value of Stack (using .lastElement()?) and find row nearest to the player card value
        // compare all row lastElement() to player card
        // if player card is lower than all lastElement() cards, player will choose which row to take
        // (bot player can default to taking the first row OR row with fewest points)
    // if row size is < 5: add card, else: take all table row cards then add card to same row



    // PLAYER WITH FEWEST PENALTY POINTS WIN!
    // Display winning player
}
