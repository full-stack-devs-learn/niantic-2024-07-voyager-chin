package com.niantic;

public class StringSplit
{
    public static void main(String[] args)
    {
        String csvLine = "123|Laptop|Electronics|999.99";
        String[] parts = csvLine.split("\\|");

        // parts[0] = "123"
        // parts[1] = "Laptop"
        // parts[2] = "Electronics"
        // parts[3] = "999.99"
        for (String part : parts)
        {
            System.out.println(part);
        }

    }
}
