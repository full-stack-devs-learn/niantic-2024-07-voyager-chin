-- 7. Select the price of the most expensive product

-- (1 row)
USE northwind; 

SELECT unit_price AS 'most expensive product price'
FROM products
ORDER BY unit_price DESC
LIMIT 1;


