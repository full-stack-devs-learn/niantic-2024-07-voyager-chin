package com.niantic;

public class StringSubstringIndexOf
{
    public static void main(String[] args)
    {
        String fullName = "John Doe";
        int endPosition = fullName.indexOf(' ');

        String firstName = fullName.substring(0, endPosition);
        System.out.println("First name: " + firstName);

    }
}
