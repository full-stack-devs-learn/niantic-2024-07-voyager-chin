package com.niantic.exercises;

import java.util.ArrayList;

public class ArrayListIntro
{
    /*
    1. Create an ArrayList of Strings and add the names of your
       5 favorite heroes.

    Return the list.
     */

    public ArrayList<String> getHeroesList()
    {
        // Create ArrayList for the heroes
        ArrayList<String> heroes = new ArrayList<>();

        // Add each hero to the ArrayList
        heroes.add("Iron Man");
        heroes.add("Deadpool");
        heroes.add("Doctor Strange");
        heroes.add("Scarlet Witch");
        heroes.add("Spider-Man");

        // Return the added heroes
        return heroes;
    }

    /*
    2. Given a list of integers, create and return a new list of just the
       even numbers in the list

       findEvens( [1, 2, 3, 4] )            ->  [2, 4]
       findEvens( [21, 98, 78, 5, 6, 8] )   ->  [98, 78, 6, 8]
     */

    public ArrayList<Integer> findEvens(ArrayList<Integer> numbers)
    {
        // Create a new ArrayList to collect the even numbers
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        // Loop to check each number if even and add to the new ArrayList of even numbers
        for (int number : numbers)
        {
            if (number % 2 == 0)
            {
                evenNumbers.add(number);
            }
        }

        // Return a new ArrayList of just the even numbers from the original ArrayList
        return evenNumbers;
    }

    /*
    3. Given a list of integers, return the sum of all numbers

       sum( [1, 2, 3, 4] )            ->  10
       sum( [21, 98, 78, 5, 6, 8] )   ->  216
     */
    public int sum(ArrayList<Integer> numbers)
    {
        int sumAll = 0;

        // Loop to add each number to the existing sum
        for (int number : numbers)
        {
            sumAll += number;
        }

        // Return the sum of all numbers in the ArrayList
        return sumAll;
    }

    /*
    4. Given a list of integers, return the highest number

       sum( [1, 2, 3, 4] )            ->  4
       sum( [21, 98, 78, 5, 6, 8] )   ->  98
     */
    public int max(ArrayList<Integer> numbers)
    {
        int highest = 0;

        // Loop through the numbers ArrayList to find the highest number
        for (int number : numbers)
        {
            if (number > highest)
            {
                highest = number;
            }
        }

        // Return the highest number in the ArrayList
        return highest;
    }

    /*
    5. Given a list of integers, return the lowest number

       sum( [1, 2, 3, 4] )            ->  1
       sum( [21, 98, -78, 5, 6, 8] )  ->  -78
     */
    public int min(ArrayList<Integer> numbers)
    {
        int lowest = numbers.get(0);

        // Loop through the numbers ArrayList to find the lowest number
        for (int number : numbers)
        {
            if (number < lowest)
            {
                lowest = number;
            }
        }

        // Return lowest number in the ArrayList
        return lowest;
    }

    /*
    6. Given a list of integers, return the average of all numbers
       This should return the average as an integer, not a floating point

       sum( [3, 1, 59, -4, 81, 23] )    ->  27
       sum( [21, 98, -78, 5, 6, 8] )    ->  53
     */
    public int average(ArrayList<Integer> numbers)
    {
        int sum = 0;

        // Add all numbers in the ArrayList
        for (int number : numbers)
        {
            sum += number;
        }

        // Get the average of the sum
        double averageNum = sum / numbers.size();

        // Return the averageNum converted to int
        return (int) averageNum;
    }

    /*
    7.  Build an arrayList that holds the fibonacci sequence

        The fibonacci sequence is a numeric pattern 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        - each new number is added by calculating the sum of the previous 2 numbers
          0 + 1 = 1
          1 + 1 = 2
          1 + 2 = 3
          2 + 3 = 5
          etc.
        - the sequence must begin with 0, 1 so size will never be lower than 2

        Include as many numbers as is specified by the size input
     */
    public ArrayList<Integer> buildFibonacci(int size)
    {
        // Create ArrayList to store the fibonacci numbers
        ArrayList<Integer> fibonacci = new ArrayList<>();
        // Add the first 2 values of fibonacci
        fibonacci.add(0);
        fibonacci.add(1);

        // Create a loop that will iterate based on the size parameter
        for (int i = 2; i < size; i++) {
            // Add the last 2 numbers of the sequence
            int sum = fibonacci.get(fibonacci.size()-1) + fibonacci.get(fibonacci.size()-2);
            fibonacci.add(sum);
        }

        // Returns fibonacci sequence ArrayList based on size input
        return fibonacci;
    }
}
