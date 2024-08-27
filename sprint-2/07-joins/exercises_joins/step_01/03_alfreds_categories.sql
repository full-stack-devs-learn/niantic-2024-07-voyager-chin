-- 3.  List of all the categories 
-- that Alfreds Futterkiste has ever ordered
-- (5 rows)

USE Northwind;

SELECT DISTINCT category_name AS 'Alfreds Categories'
FROM customers AS c
INNER JOIN orders AS o
	ON c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
INNER JOIN categories AS ca
	ON p.category_id = ca.category_id
WHERE company_name = 'Alfreds Futterkiste'
ORDER BY category_name;

