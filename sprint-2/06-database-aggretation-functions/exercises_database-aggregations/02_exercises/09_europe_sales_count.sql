-- 09. The total count of orders in Europe
-- Germany, Switzerland, France, Portugal, Finland, Poland, Ireland, Sweden, UK
-- (Use the customer_orders view)

-- (1 row) - 371 orders

USE northwind; 

SELECT COUNT(DISTINCT order_id)
FROM customer_orders
WHERE country IN('Germany', 'Switzerland', 'France', 'Portugal', 'Finland', 'Poland', 'Ireland', 'Sweden', 'UK');