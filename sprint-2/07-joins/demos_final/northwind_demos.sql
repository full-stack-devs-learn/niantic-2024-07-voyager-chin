USE northwind;

SELECT c.company_name
	, p.product_name
    , count(p.product_name) as count
FROM customers AS c
INNER JOIN  orders AS o
	ON c.customer_id = o.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
GROUP BY c.company_name
	, p.product_name
HAVING count >= 2
ORDER BY count desc