package com.niantic.application;

import com.niantic.models.Transaction;
import com.niantic.services.TransactionDao;

import java.util.Scanner;

//import static java.util.FormatProcessor.FMT;

//import static java.lang.StringTemplate.STR;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);

    TransactionDao transactionDao = new TransactionDao();
    //Add more DAOs here

    // <editor-fold desc="Home Page - BudgetTracker Application">
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
                    displayReports();
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

    // </editor-fold>

    // <editor-fold desc="Reports">
    private void displayReports()
    {
        while(true)
        {
            int choice = reportsSelection();
            switch(choice)
            {
                case 1:
                    transactionsByUser();
                    break;
                case 2:
                    transactionsByMonth();
                    break;
                case 3:
                    transactionsByYear();
                    break;
                case 4:
                    transactionsBySubCategory();
                    break;
                case 5:
                    transactionsByCategory();
                    break;
                case 0:
                    // go back to home screen
                    return;
                default:
                    System.out.println("That was an invalid selection, please select from the available options.");
            }
        }
    }

    private int reportsSelection()
    {
        System.out.println();
        System.out.println("Reports");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Transactions By User");
        System.out.println("  2) Transactions By Month");
        System.out.println("  3) Transactions By Year");
        System.out.println("  4) Transactions By Sub Category");
        System.out.println("  5) Transactions By Category");
        System.out.println("  0) Back");
        System.out.println();

        System.out.println("Enter your selection: ");
        return Integer.parseInt(userInput.nextLine());
    }

    private void transactionsByUser()
    {

        System.out.println();
        System.out.println("Transactions By User");
        System.out.println("-".repeat(100));
        int userId = getUserInt("Enter user id: ");
        System.out.println();

        var transactions = transactionDao.getTransactionByUser(userId);

        System.out.print("Transactions for User ID: ");
        System.out.print(userId);
        System.out.println(" transaction_id | transaction_date | amount | notes ");
        System.out.println("---------------------------------------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getTransactionId());
            System.out.print(" | ");
            System.out.print(transaction.getTransactionDate());
            System.out.print(" | ");
            System.out.print(transaction.getAmount());
            System.out.print(" | ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsByMonth()
    {

        System.out.println();
        System.out.println("Transactions By Month");
        System.out.println("-".repeat(100));
        String month = getUserString("Enter month (Format: MM) : ");
        System.out.println();

        var transactions = transactionDao.getTransactionByMonth(month);

        System.out.print("Transactions for Month: ");
        System.out.print(month);
        System.out.println(" user_id | transaction_date | amount | notes ");
        System.out.println("---------------------------------------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getUserId());
            System.out.print(" | ");
            System.out.print(transaction.getTransactionDate());
            System.out.print(" | ");
            System.out.print(transaction.getAmount());
            System.out.print(" | ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsByYear()
    {

        System.out.println();
        System.out.println("Transactions By Year");
        System.out.println("-".repeat(100));
        int year = getUserInt("Enter year (Format: YYYY) : ");
        System.out.println();

        var transactions = transactionDao.getTransactionByYear(year);

        System.out.print("Transactions for Year: ");
        System.out.print(year);
        System.out.println(" user_id | transaction_date | amount | notes ");
        System.out.println("---------------------------------------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getUserId());
            System.out.print(" | ");
            System.out.print(transaction.getTransactionDate());
            System.out.print(" | ");
            System.out.print(transaction.getAmount());
            System.out.print(" | ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsBySubCategory()
    {

        System.out.println();
        System.out.println("Transactions By Sub Category");
        System.out.println("-".repeat(100));
        int subCategoryId = getUserInt("Enter sub category id: ");
        System.out.println();

        var transactions = transactionDao.getTransactionBySubCategory(subCategoryId);

        System.out.print("Transactions for Sub Category ID: ");
        System.out.print(subCategoryId);
        System.out.println(" user_id | transaction_date | amount | notes ");
        System.out.println("---------------------------------------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getUserId());
            System.out.print(" | ");
            System.out.print(transaction.getTransactionDate());
            System.out.print(" | ");
            System.out.print(transaction.getAmount());
            System.out.print(" | ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsByCategory()
    {

        System.out.println();
        System.out.println("Transactions By Category");
        System.out.println("-".repeat(100));
        int categoryId = getUserInt("Enter category id: ");
        System.out.println();

        var transactions = transactionDao.getTransactionByCategory(categoryId);

        System.out.print("Transactions for Category ID: ");
        System.out.print(categoryId);
        System.out.println(" user_id | transaction_date | sub_category_id | amount | notes ");
        System.out.println("---------------------------------------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getUserId());
            System.out.print(" | ");
            System.out.print(transaction.getTransactionDate());
            System.out.print(" | ");
            System.out.print(transaction.getSubCategoryId());
            System.out.print(" | ");
            System.out.print(transaction.getAmount());
            System.out.print(" | ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    // </editor-fold>

    // <editor-fold desc="Add User">


    // </editor-fold>

    // <editor-fold desc="Helpers">

    private void waitForUser()
    {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        userInput.nextLine();
    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine();
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    private double getUserDouble(String message)
    {
        return Double.parseDouble(getUserString(message));
    }

    // </editor-fold>
}
