package com.niantic.models;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>
{
    private String suit;
    private String faceValue;

    public Card(String suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    public int getPointValue()
    {
        return cardValues.get(faceValue);
    }

    public String getColor()
    {
        switch (suit.toLowerCase())
        {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }

    // lookup map
    private static final Map<String, Integer> cardValues = new HashMap<>()
    {{
        put("A", 11);
        put("K", 10);
        put("Q", 10);
        put("J", 10);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

    @Override
    public int compareTo(Card o)
    {
        int otherSuit = getOrder(o.suit);
        int thisSuit= getOrder(this.suit);

        // todo: Exercise 1: implement Comparable<Card>
        if (otherSuit != thisSuit)
        {
            return otherSuit > thisSuit ? -1 : 1;
        }
        else
        {
            try { otherSuit = Integer.parseInt(o.faceValue); }
            catch (NumberFormatException e) { otherSuit = getOrder(o.faceValue); }
            try { thisSuit = Integer.parseInt(this.faceValue); }
            catch (NumberFormatException e) { thisSuit = getOrder(this.faceValue); }

            return otherSuit > thisSuit ? -1 : 1;
        }
    }

    public int getOrder(String suitOrValue)
    {
        switch (suitOrValue)
        {
            case "Spades":
                return 1;
            case "Hearts":
                return 2;
            case "Diamonds":
                return 3;
            case "Clubs":
                return 4;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return 0;
        }
    }
}
