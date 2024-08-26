package com.niantic.application;

import com.niantic.models.*;
import com.niantic.ui.UserInterface;

import java.util.*;

import static com.niantic.ui.UserInterface.*;

public class CardGameApplication
{
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    Table table = new Table();
    Scanner input = new Scanner(System.in);
    Player winner = new Player("It's a tie!");
    
    public void run()
    {
        // Display Instructions
        displayWelcome();
        waitForUser();

        // Get player name
        addPlayers();
        waitForUser();

        // Game setup
        dealCards();
        setupTable();

        // Gameplay
        UserInterface.displayTableCards(table);
        playHands();

        // Game end & Winner
        System.out.println();
        displayFinalScore(players.get(0));
        displayFinalScore(players.get(1));
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
        // Get player name and display players
        players.add(new Player("-Ultron-"));
        System.out.print("Please provide your player name: ");
        String userName = input.nextLine().strip();
        players.add(new Player(userName));
        System.out.println();
        System.out.println("Hi " + userName + "!");
        System.out.println();
        System.out.println("PLAYERS:");
        System.out.println("Human Player " + players.get(1).getName() + " joined the game.");
        System.out.println("Bot Player " + players.get(0).getName() + " joined the game.");
        System.out.println();
        System.out.println("Good Luck!");
    }

    private void playHands()
    {
        for (int i = 0; i < 10; i++) // 10 rounds only (1 round for each player card in hand)
        {
            Card botCard = new Card(0);
            Card playerCard = new Card(0);

            // Each turn, each player will select and play a card
            Queue<Player> queuedPlayers = new LinkedList<>(players);

            while (!queuedPlayers.isEmpty())
            {
                var player = queuedPlayers.poll();

                if (player.getName().equalsIgnoreCase("-Ultron-"))
                {
                    // Play random card or first card from bot hand
                    Hand hand = player.getHand();
                    ArrayList<Card> cards = hand.getCards();

                    // bot defaults to getting a random first card from hand
                    Card card = cards.get(0);

                    // returns a card removed from hand
                    botCard = player.playCardFromHand(card);

                    // Put played card to table
                    table.playedCards(player, botCard);
                }
                else
                {
                    // Display player hand cards
                    UserInterface.displayHandCards(players.get(1));
                    // Put while loop while response is empty
                    Boolean isValidResponse = false;

                    while(!isValidResponse)
                    {
                        System.out.print("Select a number card to play: ");
                        String response = input.nextLine()
                                .strip()
                                .toLowerCase();

                        // Get player hand
                        Hand hand = player.getHand();
                        ArrayList<Card> cards = hand.getCards();

                        int intResponse = 0;

                        // convert response to number
                        try
                        {
                            intResponse = Integer.parseInt(response);
                        }
                        catch (NumberFormatException e1)
                        {
                        }

                        Boolean isCardFound = false;
                        int index = -1;

                        // Verify if response exists in hand
                        for(Card card : cards)
                        {
                            if (card.getValue() == intResponse)
                            {
                                // find index of selected card
                                index = cards.indexOf(card);
                                isCardFound = true;
                            }
                        }

                        // find card based on index
                        if (isCardFound)
                        {
                            // remove card from hand
                            Card card = cards.get(index); // get index of selected card

                            playerCard = player.playCardFromHand(card); // returns a card removed from hand

                            // add to table played card
                            table.playedCards(player, playerCard);
                            System.out.println();
                            System.out.println("PLAYER TURNS:");
                            System.out.println(player.getName() + " placed a card on the table.");
                            System.out.println(players.get(0).getName() + " placed a card on the table.");

                            isValidResponse = true;
                        }
                        else
                        {
                            System.out.println();
                            System.out.println("Sorry, you entered an invalid number.");
                            System.out.println("Please enter a valid number from your hand cards.");
                        }
                    }

                }
            }

            // Display cards revealed
            System.out.println();
            System.out.println("CARD REVEAL: ");
            displayPlayedCards(players.get(0), botCard);
            displayPlayedCards(players.get(1), playerCard);
            waitForUser();

            // Display which card went to which row
            System.out.println("ADD CARD TO TABLE ROW:");
            table.placeCardsToRow();

            // Display updated table
            UserInterface.displayTableCards(table);

            // add player back to queue
            queuedPlayers.offer(players.get(0));
            queuedPlayers.offer(players.get(1));
        }
    }

    private void findWinner()
    {
        int botPenalty = players.get(0).getPenaltyPoints();
        int playerPenalty = players.get(1).getPenaltyPoints();

        // If bot have higher penalty points than player, player wins
        if (botPenalty > playerPenalty)
        {
            winner = players.get(1);
        }
        else
        // If player have higher penalty points than bot, bot wins
        {
            winner = players.get(0);
        }
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
}
