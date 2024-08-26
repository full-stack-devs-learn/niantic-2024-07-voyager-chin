USE northwind;

-- ORDERING RESULTS


-- Company Name, Country and City sorted by country, then city
SELECT *
FROM customers;

SELECT company_name
	, country
    , city
FROM customers
ORDER BY country
	, city;


-- All Countries and Cities where we have Customers.
SELECT DISTINCT country
    , city
--    , contact_title
FROM customers
ORDER BY country
	, city;


-- Product name and price - most expensive first
SELECT product_name
	, unit_price
FROM products
ORDER BY unit_price DESC;



-- LIMITING RESULTS

-- most expensive product
SELECT product_name
	, unit_price
FROM products
ORDER BY unit_price DESC
LIMIT 1;


-- 10 most expensive products
SELECT product_name
	, unit_price
FROM products
ORDER BY unit_price DESC
LIMIT 10;



-- 20 LEAST expensive products
SELECT product_name
	, unit_price
FROM products
ORDER BY unit_price 
LIMIT 20;


-- price sorted desc within each category
SELECT category_id
	, max(unit_price) as most_expensive
FROM products
GROUP BY category_id
ORDER BY category_id
;





-- CONCATENATING OUTPUTS

-- Title FirstName LastName from employees table in one column.
USE Northwind;

SELECT CONCAT(title_of_courtesy, ' ', first_name, ' ', last_name) AS full_name
FROM employees;

USE world;

-- arithmetic with NULL values
SELECT Name
	, GNP
    , COALESCE(GNPOld, 0) AS GNP_OLD
    , GNP - COALESCE(GNPOld, 0) AS ChangeInGNP
FROM country;




-- AGGREGATE FUNCTIONS

-- Average price of all products


-- Most Expensive product price


-- Name and price of the most expensive product(s)
-- requires sub-query



-- Name and price of the least expensive product(s)
-- requires sub-query




-- GROUP BY - think about how you would calculate aggregations manually
-- when you add groups - the same concepts apply with database
-- you have to specify the grouping parameters before you can start calculating

-- count all customers


-- number of customers in each country


-- most expensive product in each category


-- average product price in each category


-- number of products sold by each supplier


-- average price of product by supplier sorted by price desc





