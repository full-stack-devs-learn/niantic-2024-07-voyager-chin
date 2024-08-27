-- 11. The average sales amount for all sales in Europe
-- (Use the customer_orders view)

-- (1 row) approx $605.99

USE northwind;

SELECT AVG(sales_price * quantity) AS 'Europe Average Sale'
FROM customer_orders
WHERE country IN('Germany', 'Switzerland', 'France', 'Portugal', 'Finland', 'Poland', 'Ireland', 'Sweden', 'UK');



