package com.niantic;

public class StringLastIndexOf
{
    public static void main(String[] args)
    {
        String fileName = "example.file.name.jpg";
        int lastDotIndex = fileName.lastIndexOf('.');

        System.out.println("The last dot is at index: " + lastDotIndex);
        boolean isTextFile = fileName.endsWith(".txt");
        System.out.println("File is text: " + isTextFile);

    }
}
