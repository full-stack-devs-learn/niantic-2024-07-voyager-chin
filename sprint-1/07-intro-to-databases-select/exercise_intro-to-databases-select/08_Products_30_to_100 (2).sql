USE northwind;

-- The product name, price of all products
-- that cost between $30 AND $100

-- Expected: 23 rows

SELECT product_name
	, unit_price
FROM products
WHERE unit_price >= 30 AND unit_price <= 100;