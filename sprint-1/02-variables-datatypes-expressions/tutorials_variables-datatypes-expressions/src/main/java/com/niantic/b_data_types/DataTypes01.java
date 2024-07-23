package com.niantic.b_data_types;

public class DataTypes01
{

    public static void main(String[] args)
    {
        byte tinyNumber = 1;
        System.out.println(tinyNumber);

        short smallNumber = 30000;
        System.out.println(smallNumber);
        System.out.println();

        // each numeric data type knows what it's min and max values are
        System.out.println(Byte.MIN_VALUE + " - " + Byte.MAX_VALUE);
        System.out.println(Short.MIN_VALUE + " - " + Short.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE + " - " + Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE + " - " + Long.MAX_VALUE);
    }

}
