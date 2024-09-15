package com.niantic.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest
{

    @Test
    public void compareTo_should_compareCardSuits()
    {
        // arrange
        Card card1 = new Card("Diamonds", "8");
        Card card2 = new Card("Spades", "9");
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        // act
        Collections.sort(cards);

        // assert
        assertEquals("Spades", cards.getFirst().getSuit(), "Because cards should be sorted by suit first");
    }

    @Test
    public void compareTo_should_compareCardValues()
    {
        // arrange
        Card card1 = new Card("Spades", "8");
        Card card2 = new Card("Spades", "2");
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        // act
        Collections.sort(cards);

        // assert
        assertEquals("2", cards.getFirst().getFaceValue(), "Because cards should be sorted by value if the suit is the same");
    }

    @Test
    public void compareTo_should_compareCardFaceValues()
    {
        // arrange
        Card card1 = new Card("Spades", "K");
        Card card2 = new Card("Spades", "Q");
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);

        // act
        Collections.sort(cards);

        // assert
        assertEquals("Q", cards.getFirst().getFaceValue(), "Because card face values should be sorted");
    }



}