package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        Drivable mower = new RidingMower("Cub Cadet", "64", 500);
        mower.turnOn();
    }
}