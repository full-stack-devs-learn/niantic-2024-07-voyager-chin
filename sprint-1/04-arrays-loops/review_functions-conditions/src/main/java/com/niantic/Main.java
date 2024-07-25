package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        String name = "Gregor";
        int quantity = 10;
        BackyardBasketball games = new BackyardBasketball();

        games.calculateShotsRequired(70,21,false);
    }
}