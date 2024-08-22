package com.niantic.models;

public class Card
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
        switch (faceValue)
        {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default: // 2 - 10
                return Integer.parseInt(faceValue);
        }
    }

    public String getColor()
    {
        switch(suit.toLowerCase())
        {
            case "hearts":
            case "diamonds":
                return "Red";
            default:
                return "Black";
        }
    }
}
