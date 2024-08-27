-- 5. The sum of all sales
-- sales_price * quantity -- don't worry about discount
-- (Use the customer_order view)

-- (1 row) -- 1354489.59

USE northwind; 

SELECT SUM(sales_price * quantity) AS 'sum of all sales'
FROM customer_orders;




