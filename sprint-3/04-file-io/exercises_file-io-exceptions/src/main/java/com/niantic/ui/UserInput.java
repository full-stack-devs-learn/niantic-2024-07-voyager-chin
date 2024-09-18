package com.niantic.ui;

import java.util.Scanner;

public class UserInput
{
    protected static Scanner in = new Scanner(System.in);

    public static int homeScreenSelection()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("-".repeat(30));
        System.out.println();
        System.out.println("  1) Display files");
        System.out.println();
        System.out.println("  ------------ Individual File ------------");
        System.out.println("  2) Student: display all scores");
        System.out.println("  3) Student: display average score");
        System.out.println();
        System.out.println("  ---------- Challenge All Files ----------");
        System.out.println("  4) All Students: display average score");
        System.out.println("  5) All Assignments: display average score");
        System.out.println();
        System.out.println("  ---------- Create Report Files ----------");
        System.out.println("  6) Student: Summary Report");
        System.out.println("  7) All Students: Summary Report");
        System.out.println();
        System.out.println("  0) Exit");

        System.out.println();
        System.out.print("Please make a selection: ");

        return checkInput();
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public static int fileSelection()
    {
        System.out.println();
        System.out.print("Please select a file number: ");
        return checkInput();
    }

    public static void waitForUser()
    {
        System.out.println();
        System.out.print("Press ENTER to continue...");
        in.nextLine();
    }

    public static int checkInput()
    {
        int selection = 0;
        boolean isValid = false;

        while (!isValid)
        {
            try
            {
                selection = Integer.parseInt(in.nextLine());
                isValid = true;
            }
            catch (Exception e)
            {
                System.out.println("Sorry, invalid input. Try again.");
                System.out.print("Please make a valid selection: ");
            }
        }
        return selection;
    }
}
