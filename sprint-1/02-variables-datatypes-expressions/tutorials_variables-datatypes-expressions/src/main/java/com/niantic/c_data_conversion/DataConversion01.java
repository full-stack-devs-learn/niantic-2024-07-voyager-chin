package com.niantic.c_data_conversion;

public class DataConversion01
{

    public static void main(String[] args)
    {
        long bigAge = 18;

        // by putting (int) in front of bigAge
        // we are type casting 18 as an int.
        int age = (int) bigAge;

        System.out.println(age);
        System.out.println();

        // Type casting only works if the value inside bigAge
        // is small enough to be treated as an int.

        // For example:
        long manyGallons = 3000000000l;
        // this program will run, but it will give an unexpected result
        // when it gets to this line because an int can only
        // go up tp 2147486647 - since 3 billion is bigger
        int gallons = (int) manyGallons;

        System.out.println(gallons);
        System.out.println();
    }
}
