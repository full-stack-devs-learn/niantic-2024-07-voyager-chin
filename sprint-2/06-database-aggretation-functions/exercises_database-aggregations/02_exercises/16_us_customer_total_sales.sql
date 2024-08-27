-- 16. Total sales by customer in the US
-- Include the company_name, state and total_sales
-- Sort alphabetically by state, then by total sales desc
-- (Use the customer_orders view)

-- (13 rows)
USE northwind;

-- SELECT * FROM customer_orders;

SELECT company_name
	, region
    , SUM(sales_price * quantity) AS total_sales
FROM customer_orders
WHERE country = 'USA'
GROUP BY company_name
	, region
ORDER BY region, SUM(sales_price * quantity) DESC;


