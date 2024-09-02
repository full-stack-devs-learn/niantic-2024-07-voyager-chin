package com.niantic.models;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

import static com.niantic.ui.UserInterface.displayCardPlacedToRow;
import static com.niantic.ui.UserInterface.displayPenaltyCardsTaken;

public class Table
{
    // Table can get initial cards and display it
    // Organize 4 rows
    // Collect play cards and put in rows
    // Can reset rows
    // Can convert cards values to penalty points

    private Penalty penalty;
    public ArrayList<Player> players;

    // 4 Rows of Cards in Table
    ArrayList<Card> rowA = new ArrayList<>();
    ArrayList<Card> rowB = new ArrayList<>();
    ArrayList<Card> rowC = new ArrayList<>();
    ArrayList<Card> rowD = new ArrayList<>();

    // Player Cards per turn
    Card botCard = new Card(0);
    Card playerCard = new Card(0);

    Player botPlayer;
    Player userPlayer;

    Card lowerCard;
    Card higherCard;
    Player lowerCardPlayer;
    Player higherCardPlayer;

    // Parameterless
    public Table() {}

    // Parameterized
    public Table(ArrayList<Card> rowA, ArrayList<Card> rowB, ArrayList<Card> rowC, ArrayList<Card> rowD) {
        this.rowA = rowA;
        this.rowB = rowB;
        this.rowC = rowC;
        this.rowD = rowD;
    }

    // Get End cards
    public Card getRowEndCardA() { return rowA.getLast(); }
    public Card getRowEndCardB() { return rowB.getLast(); }
    public Card getRowEndCardC() { return rowC.getLast(); }
    public Card getRowEndCardD() { return rowD.getLast(); }

    // Getters and Setters
    public ArrayList<Card> getRowA() {
        return rowA;
    }

    // Set last card
    public void addToRowA(Card card) {
        rowA.add(card);
    }

    public ArrayList<Card> getRowB() {
        return rowB;
    }

    public void addToRowB(Card card) {
        rowB.add(card);
    }

    public ArrayList<Card> getRowC() {
        return rowC;
    }

    public void addToRowC(Card card) {
        rowC.add(card);
    }

    public ArrayList<Card> getRowD() {
        return rowD;
    }

    public void addToRowD(Card card) {
        rowD.add(card);
    }

    // Process played cards;
    public void playedCards(Player player, Card card)
    {
        if (Objects.equals(player.getName(), "-Ultron-"))
        {
            botCard = card;
            botPlayer = player;
        }
        else
        {
            playerCard = card;
            userPlayer = player;
        }
    }

    // Process played cards
    public void placeCardsToRow()
    {
        ArrayList<Card> endCards = new ArrayList<>();
        endCards.add(rowA.getLast());
        endCards.add(rowB.getLast());
        endCards.add(rowC.getLast());
        endCards.add(rowD.getLast());

        var sortedEndCardValues = endCards.stream().map(Card::getValue).sorted().toList();

        // Lowest value of end card in the table
        int lowestValueCard = sortedEndCardValues.getFirst();

        int botCardValue = botCard.getValue();
        int playerCardValue = playerCard.getValue();

        // Lower card value will be put on the table rows first
        if (botCardValue < playerCardValue)
        {
            lowerCard = botCard;
            higherCard = playerCard;
            lowerCardPlayer = botPlayer;
            higherCardPlayer = userPlayer;
        }
        else
        {
            lowerCard = playerCard;
            higherCard = botCard;
            lowerCardPlayer = userPlayer;
            higherCardPlayer = botPlayer;
        }

        // Get total value of each row
        int totalValueRowA = rowA.stream().map(card -> card.getValue()).reduce(0, (temp, value) -> temp + value);
        int totalValueRowB = rowB.stream().map(card -> card.getValue()).reduce(0, (temp, value) -> temp + value);
        int totalValueRowC = rowC.stream().map(card -> card.getValue()).reduce(0, (temp, value) -> temp + value);
        int totalValueRowD = rowD.stream().map(card -> card.getValue()).reduce(0, (temp, value) -> temp + value);

        // Put played cards in an arraylist
        ArrayList<Card> playedCards = new ArrayList<>();
        playedCards.add(lowerCard);
        playedCards.add(higherCard);

        for (Card card : playedCards)
        {
        // if player card is lower than all lastElement() cards, player will get row with least penalty points
            if (card.getValue() < lowestValueCard)
            {
                ArrayList<Card> leastPenaltyRow = rowA;
                int leastPenaltyValue = totalValueRowA;
                String row = "A";

                // LOOK FOR ROW WITH LEAST PENALTY
                if (totalValueRowB < leastPenaltyValue)
                {
                    leastPenaltyRow = rowB;
                    row = "B";
                }
                if (totalValueRowC < leastPenaltyValue)
                {
                    leastPenaltyRow = rowC;
                    row = "C";
                }
                if (totalValueRowD < leastPenaltyValue)
                {
                    leastPenaltyRow = rowD;
                    row = "D";
                }

                // get player that will receive penalty
                // give all cards in selected row to Penalty
                // use player card to restart the row

                if (card == lowerCard)
                {
                    givePenaltyToPlayer(lowerCardPlayer, leastPenaltyRow);
                    displayPenaltyCardsTaken(lowerCardPlayer, row);
                }
                else
                {
                    givePenaltyToPlayer(higherCardPlayer, leastPenaltyRow);
                    displayPenaltyCardsTaken(higherCardPlayer, row);
                }

                // reset row
                leastPenaltyRow.clear();

                // add to row
                leastPenaltyRow.add(card);

                // Update lowest value:
                lowestValueCard = card.getValue();
            }
            else // place card on the correct row
            {
                ArrayList<Card> correctRow = rowD;
                String row = "D";

                // get the difference (lowerCard.getValue() minus each end card value)
                int differenceRowA = card.getValue() - rowA.getLast().getValue();
                int differenceRowB = card.getValue() - rowB.getLast().getValue();
                int differenceRowC = card.getValue() - rowC.getLast().getValue();
                int differenceRowD = card.getValue() - rowD.getLast().getValue();

                int lowestDifference = 300;

                // FIND CORRECT ROW
                if (differenceRowA < lowestDifference && differenceRowA > 0)
                {
                    correctRow = rowA;
                    row = "A";
                    lowestDifference = differenceRowA;
                }
                if (differenceRowB < lowestDifference && differenceRowB > 0)
                {
                    correctRow = rowB;
                    row = "B";
                    lowestDifference = differenceRowB;
                }
                if (differenceRowC < lowestDifference && differenceRowC > 0)
                {
                    correctRow = rowC;
                    row = "C";
                    lowestDifference = differenceRowC;
                }
                if (differenceRowD < lowestDifference && differenceRowD > 0)
                {
                    correctRow = rowD;
                    row = "D";
                    lowestDifference = differenceRowD;
                }

                // if correctRow already have 5 cards, player gets penalty cards
                if (correctRow.size() == 5)
                {
                    // move cards to player penalty
                    // find the player who played the card
                    // Get card value and match to player
                    if (card == lowerCard)
                    {
                        lowerCardPlayer.getPenaltyCards(correctRow);
                        displayPenaltyCardsTaken(lowerCardPlayer, row);
                    }
                    else
                    {
                        higherCardPlayer.getPenaltyCards(correctRow);
                        displayPenaltyCardsTaken(higherCardPlayer, row);
                    }

                    // reset row
                    correctRow.clear();

                    // add to row
                    correctRow.add(card);
                }
                else // else, card is added on the row
                {
                    if (card == lowerCard)
                    {
                        correctRow.add(card);
                        displayCardPlacedToRow(lowerCardPlayer, card, row);
                    }
                    else
                    {
                        correctRow.add(card);
                        displayCardPlacedToRow(higherCardPlayer, card, row);
                    }
                }
            }
        }
    }

    // Get row count A-D
    public int getRowSizeA() { return rowA.size(); }
    public int getRowSizeB() { return rowB.size(); }
    public int getRowSizeC() { return rowC.size(); }
    public int getRowSizeD() { return rowD.size(); }

    // Remove all cards each row A-D
    public void resetRowA() { rowA.clear(); }
    public void resetRowB() { rowA.clear(); }
    public void resetRowC() { rowA.clear(); }
    public void resetRowD() { rowA.clear(); }

    // PENALTY
    // add penalty card to player
    public ArrayList<Card> givePenaltyToPlayer(Player player, ArrayList<Card> cards)
    {
        player.getPenaltyCards(cards);
        return cards;
    }
}
