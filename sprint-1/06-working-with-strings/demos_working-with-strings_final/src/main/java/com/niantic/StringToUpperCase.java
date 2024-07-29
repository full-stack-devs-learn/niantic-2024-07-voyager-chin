package com.niantic;

import java.util.Scanner;

public class StringToUpperCase
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        String upperCaseInput = input.toUpperCase();

        System.out.println("Uppercase version: " + upperCaseInput);

    }
}
