package com.niantic;

import java.util.Scanner;

public class StringToLowerCase
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine().strip();
        String lowerCaseInput = input.toLowerCase();

        System.out.println("Lowercase version: " + lowerCaseInput);

    }
}
