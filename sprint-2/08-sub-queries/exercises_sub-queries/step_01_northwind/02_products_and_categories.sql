-- 2. Create a product categories report

-- Columns to include:
-- ------------------
-- Category Name
-- Product Name
-- Unit Price


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by category name, then product name

USE Northwind;

SELECT (
		  SELECT category_name
          FROM categories AS c
          WHERE c.category_id = p.category_id
          ORDER BY category_name
	   ) AS 'Category Name'
	, product_name AS 'Product Name'
    , unit_price AS 'Unit Price'
FROM products AS p
ORDER BY product_name;
