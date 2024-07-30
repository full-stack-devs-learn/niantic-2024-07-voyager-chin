USE northwind;

-- The Product name, UnitsInStock
-- of all products that are low in stock
-- (They have fallen below the re-order level)

-- Expected: 18 rows

SELECT product_name
	, units_in_stock
FROM products
WHERE units_in_stock < reorder_level;