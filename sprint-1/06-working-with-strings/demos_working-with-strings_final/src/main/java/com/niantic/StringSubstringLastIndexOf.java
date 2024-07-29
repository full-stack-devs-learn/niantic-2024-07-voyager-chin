package com.niantic;

public class StringSubstringLastIndexOf
{
    public static void main(String[] args)
    {
        String fileName = "example.file.name.txt";
        int position = fileName.lastIndexOf('.');

        String fileExtension = fileName.substring(position + 1);

        System.out.println("File extension: " + fileExtension);

    }
}
