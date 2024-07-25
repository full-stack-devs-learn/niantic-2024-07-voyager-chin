package com.niantic;

public class MultiDimensionalArray
{
    public static void main(String[] args)
    {
        int[][] numbers = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        // outer loop
        for (int i = 0; i < numbers.length; i++)
        {
            int[] row = numbers[i];
            System.out.println("---------");
            System.out.println("row: " + i);
            System.out.println("---------");
            // inner loop
            for (int j = 0; j < row.length; j++)
            {
                System.out.println(row[j]);
            }
        }
    }
}
