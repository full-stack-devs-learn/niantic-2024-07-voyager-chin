package com.niantic.demos;

import java.io.*;
import java.util.Scanner;

public class FileIODemos
{
    public static void main(String[] args)
    {
//        readingDemo();
        writingDemo();
    }
    private static void ensureDirectoryExists(String path)
    {
        File dir = new File(path);
        if(!dir.exists())
        {
            dir.mkdir();
        }
    }

    private static void writingDemo()
    {
        ensureDirectoryExists("reports");

        String newFileName = "reports/demo.txt";
        File file = new File(newFileName);

        try(
                FileOutputStream stream = new FileOutputStream(file, true);
                PrintWriter writer = new PrintWriter(stream))
        {
            writer.println("This");
            writer.println("is");
            writer.println("a");
            writer.println("test");
            System.out.println("File was created");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void readingDemo()
    {
        String fileName = "files/students_period_1.csv";
        File file = new File(fileName);

        try(
                Scanner reader = new Scanner(file);
                )
        {

            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                System.out.println(line);
            }
        }
        catch(IOException e)
        {

        }

    }
}
