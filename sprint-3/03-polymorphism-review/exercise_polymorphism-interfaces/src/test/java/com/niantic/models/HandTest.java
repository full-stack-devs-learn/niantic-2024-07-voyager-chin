package com.niantic.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest
{
    
    @Test
    public void dealTo_should_shouldSortCards()
    {
        // arrange
        Card card1 = new Card("Diamonds", "8");
        Card card2 = new Card("Spades", "9");
        Hand hand = new Hand();

        // act
        hand.dealTo(card1);
        hand.dealTo(card2);

        // assert
        assertEquals("Spades", hand.getCards().getFirst().getSuit(), "Because when a new card is dealt the cards in the hand should be sorted");
    }

}