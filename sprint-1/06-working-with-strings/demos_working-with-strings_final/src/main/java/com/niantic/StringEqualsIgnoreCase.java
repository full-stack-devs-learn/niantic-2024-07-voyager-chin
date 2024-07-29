package com.niantic;

import java.util.Scanner;

public class StringEqualsIgnoreCase
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        do
        {
            // this block is guaranteed to execute at least once
            System.out.println("Inside the loop.");
            System.out.println("Do you want to go again? (yes/no)");
            input = scanner.nextLine();
        }
        while (input.equalsIgnoreCase("yes"));
        System.out.println("Loop ended.");
    }
}
