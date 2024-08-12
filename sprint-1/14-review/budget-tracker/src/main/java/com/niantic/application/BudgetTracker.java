package com.niantic.application;

import com.niantic.models.*;
import com.niantic.services.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

//import static java.util.FormatProcessor.FMT;

//import static java.lang.StringTemplate.STR;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);

    TransactionDao transactionDao = new TransactionDao();
    UserDao userDao = new UserDao();
    SubCategoryDao subCategoryDao = new SubCategoryDao();
    CategoryDao categoryDao = new CategoryDao();
    VendorDao vendorDao = new VendorDao();
    DateConverter dateConverter = new DateConverter();
    //Add DAOs here

    // <editor-fold desc="Home Page - BudgetTracker Application">
    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    addTransaction();
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
                    System.out.println("Thank you for using the Budget Tracker!");
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

//        System.out.print("Enter an option: ");
//        return Integer.parseInt(userInput.nextLine());
        return getUserInt("Enter an option: ");
    }

    // </editor-fold>

    // <editor-fold desc="Add Transaction">

    private void addTransaction()
    {
        try {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Add Transaction");
            System.out.println("--------------------------------------");
            System.out.println("Enter Transaction Information");
            System.out.println();

            BigDecimal amount = getUserBigDecimal("Amount: ");
            LocalDate date = getUserLocalDate("Date: ");
            String notes = getUserString("Notes: ");
            String userName = getUserString("Username: ");
            String vendor = getUserString("Vendor: ");
            String subCategory = getUserString("Sub Category: ");

            // Find names and convert to ids
            User userFound = userDao.getUserByName(userName);
            if (userFound == null)
            {
                System.out.println("Username not found");
            }
            int userId = userFound.getUserId();

            Vendor vendorFound = vendorDao.getVendorByName(vendor);
            if (vendorFound == null)
            {
                System.out.println("Vendor not found");
            }
            int vendorId = vendorFound.getVendorId();

            SubCategory subCategoryFound = subCategoryDao.getSubCategoryByName(subCategory);
            if (subCategoryFound == null)
            {
                System.out.println("Sub Category not found");
            }
            int subCategoryId = subCategoryFound.getSubCategoryId();

            Transaction newTransaction = new Transaction();

            // Set values for new Transaction
            newTransaction.setAmount(amount);
            newTransaction.setTransactionDate(date);
            newTransaction.setNotes(notes);
            newTransaction.setUserId(userId);
            newTransaction.setVendorId(vendorId);
            newTransaction.setSubCategoryId(subCategoryId);

            transactionDao.addTransaction(newTransaction);

            System.out.println();
            System.out.println("Transaction is added successfully. Thank you!");


        }
        catch (Exception e)
        {
            System.out.println("Sorry, unable to add transaction this time. Please try again later.");
        }
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
        System.out.println("--------------------------------------");
        System.out.println("Reports");
        System.out.println("--------------------------------------");
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
        System.out.println("-".repeat(100));
        System.out.println("Transactions By User");
        System.out.println("-".repeat(100));
        String userName = getUserString("Enter User Name: ");
        System.out.println();

        //Convert userName to id
        User userFound = userDao.getUserByName(userName);
        int userId = userFound.getUserId();

        // Get transaction using userId
        var transactions = transactionDao.getTransactionByUser(userId);

        System.out.println("-".repeat(100));
        System.out.println(" Date        Amount    Notes ");
        System.out.println("----------  --------  ------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getTransactionDate());
            System.out.print("   $");
            System.out.print(transaction.getAmount());
            System.out.print("   ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsByMonth()
    {

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Month");
        System.out.println("-".repeat(100));
        String monthInput = getUserString("Enter month: ");
        System.out.println();

        // Convert month string to format MM:
        String month = DateConverter.convertMonth(monthInput);

        var transactions = transactionDao.getTransactionByMonth(month);

        System.out.println("-".repeat(100));
        System.out.println(" Date        Amount    Notes ");
        System.out.println("----------  --------  ------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getTransactionDate());
            System.out.print("   $");
            System.out.print(transaction.getAmount());
            System.out.print("   ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsByYear()
    {

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Year");
        System.out.println("-".repeat(100));
        int year = getUserInt("Enter year: ");
        System.out.println();

        var transactions = transactionDao.getTransactionByYear(year);

        System.out.println("-".repeat(100));
        System.out.println(" Date        Amount    Notes ");
        System.out.println("----------  --------  ------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getTransactionDate());
            System.out.print("   $");
            System.out.print(transaction.getAmount());
            System.out.print("   ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsBySubCategory()
    {

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Sub Category");
        System.out.println("-".repeat(100));
        String subCategoryName = getUserString("Enter sub category: ");
        System.out.println();

        // Convert subcategory name to id
        SubCategory subcategoryFound = subCategoryDao.getSubCategoryByName(subCategoryName);
        int subCategoryId = subcategoryFound.getSubCategoryId();

        // Get transaction using subcategory id
        var transactions = transactionDao.getTransactionBySubCategory(subCategoryId);

        System.out.println("-".repeat(100));
        System.out.println(" Date        Amount    Notes ");
        System.out.println("----------  --------  ------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getTransactionDate());
            System.out.print("   $");
            System.out.print(transaction.getAmount());
            System.out.print("   ");
            System.out.print(transaction.getNotes());
            System.out.println();

        }

        waitForUser();
    }

    private void transactionsByCategory()
    {

        System.out.println();
        System.out.println("-".repeat(100));
        System.out.println("Transactions By Category");
        System.out.println("-".repeat(100));
        String categoryName = getUserString("Enter category: ");
        System.out.println();

        // Convert subcategory name to id
        Category categoryFound = categoryDao.getCategoryByName(categoryName);
        int categoryId = categoryFound.getCategoryId();

        // Get transaction using subcategory id
        var transactions = transactionDao.getTransactionByCategory(categoryId);

        System.out.println("-".repeat(100));
        System.out.println(" Date        Amount    Notes ");
        System.out.println("----------  --------  ------------------");

        for (Transaction transaction : transactions)
        {
            System.out.print(transaction.getTransactionDate());
            System.out.print("   S");
            System.out.print(transaction.getAmount());
            System.out.print("   ");
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

    private BigDecimal getUserBigDecimal(String message)
    {
        return BigDecimal.valueOf(Double.valueOf(getUserString(message)));
    }

    private LocalDate getUserLocalDate(String message)
    {
        return LocalDate.parse(getUserString(message));

    }

    // </editor-fold>
}
