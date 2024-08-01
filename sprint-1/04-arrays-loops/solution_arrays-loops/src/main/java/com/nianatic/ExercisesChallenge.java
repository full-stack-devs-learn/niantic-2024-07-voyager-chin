package com.nianatic;

public class ExercisesChallenge
{

    /*
     * Given an array of numbers, add only
     * the first 2 numbers and return
     * the answer.
     *
     * The array may have fewer than 2 numbers,
     * so you will need to have logic to deal
     * with that.
     *
     * sumFirst2Numbers([1,2,3])         =>  3
     * sumFirst2Numbers([10, 8, 14, 32]) =>  18
     */
    public int sumFirst2Numbers(int[] numbers)
    {
        if (numbers.length == 0)
        {
            return 0;
        }
        else if (numbers.length == 1)
        {
            return numbers[0];
        }
        else
        {
            return numbers[0] + numbers[1];
        }
    }

    /*
     * Given an array of names, create a
     * new array of the same size. The new
     * array should have all of the names
     * in it but in reverse order.
     *
     * reverseNames(["Ron", "Lisa", "Kent", "Michelle"]) => ["Michelle", "Kent", "Lisa", "Ron"]
     */
    public String[] reverseNames(String[] names)
    {
        String[] newNames = new String[names.length];

        for (int i = names.length - 1, j = 0; i >= 0; i--, j++)
        {
            newNames[j] = names[i];
        }

        return newNames;
    }



    /*
     * Given a multidimensional array of numbers,
     * combine all numbers into a single 1 dimensional array
     *
     * The nested arrays will all have numbers
     * but the amount can vary
     *
     * combineArrays([
     *                [1,2,3],
     *                [4,5,6],
     *                [7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     *
     * combineArrays([
     *                [1,2],
     *                [3,4,5,6],
     *                [7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     *
     * combineArrays([
     *                [1,2,3],
     *                [4,5,6]
     *               ])         =>  [1,2,3,4,5,6]
     */
    public int[] combineArrays(int[][] numbers)
    {
        // calculate the size of the new array
        int numCells = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            numCells += numbers[i].length;
        }

        // create the new array
        int[] newNumbers = new int[numCells];

        // copy all sub-array values into the new array
        int currentPosition = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            System.arraycopy(numbers[i],0, newNumbers, currentPosition, numbers[i].length);
            currentPosition += numbers[i].length;
        }

        return newNumbers;
    }
}
