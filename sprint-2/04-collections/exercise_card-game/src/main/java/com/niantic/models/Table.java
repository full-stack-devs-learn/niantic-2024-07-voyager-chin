package com.niantic.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Table
{
    // Table can get initial cards and display it
    // Organize 4 rows
    // Can collect play cards and put in rows
    // Can reset rows
    // Can convert cards values to penalty points

    private Penalty penalty;


    // 4 Rows of Cards in Table
    ArrayList<Card> rowA = new ArrayList<>();
    ArrayList<Card> rowB = new ArrayList<>();
    ArrayList<Card> rowC = new ArrayList<>();
    ArrayList<Card> rowD = new ArrayList<>();

    // Played Cards per turn
    Card botCard;
    Card playerCard;

    // Parameterless
    public Table() {
    }

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
    public Card getRowEndCardD() { return rowA.getLast(); }

//    public ArrayList<Card> getEndCards(){
//
//        ArrayList<Card> endCards = new ArrayList<Card>();
//
//        var cardRowA = rowA.get(rowA.size() - 1);
//        endCards.add(cardRowA);
//
//        var cardRowB = rowB.get(rowB.size() - 1);
//        endCards.add(cardRowB);
//
//        var cardRowC = rowC.get(rowC.size() - 1);
//        endCards.add(cardRowC);
//
//        var cardRowD = rowD.get(rowD.size() - 1);
//        endCards.add(cardRowD);
//
//        return endCards;
//    }

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

    }


    // Get row count A-D
    public int getRowSizeA() { return rowA.size(); }

    public int getRowSizeB() { return rowB.size(); }

    public int getRowSizeC() { return rowC.size(); }

    public int getRowSizeD() { return rowD.size(); }

    // Add single card to rows A-D
    // Each turn will add each player card to the rows, lowest card value will be added first

    // Removed cards need to be added to Penalty model


    // Remove all cards each row A-D
    public void resetRowA() { rowA.clear(); }
    public void resetRowB() { rowA.clear(); }
    public void resetRowC() { rowA.clear(); }
    public void resetRowD() { rowA.clear(); }

    // PENALTY
    // add penalty card to player
    public ArrayList<Card> givePenaltyToPlayer(ArrayList<Card> cards)
    {
        penalty.getPenaltyCards(cards);
        return cards;
    }


}
