USE northwind;

-- permanent saved query
CREATE VIEW products_beverages
AS
SELECT *
FROM products
WHERE category_id = 1;

-- CTE - Common Table Expression
-- single use query
WITH beverages AS (
	SELECT product_id AS id
		, product_name AS name
		, unit_price AS price
        , category_id
	FROM products
    WHERE category_id = 1
)
SELECT *
FROM beverages
WHERE price > 20;

-- SELECT *
-- FROM products_beverages