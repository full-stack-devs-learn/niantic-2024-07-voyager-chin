package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        double radius = 13.25;
        // the Math class has ALL static methods
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println(area);
    }
}