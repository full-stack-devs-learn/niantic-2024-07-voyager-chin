package com.niantic.models.hands;

import com.niantic.models.cards.Card;
import com.niantic.models.cards.facecards.cards.Ace;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackHand extends FaceCardHand
{
    public boolean isBust()
    {
        return getValue() > 21;
    }

    private List<Card> getBigAces()
    {
        return getCards().stream().filter(card -> card instanceof Ace && card.getValue() == 11).collect(Collectors.toList());
    }

    private boolean hasBigAce()
    {
        return !getBigAces().isEmpty();
    }

    @Override
    public int getValue()
    {
        while (super.getValue() > 21 && hasBigAce())
        {
            Ace ace = (Ace)getBigAces().get(0);
            ace.toggleValue();
        }

        return super.getValue();
    }
}
