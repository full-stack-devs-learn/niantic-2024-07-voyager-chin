package com.niantic;

public class LoopingThroughArrays
{
    public static void main(String[] args)
    {
        String[] names = {
                "Emma",
                "Liam",
                "Olivia",
                "Noah",
                "Ava",
                "Ethan",
                "Sophia",
                "James",
                "Isabella",
                "Benjamin"
        };

        printNamesInReverse(names);

    }

    public static void printNames(String[] names)
    {
        for(int i = 0; i < names.length; i++)
        {
            String name = names[i];
            System.out.println(name);
        }
    }

    public static void printEveryOtherName(String[] names)
    {
        for (int i = 0; i < names.length; i+=2)
        {
            String name = names[i];
            System.out.println(i + ": " + name);
        }
    }

    public static void printNamesInReverse(String[] names)
    {
        for(int i = names.length - 1; i >= 0; i--)
        {
            String name = names[i];
            System.out.println(i + ": " + name);
        }
    }
}
