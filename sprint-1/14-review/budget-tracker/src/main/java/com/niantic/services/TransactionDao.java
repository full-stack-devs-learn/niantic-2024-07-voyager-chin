package com.niantic.services;

import com.niantic.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

public class TransactionDao
{
    private final JdbcTemplate jdbcTemplate;

    // Connect to data source
    public TransactionDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //+ getTransactionByUser(userId: int): ArrayList<Transaction>
    public ArrayList<Transaction> getTransactionByUser(int userId)
    {
        // Create ArrayList that will store transactions of user
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Build query to SELECT values that will match userId
        String sql = """
                SELECT transaction_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE user_id = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, userId);

        // Loop through rows to get transaction information
        while (row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int subCategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            BigDecimal amount = row.getBigDecimal("amount");
            String notes = row.getString("notes");

            // Add transactions to ArrayList
            Transaction transaction = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate, amount, notes);
            transactions.add(transaction);
        }

        // Return ArrayList of transactions that match selected userId
        return transactions;

    }

    //+ getTransactionByMonth(month: int): ArrayList<Transaction>
    public ArrayList<Transaction> getTransactionByMonth(String month)
    {
        // Create ArrayList that will store transactions of selected month
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Build query to SELECT values of selected month
        String sql = """
                SELECT transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE transaction_date LIKE '____-?-__';
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, month);

        // Loop through rows to get transaction information
        while (row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int subCategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            BigDecimal amount = row.getBigDecimal("amount");
            String notes = row.getString("notes");

            // Add transactions to ArrayList
            Transaction transaction = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate, amount, notes);
            transactions.add(transaction);
        }

        // Return ArrayList of transactions that match selected month
        return transactions;
    }

    //+ getTransactionByYear(year: int): ArrayList<Transaction>
    public ArrayList<Transaction> getTransactionByYear(int year)
    {
        // Create ArrayList that will store transactions of selected year
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Build query to SELECT values of selected year
        String sql = """
                SELECT transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE transaction_date LIKE '?%';
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, year);

        // Loop through rows to get transaction information
        while (row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int subCategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            BigDecimal amount = row.getBigDecimal("amount");
            String notes = row.getString("notes");

            // Add transactions to ArrayList
            Transaction transaction = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate, amount, notes);
            transactions.add(transaction);
        }

        // Return ArrayList of transactions that match year
        return transactions;
    }

    //+ getTransactionBySubCategory(subCategoryId: int): ArrayList<Transaction>
    public ArrayList<Transaction> getTransactionBySubCategory(int subCategoryId)
    {
        // Create ArrayList that will store transactions of selected sub category
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Build query to SELECT values that will match subCategoryId
        String sql = """
                SELECT transaction_id
                    , user_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE sub_category_id = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, subCategoryId);

        // Loop through rows to get transaction information
        while (row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            BigDecimal amount = row.getBigDecimal("amount");
            String notes = row.getString("notes");

            // Add transactions to ArrayList
            Transaction transaction = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate, amount, notes);
            transactions.add(transaction);
        }

        // Return ArrayList of transactions that match subCategoryId
        return transactions;
    }

    //+ getTransactionByCategory(categoryId: int): ArrayList<Transaction>
    public ArrayList<Transaction> getTransactionByCategory(int categoryId)
    {
        // Create ArrayList that will store transactions
        ArrayList<Transaction> transactions = new ArrayList<>();

        // Build query to SELECT values that will match categoryId
        String sql = """
                SELECT transactions.transaction_id
                    , transactions.user_id
                    , transactions.sub_category_id
                    , transactions.vendor_id
                    , transactions.transaction_date
                    , transactions.amount
                    , transactions.notes
                FROM transactions
                JOIN sub_categories ON transactions.sub_category_id = sub_categories.sub_category_id
                WHERE sub_categories.category_id = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, categoryId);

        // Loop through rows to get transaction information
        while (row.next()) {
            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int subCategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            BigDecimal amount = row.getBigDecimal("amount");
            String notes = row.getString("notes");

            // Add transactions to ArrayList
            Transaction transaction = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate, amount, notes);
            transactions.add(transaction);
        }

        // Return ArrayList of transactions that match categoryId
        return transactions;
    }


    //+ getTransactionById(transactionId: int): Transaction
    public Transaction getTransactionById(int transactionId)
    {
        Transaction transaction = new Transaction();
        // Build query to SELECT values that will match transactionId
        String sql = """
                SELECT transaction_id
                    , user_id
                    , vendor_id
                    , transaction_date
                    , amount
                    , notes
                FROM transactions
                WHERE transaction_id = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, transactionId);

        // Loop through rows to get transaction information
        while (row.next()) {
            int userId = row.getInt("user_id");
            int subCategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            BigDecimal amount = row.getBigDecimal("amount");
            String notes = row.getString("notes");

            // Add transactions to ArrayList
            transaction = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate, amount, notes);
        }

        // Return ArrayList of transaction that match transactionId
        return transaction;

    }


    //+ addTransaction(transaction: Transaction): void
    public void addTransaction(Transaction transaction)
    {
        // Build query to insert values into transactions table
        String sql = "INSERT INTO transactions (user_id, sub_category_id, vendor_id, transaction_date, amount, notes) VALUES (?,?,?,?,?,?);";

        // Execute query to add transaction details
        jdbcTemplate.update(sql,
                transaction.getUserId(),
                transaction.getSubCategoryId(),
                transaction.getVendorId(),
                transaction.getTransactionDate(),
                transaction.getAmount(),
                transaction.getNotes()
        );
    }

    //not priority + updateTransaction(transaction: Transaction): void
    //not priority + deleteTransaction(transactionId: int): void

}
