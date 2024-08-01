USE northwind;

-- Delete the Sporting Goods Catregory from the database.
/*
DELETE FROM categories
WHERE category_name = 'Sporting Goods';
*/

-- Why does it fail to delete?
/* It fails to delete because it is connected to some product information:
Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`northwind`.`products`, CONSTRAINT `fk_products_categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`))
*/

-- What else needs to be done to fully delete the Category?
/* All products associated with the Sporting Goods category must be deleted first before we can delete the category */

-- Write a script that preforms all necessary steps to 
-- delete the category from the database.

-- The only user input should be a variable at the top of the 
-- script that holds the Category Name.
-- The sript should do the rest


-- To delete a category, please replace the value here with the category name you want to delete:
SET @category_name = 'Sporting Goods';


-- ----------------------------------------------------------- --
-- Please do not change any values after this line. Thank you! --
-- ----------------------------------------------------------- --

SELECT @category_id:= category_id
FROM categories
WHERE category_name = @category_name;

DELETE FROM products
WHERE category_id = @category_id;

DELETE FROM categories
WHERE category_name = @category_name;



