package com.niantic;

import java.io.File;
import java.util.Scanner;

public class ExceptionsDemoNew
{
    public static void main(String[] args)
    {
        File file = new File("numbers.txt");

        // 1. open the file stream
        try( Scanner reader = new Scanner(file) )
        {
            // 2. loop through the stream
            int count = 0;
            while(reader.hasNextLine())
            {
                count++;

                int line = Integer.parseInt(reader.nextLine());
                System.out.println(line);
            }
        }
        catch (Exception e)
        {
            // log error message
            System.out.println(e.getMessage());
        }
    }
}
