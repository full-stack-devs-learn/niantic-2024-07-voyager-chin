package com.niantic;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String[] creditCards = createCCList();
        displayOptions(creditCards);

        System.out.println();
        String[] team = getTeamMembers();
        displayOptions(team);
    }

    public static String[] createCCList()
    {
        String[] creditCardTypes = {"VISA", "MASTERCARD","AMERICAN EXPRESS", "DISCOVER"};
        return creditCardTypes;
    }

    public static String[] getTeamMembers()
    {
        Scanner userInput = new Scanner(System.in);
        String[] teamMembers;

        System.out.print("How big is this team? ");
        int size = userInput.nextInt();
        userInput.nextLine();

        teamMembers = new String[size];

        for (int i = 0; i < size; i++)
        {
            System.out.print("Please enter name " + (i + 1) + ": ");
            teamMembers[i] = userInput.nextLine();
        }

        return teamMembers;
    }

    public static void displayOptions(String[] options)
    {
        for(String option : options)
        {
            System.out.println(option);
        }
    }

}