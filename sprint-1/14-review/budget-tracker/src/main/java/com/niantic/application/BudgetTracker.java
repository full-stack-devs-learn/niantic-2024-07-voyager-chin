package com.niantic.application;

import java.util.Scanner;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);
    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    System.out.println("add transaction");
                    break;
                case 2:
                    System.out.println("reports");
                    break;
                case 3:
                    System.out.println("add user");
                    break;
                case 4:
                    System.out.println("add category");
                    break;
                case 5:
                    System.out.println("add sub category");
                    break;
                case 6:
                    System.out.println("add vendor");
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Northwind!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                default:
                    System.out.println("invalid selection");
                    break;
            }
        }

    }

    private int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Add Transaction");
        System.out.println("  2) Reports");
        System.out.println("  3) Add User");
        System.out.println("  4) Add Category");
        System.out.println("  5) Add Sub Category");
        System.out.println("  6) Add Vendor");
        System.out.println("  0) Quit");
        System.out.println();

        System.out.print("Enter an option: ");
        return Integer.parseInt(userInput.nextLine());
    }


}
