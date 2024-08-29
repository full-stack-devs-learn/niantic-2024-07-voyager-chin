-- 3. Create a product supplier report

-- Columns to include:
-- -------------------
-- Product Name
-- units in stock
-- Supplier Name


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by product name

USE Northwind;

SELECT product_name AS 'Product Name'
	, units_in_stock AS 'units in stock'
    , (
		SELECT company_name
        FROM suppliers AS s
        WHERE s.supplier_id = p.supplier_id
        ) AS 'Supplier Name'
FROM products AS p;

