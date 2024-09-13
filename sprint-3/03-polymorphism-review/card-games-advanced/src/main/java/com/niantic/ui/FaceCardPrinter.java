package com.niantic.ui;

import com.niantic.models.cards.facecards.FaceCard;
import com.niantic.models.cards.facecards.constants.Suits;
import com.niantic.ui.constants.ColorCodes;
import com.niantic.ui.constants.Symbols;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FaceCardPrinter
{

    private static void printCard(String topEdge, String top, String middle, String suit, String bottom, String bottomEdge)
    {
        System.out.println(topEdge);
        System.out.println(top);
        System.out.println(middle);
        System.out.println(suit);
        System.out.println(middle);
        System.out.println(bottom);
        System.out.println(bottomEdge);
    }

    public static void printCards(List<FaceCard> cards)
    {
        Queue<FaceCard> queue = new LinkedList<>(cards);

        System.out.println();
        while(!queue.isEmpty())
        {
            if(queue.size() >= 5)
            {
                FaceCard card1 = queue.remove();
                FaceCard card2 = queue.remove();
                FaceCard card3 = queue.remove();
                FaceCard card4 = queue.remove();
                FaceCard card5 = queue.remove();
                printCards(card1, card2, card3, card4, card5);
            }
            else if(queue.size() == 4)
            {
                FaceCard card1 = queue.remove();
                FaceCard card2 = queue.remove();
                FaceCard card3 = queue.remove();
                FaceCard card4 = queue.remove();
                printCards(card1, card2, card3, card4);
            }
            else if(queue.size() == 3)
            {
                FaceCard card1 = queue.remove();
                FaceCard card2 = queue.remove();
                FaceCard card3 = queue.remove();
                printCards(card1, card2, card3);
            }
            else if(queue.size() == 2)
            {
                FaceCard card1 = queue.remove();
                FaceCard card2 = queue.remove();
                printCards(card1, card2);
            }
            else
            {
                FaceCard card = queue.remove();
                printCards(card);
            }
            System.out.println();
        }
    }

    public static void printCards(FaceCard card)
    {
        if(!card.isFaceUp())
        {
            printCardBack();
            return;
        }

        CardTemplate ct = new CardTemplate(card);

        printCard(ct.cardTopEdge, ct.cardTop, ct.cardMiddle, ct.cardSuit, ct.cardBottom, ct.cardBottomEdge);

    }

    public static void printCards(FaceCard card1, FaceCard card2)
    {
        if(!card1.isFaceUp() || !card2.isFaceUp())
        {
            print2CardsBack();
            return;
        }

        CardTemplate ct1 = new CardTemplate(card1);
        CardTemplate ct2 = new CardTemplate(card2);

        String topEdge = String.format("%s  %s",ct1.cardTopEdge, ct2.cardTopEdge);
        String top = String.format("%s  %s",ct1.cardTop, ct2.cardTop);
        String middle = String.format("%s  %s",ct1.cardMiddle, ct2.cardMiddle);
        String suit = String.format("%s  %s",ct1.cardSuit, ct2.cardSuit);
        String bottom = String.format("%s  %s",ct1.cardBottom, ct2.cardBottom);
        String bottomEdge = String.format("%s  %s",ct1.cardBottomEdge, ct2.cardBottomEdge);

        printCard(topEdge, top, middle, suit, bottom, bottomEdge);
    }

    public static void printCards(FaceCard card1, FaceCard card2, FaceCard card3)
    {
        if(!card1.isFaceUp() || !card2.isFaceUp() || !card3.isFaceUp())
        {
            print3CardsBack();
            return;
        }

        CardTemplate ct1 = new CardTemplate(card1);
        CardTemplate ct2 = new CardTemplate(card2);
        CardTemplate ct3 = new CardTemplate(card3);

        String topEdge = String.format("%s  %s  %s",ct1.cardTopEdge, ct2.cardTopEdge, ct3.cardTopEdge);
        String top = String.format("%s  %s  %s",ct1.cardTop, ct2.cardTop, ct3.cardTop);
        String middle = String.format("%s  %s  %s",ct1.cardMiddle, ct2.cardMiddle, ct3.cardMiddle);
        String suit = String.format("%s  %s  %s",ct1.cardSuit, ct2.cardSuit, ct3.cardSuit);
        String bottom = String.format("%s  %s  %s",ct1.cardBottom, ct2.cardBottom, ct3.cardBottom);
        String bottomEdge = String.format("%s  %s  %s",ct1.cardBottomEdge, ct2.cardBottomEdge, ct3.cardBottomEdge);

        printCard(topEdge, top, middle, suit, bottom, bottomEdge);
    }

    public static void printCards(FaceCard card1, FaceCard card2, FaceCard card3, FaceCard card4)
    {
        if(!card1.isFaceUp() || !card2.isFaceUp() || !card3.isFaceUp() || !card4.isFaceUp())
        {
            print4CardsBack();
            return;
        }

        CardTemplate ct1 = new CardTemplate(card1);
        CardTemplate ct2 = new CardTemplate(card2);
        CardTemplate ct3 = new CardTemplate(card3);
        CardTemplate ct4 = new CardTemplate(card4);

        String topEdge = String.format("%s  %s  %s  %s",ct1.cardTopEdge, ct2.cardTopEdge, ct3.cardTopEdge, ct4.cardTopEdge);
        String top = String.format("%s  %s  %s  %s",ct1.cardTop, ct2.cardTop, ct3.cardTop, ct4.cardTop);
        String middle = String.format("%s  %s  %s  %s",ct1.cardMiddle, ct2.cardMiddle, ct3.cardMiddle, ct4.cardMiddle);
        String suit = String.format("%s  %s  %s  %s",ct1.cardSuit, ct2.cardSuit, ct3.cardSuit, ct4.cardSuit);
        String bottom = String.format("%s  %s  %s  %s",ct1.cardBottom, ct2.cardBottom, ct3.cardBottom, ct4.cardBottom);
        String bottomEdge = String.format("%s  %s  %s  %s",ct1.cardBottomEdge, ct2.cardBottomEdge, ct3.cardBottomEdge, ct4.cardBottomEdge);

        printCard(topEdge, top, middle, suit, bottom, bottomEdge);
    }

    public static void printCards(FaceCard card1, FaceCard card2, FaceCard card3, FaceCard card4, FaceCard card5)
    {
        if(!card1.isFaceUp() || !card2.isFaceUp() || !card3.isFaceUp() || !card4.isFaceUp() || !card5.isFaceUp())
        {
            print5CardsBack();
            return;
        }

        CardTemplate ct1 = new CardTemplate(card1);
        CardTemplate ct2 = new CardTemplate(card2);
        CardTemplate ct3 = new CardTemplate(card3);
        CardTemplate ct4 = new CardTemplate(card4);
        CardTemplate ct5 = new CardTemplate(card5);

        String topEdge = String.format("%s  %s  %s  %s  %s",ct1.cardTopEdge, ct2.cardTopEdge, ct3.cardTopEdge, ct4.cardTopEdge, ct5.cardTopEdge);
        String top = String.format("%s  %s  %s  %s  %s",ct1.cardTop, ct2.cardTop, ct3.cardTop, ct4.cardTop, ct5.cardTop);
        String middle = String.format("%s  %s  %s  %s  %s",ct1.cardMiddle, ct2.cardMiddle, ct3.cardMiddle, ct4.cardMiddle, ct5.cardMiddle);
        String suit = String.format("%s  %s  %s  %s  %s",ct1.cardSuit, ct2.cardSuit, ct3.cardSuit, ct4.cardSuit, ct5.cardSuit);
        String bottom = String.format("%s  %s  %s  %s  %s",ct1.cardBottom, ct2.cardBottom, ct3.cardBottom, ct4.cardBottom, ct5.cardBottom);
        String bottomEdge = String.format("%s  %s  %s  %s  %s",ct1.cardBottomEdge, ct2.cardBottomEdge, ct3.cardBottomEdge, ct4.cardBottomEdge, ct5.cardBottomEdge);

        printCard(topEdge, top, middle, suit, bottom, bottomEdge);
    }


    private static void printCardBack()
    {
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET);
    }

    private static void print2CardsBack()
    {
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET);
    }

    private static void print3CardsBack()
    {
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET);
    }

    private static void print4CardsBack()
    {
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET);
    }

    private static void print5CardsBack()
    {
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "┌───────┐" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "│·······│" + ColorCodes.RESET);
        System.out.println(ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET + "  " + ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK + "└───────┘" + ColorCodes.RESET);
    }

    // region helpers

    private static String getTopValue(FaceCard card)
    {
        String value = card.getFaceValue();
        int length = value.length();

        return length == 1
                ? value + " "
                : value;
    }

    private static String getBottomValue(FaceCard card)
    {
        String value = card.getFaceValue();
        int length = value.length();

        return length == 1
                ? " " + value
                : value;
    }

    private static String getSymbol(FaceCard card)
    {
        switch (card.getSuit())
        {
            case Suits.SPADES:
                return Symbols.SPADES;
            case Suits.CLUBS:
                return Symbols.CLUBS;
            case Suits.HEARTS:
                return Symbols.HEARTS;
            default:
                return Symbols.DIAMONDS;
        }
    }

    private static String getColor(FaceCard card)
    {
        if(card.getSuit().equals(Suits.HEARTS) || card.getSuit().equals(Suits.DIAMONDS))
        {
            return ColorCodes.WHITE_BACKGROUND + ColorCodes.RED;
        }

        return ColorCodes.WHITE_BACKGROUND + ColorCodes.BLACK;
    }

    // endregion

    private static class CardTemplate
    {
        public final String cardTopEdge;
        public final String cardTop;
        public final String cardMiddle;
        public final String cardSuit;
        public final String cardBottom;
        public final String cardBottomEdge;

        private FaceCard card;

        public CardTemplate(FaceCard card)
        {
            this.card = card;

            String top = getTopValue(card);
            String bottom = getBottomValue(card);
            String suit = getSymbol(card);
            String color = getColor(card);

            String cardTopEdgeTemplate      = "%s┌───────┐%s";
            String cardTopTemplate          = "%s│ %s    │%s";
            String cardMiddleTemplate       = "%s│       │%s";
            String cardSuitTemplate         = "%s│   %s   │%s";
            String cardBottomTemplate       = "%s│    %s │%s";
            String cardBottomEdgeTemplate   = "%s└───────┘%s";

            this.cardTopEdge = String.format(cardTopEdgeTemplate, color, ColorCodes.RESET);
            this.cardTop = String.format(cardTopTemplate, color, top, ColorCodes.RESET);
            this.cardMiddle = String.format(cardMiddleTemplate, color, ColorCodes.RESET);
            this.cardSuit = String.format(cardSuitTemplate, color, suit, ColorCodes.RESET);
            this.cardBottom = String.format(cardBottomTemplate, color, bottom, ColorCodes.RESET);
            this.cardBottomEdge = String.format(cardBottomEdgeTemplate, color, ColorCodes.RESET);
        }
    }
}
