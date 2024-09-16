package com.niantic;

import java.io.File;
import java.util.Scanner;

public class ExceptionsDemo
{
    public static void main(String[] args)
    {
        File file = new File("numbers.txt");
        Scanner reader = null;

        try
        {
            // 1. open the file stream
            reader = new Scanner(file);

            // 2. loop through the stream
            int count = 0;
            while(reader.hasNextLine())
            {
                count++;

                int line = Integer.parseInt(reader.nextLine());
                System.out.println(line);

            }

            // 3. close the stream
            reader.close();
        }
        catch (Exception e)
        {
            // log error message
            System.out.println(e.getMessage());
        }
        finally
        {
            if(reader != null)
            {
                reader.close();
            }
        }
    }
}
