package com.niantic;

public class StringLastIndexOf
{
    public static void main(String[] args)
    {
        String fileName = "example.file.name.txt";
        int lastDotIndex = fileName.lastIndexOf('.');

        System.out.println("The last dot is at index: " + lastDotIndex);

    }
}
