package com.niantic;

public class StringSubstringIndexOf
{
    public static void main(String[] args)
    {
        String fullName = "John Doe";

        // option 1 - use indexOf to find the ' ' and then use substring to get the parts
//        int endPosition = fullName.indexOf(' ');
//
//        String firstName = fullName.substring(0, endPosition);
//        String lastName = fullName.substring(endPosition + 1);

        // option 2 - use split() to split on the ' ' and create an array of Strings
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println(lastName + ", " + firstName);

    }
}
