-- 8. The smallest line item amount made in Europe
-- (Use the customer_orders view)

-- (1 row) $4.80

USE northwind;

SELECT (sales_price * quantity) - (sales_price * quantity * discount) AS 'smallest Europe line item total'
FROM customer_orders
WHERE country IN('Germany', 'Switzerland', 'France', 'Portugal', 'Finland', 'Poland', 'Ireland', 'Sweden', 'UK')
ORDER BY (sales_price * quantity) - (sales_price * quantity * discount)
LIMIT 1;



