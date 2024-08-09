package com.niantic.models;

import java.util.Date;

public class Transaction
{
    // Declare private variables
    private int transactionId;
    private int userId;
    private int subCategoryId;
    private int vendorId;
    private Date transactionDate;
    private double amount;
    private String notes;

    // Parameterless
    public Transaction()
    {

    };

    // Parameterized
    public Transaction(int transactionId, int userId, int subCategoryId, int vendorId, Date transactionDate, double amount, String notes)
    {
        this.transactionId = transactionId;
        this.userId = userId;
        this.subCategoryId = subCategoryId;
        this.vendorId = vendorId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.notes = notes;
    }

    // Getters and setters
    public int getTransactionId() { return transactionId; }

    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getSubCategoryId() { return subCategoryId; }

    public void setSubCategoryId(int subCategoryId) { this.subCategoryId = subCategoryId; }

    public int getVendorId() { return vendorId; }

    public void setVendorId(int vendorId) { this.vendorId = vendorId; }

    public Date getTransactionDate() { return transactionDate; }

    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public String getNotes() { return notes; }

    public void setNotes(String notes) { this.notes = notes; }

}
