# Introduction to databases

The purpose of this exercise is to practice the important skill of analyzing data in databases using Structured Query Language (SQL).

## Learning objectives

After completing this exercise, you'll understand:

* How to write `SELECT` statements.
* How to filter data using `WHERE` clauses.
* How to execute mathematical expressions and string concatenation in SQL statements.
* How to filter data for `NULL` values.

## Evaluation criteria and functional requirements

* All of the queries run as expected.
* The number of results returned from your query equals the number of results specified in each question.
* The query results are what is expected.
* Code is clean, concise, and readable.

To complete this exercise, you need to write SQL queries in the files that are in the `Exercises` folder. You'll use the `Northwind` database as a source for all queries.

In each file, there's a commented out problem statement. Below it, write the query needed to solve the problem. The value immediately after the problem statement is the expected number of rows that must be returned by the query.

## Getting started

1. Open MySQL Workbench.
2. To complete the exercises, you must open each file individually as follows `File -> Open SQL Script` and navigate to the file  
3. Complete the task in the file by writing the `SELECT` statement. Then execute the query to ensure that the correct rows are returned.
4. Save the file and open the next file in the exercise.

## Tips and tricks

* `SELECT` statements specify the columns of a table that you want to return from a query. While the values in the `SELECT` statement are usually directly mapped to a column name, they can also be aliased using the `AS` keyword.
* `WHERE` clauses filter results. Some operators you can use for filtering out data include:
    * `=`, `<>`, `!=`, `>`, `>=`, `<`, `<=`
    * `IN(values)`, `NOT IN(values)`
    * `BETWEEN value1 AND value2`
    * `IS NULL`, `IS NOT NULL`
    * `LIKE`, (with wildcard characters)
* Multiple filter conditions can be combined using `AND` and `OR`.
* The `DISTINCT` clause removes duplicate values from the results.
* [SQLZoo.net][sql-zoo] is a great online resource for learning how to query databases.
* The SQL Server documentation includes a [tutorial for querying database tables][sql-server-how-to-query], as well as [documentation related to the `SELECT` statement][sql-server-select].

![Northwind Database](images/northwind.png "Northwind Schema")

[sql-zoo]: https://sqlzoo.net/
[sql-server-how-to-query]: https://docs.microsoft.com/en-us/sql/t-sql/lesson-1-creating-database-objects
[sql-server-select]: https://docs.microsoft.com/en-us/sql/t-sql/queries/from-transact-sql
