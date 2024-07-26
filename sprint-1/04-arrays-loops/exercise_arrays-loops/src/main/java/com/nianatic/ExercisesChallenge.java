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
     * sumFirst2Numbers([1, 2, 3])       =>  3
     * sumFirst2Numbers([10, 8, 14, 32]) =>  18
     * sumFirst2Numbers([3])             =>  3
     * sumFirst2Numbers([])              =>  0
     */
    public int sumFirst2Numbers(int[] numbers)
    {
        //Create variable to store sum of 2 numbers
        int sumOf2 = 0;

        if (numbers.length == 0)
        {
            //Do nothing because there are no integers to add
        }
        else if (numbers.length < 2)
        {
            //If there is only 1 integer, put the value in sumOf2
            sumOf2 = numbers[0];
        }
        else
        {
            //If there are 2 or more initial values in the array, add the first 2 values
            sumOf2 = numbers[0] + numbers[1];
        }

        //Return the sum of the first 2 values
        return sumOf2;
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
        //Variable that indicates array length
        int len = names.length;

        //Create an array that will store the reversed order of names
        String [] reversedOrder = new String[len];

        //For loop to assign each name starting from end of names array to an index in the reversedOrder array
        for (int i = 0; i < names.length; i++) {
            len -= 1; //Decrement by 1 to move to the next reversed value
            reversedOrder[i] = names[len];
        }

        //Returns the list of names in reversed order
        return reversedOrder;
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
     *                [1,2,3,4],
     *                [5,6,7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     */
    public int[] combineArrays(int[][] numbers)
    {
        return null;
    }
}
