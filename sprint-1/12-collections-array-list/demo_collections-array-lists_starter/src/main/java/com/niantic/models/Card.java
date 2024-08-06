package com.niantic.models;

public class Card
{
    private final String suit;
    private final String faceValue;

    // constructor
    public Card(String suit, String faceValue)
    {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    // getters
    public String getSuit()
    {
        return suit;
    }

    public String getFaceValue()
    {
        return faceValue;
    }

    // derived getters
    public int getPointValue()
    {
        switch(faceValue.toUpperCase())
        {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(faceValue);
        }
    }

    public String getColor()
    {
        switch(suit.toLowerCase())
        {
            case "diamonds":
            case "hearts":
                return "red";
            default:
                return "black";
        }
    }
}
