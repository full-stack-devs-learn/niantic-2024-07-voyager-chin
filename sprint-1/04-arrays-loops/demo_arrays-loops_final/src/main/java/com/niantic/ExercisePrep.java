package com.niantic;

public class ExercisePrep
{
    public static void main(String[] args)
    {
        int[] numbers = {1,2,3,4,5};
        int total = sumEvens(numbers);
        System.out.println(total);
    }

    public static int sum(int[] numbers)
    {
        // declare the aggregator
        int sum = 0;

        // perform the calculation
//        for(int number : numbers)
//        {
//            sum += number;
//        }
        for (int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
        }

        // return the answer
        return sum;
    }

    public static int sumEvens(int[] numbers)
    {
        // declare the aggregator
        int sum = 0;

        // perform the calculation
        for(int number : numbers)
        {
            if(number % 2 == 0)
            {
                sum += number;
            }
        }

        // return the answer
        return sum;
    }
}
