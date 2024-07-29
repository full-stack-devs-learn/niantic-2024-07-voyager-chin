package com.niantic;

public class StringIndexOf
{
    public static void main(String[] args)
    {
        String ssn = "123-45-6789";
        int dashIndex = ssn.indexOf('-');

        // the dashIndex is 3
        System.out.println("The first dash is at index: " + dashIndex);
    }
}
