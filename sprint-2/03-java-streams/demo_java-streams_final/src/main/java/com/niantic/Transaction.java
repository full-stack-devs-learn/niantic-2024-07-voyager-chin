package com.niantic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction
{
    private LocalDate transactionDate;

    public Transaction(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    public LocalDate getTransactionDate()
    {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    public String getFormattedTransactionDate()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return transactionDate.format(formatter);
    }
}
