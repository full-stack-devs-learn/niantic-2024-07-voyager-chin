package com.niantic;

import java.util.Scanner;

public class ForLoops
{
    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        int counter = 0;

        while(counter < 3)
        {
            System.out.println(counter);

            counter++;
        }
        System.out.println();

        for(int i = 0;  i < 3; i++)
        {
            System.out.println("i: " + i);
        }

    }
}
