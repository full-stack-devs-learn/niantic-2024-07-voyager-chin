-- 18. Count the number of customers in each country
-- include the country and total_customer_count
-- (use customers table)

-- (21 rows)
USE northwind;

SELECT country
	, COUNT(DISTINCT customer_id)
FROM customers
GROUP BY country;



