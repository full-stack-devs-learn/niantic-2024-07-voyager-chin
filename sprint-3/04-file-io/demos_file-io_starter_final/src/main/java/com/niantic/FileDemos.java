package com.niantic;

import java.io.File;
import java.util.stream.Stream;

public class FileDemos
{
    public static void main(String[] args)
    {
        File file = new File("files");
        System.out.println("File exists: " + file.exists());
        System.out.println("Is a file: " + file.isFile());
        System.out.println("Is a directory: " + file.isDirectory());
        System.out.println("Absolute path: " + file.getAbsolutePath());

        if(file.exists() && file.isDirectory())
        {
            String[] fileNames = file.list();
            for(String fileName : fileNames)
            {
                System.out.println(fileName);
            }
        }
    }
}
