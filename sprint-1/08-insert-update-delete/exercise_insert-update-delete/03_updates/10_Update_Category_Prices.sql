USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

/*
View all products:
SELECT *
FROM products;
*/

SET @selected_category = 9; -- select category_id
SET @percent_increase = .5; -- provide percent increase

/*
Try first using SELECT if price will increase properly:
SELECT product_name
 	, unit_price
     , category_id
 	, unit_price + (unit_price * @percent_increase) AS price_increase
 FROM products
 WHERE category_id = @selected_category;
 */

-- This will update product price base on the @percent_increase provided:
UPDATE products
SET unit_price = unit_price + (unit_price * @percent_increase)
WHERE category_id = @selected_category;