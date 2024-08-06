package com.niantic.arraylists;

import com.niantic.models.Card;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemos
{
    public static void main(String[] args)
    {
        cardDemos();
    }

    public static void cardDemos()
    {
        ArrayList<Card> cards;

        cards = new ArrayList<Card>();

        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for(var suit: suits)
        {
            for(var face: faces)
            {
                cards.add(new Card(suit, face));
            }
        }


        //Collections.shuffle(cards);

        Card firstCard = cards.removeFirst();


        for(Card card : cards) {
            System.out.println(card.getFaceValue() + " of " + card.getSuit() + " (" + card.getPointValue() + ")");
        }
    }

    public static void basicArrayList(){
        ArrayList<String> names = new ArrayList<>(100);
        ArrayList<Integer> numbers = new ArrayList<>();

        names.add("Thor");
        names.add("Iron Man");
        names.add(1, "Captain America");

        names.trimToSize();

        for(int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i));
        }

        for(String name : names)
        {
            System.out.println(name);
        }
    }
}
