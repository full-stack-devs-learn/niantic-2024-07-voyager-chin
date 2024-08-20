package com.niantic;

import com.niantic.adventure.Archer;
import com.niantic.adventure.Character;

public class AdventureGame
{
    public static void main(String[] args)
    {
        Archer hero = new Archer("Carla", 50, 1, 100,2);
        Character villain = new Character("Joseph", 50,1,100);

        villain.attack(hero);
        villain.attack(hero);
        villain.attack(hero);
        villain.attack(hero);
        villain.attack(hero);

//        hero.addArrow();
        hero.levelUp();

        hero.attack(villain);


    }
}
