package com.niantic;

public class ForEachLoops
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

        printNames(names);

    }

    public static void printNames(String[] names)
    {
        for(int i = 0; i < names.length; i++)
        {
            String name = names[i];
            System.out.println(name);
        }

        for(String name : names)
        {
            System.out.println(name);
        }
    }

}
