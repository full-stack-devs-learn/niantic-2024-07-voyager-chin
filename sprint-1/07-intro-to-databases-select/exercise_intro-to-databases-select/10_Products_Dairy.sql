USE northwind;

-- The Product name, price and category id
-- of all dairy products

-- Expected: 10 rows

SELECT product_name
	, unit_price
    , category_id
FROM products
WHERE category_id = 4; -- dairy product category_id: 4