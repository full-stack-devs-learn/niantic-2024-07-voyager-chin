package com.niantic;

public class Conditions
{
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;

    public static void main(String[] args)
    {

        int today = THURSDAY;
        String diner = whereToEat(today);

        System.out.println(diner);
    }

    public static String whereToEat(int dayOfWeek)
    {
        String placeToEat;
        switch (dayOfWeek)
        {
            case SUNDAY:
                placeToEat = "Home";
                break;
            case MONDAY:
                placeToEat = "Wendy's";
                break;
            default:
                placeToEat = "Invalid day - you will NOT eat";

        }

        return placeToEat;
    }
}
