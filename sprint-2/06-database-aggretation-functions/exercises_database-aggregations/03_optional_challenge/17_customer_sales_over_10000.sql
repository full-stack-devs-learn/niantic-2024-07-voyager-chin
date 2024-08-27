-- 16. Total sales by any customer who has spent more than $10000
-- Include the CompanyName, State and TotalSales
-- Sort by total sales desc
-- (Use the customer_orders view)

-- (6 rows)
USE northwind;

SELECT company_name
	, region
    , SUM(sales_price * quantity)
FROM customer_orders
GROUP BY company_name, region
ORDER BY SUM(sales_price * quantity) DESC;




