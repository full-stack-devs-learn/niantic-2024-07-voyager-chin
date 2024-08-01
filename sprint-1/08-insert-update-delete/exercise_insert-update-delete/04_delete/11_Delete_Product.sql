USE northwind;

-- delete one of your new sporting goods products
-- from the database
-- choose one that has not been purchased 

-- Check first if product is listed:
-- SELECT *
-- FROM products;

-- Deletes the Fishing Rod product
DELETE FROM products
WHERE product_name = 'Fishing Rod';

