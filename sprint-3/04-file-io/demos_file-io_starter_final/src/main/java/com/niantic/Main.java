package com.niantic;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String[] words = "this is a TEST".split(" ");

        try
        {
            System.out.println(words[4]);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        File file = new File("word.txt");

        try
        {
            Scanner reader = new Scanner(file);
            int i = reader.nextInt();
        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("File Not Found Exception");
//            System.out.println(e.getMessage());
//        }
        catch (Exception e)
        {
            System.out.println("General Exception");
            System.out.println(e.getMessage());
        }
    }
}