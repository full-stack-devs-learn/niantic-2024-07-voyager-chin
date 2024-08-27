-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;

SELECT c.company_name
	, ca.category_name
	, COUNT(o.order_id) AS order_count
FROM customers AS c
INNER JOIN orders AS o
	ON c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
INNER JOIN categories AS ca
	ON p.category_id = ca.category_id
GROUP BY c.company_name
	, ca.category_name
HAVING company_name = 'Save-a-lot Markets'
ORDER BY order_count DESC;
