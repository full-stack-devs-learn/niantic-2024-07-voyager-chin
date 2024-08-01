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

SET @category_to_delete = 9; -- category id input

DELETE FROM products
WHERE category_id = @category_to_delete;

DELETE FROM categories
WHERE category_name = @category_to_delete;


