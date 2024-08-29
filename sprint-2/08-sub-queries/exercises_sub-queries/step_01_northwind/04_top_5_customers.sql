-- 4. Using only sub-queries
-- Display the names of my top 5 customer
-- and the number of orders each has placed
-- the number of orders  determines top customer

-- (first 5 rows)
-- Save-a-lot Markets               31
-- Ernst Handel                     30
-- QUICK-Stop                       28
-- Folk och f HB                    19
-- Hungry Owl All-Night Grocers     19


USE northwind;

SELECT (SELECT company_name
		FROM customers AS c
        WHERE c.customer_id = o.customer_id
        ) AS Customer
        , COUNT(order_id) AS order_count
FROM orders AS o
GROUP BY Customer
ORDER BY order_count DESC
LIMIT 5;
