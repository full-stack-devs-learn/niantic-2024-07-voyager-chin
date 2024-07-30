USE northwind;

-- all products that cost between $10 and 50
SELECT product_name
	, unit_price
FROM products
WHERE unit_price BETWEEN 10 AND 50;