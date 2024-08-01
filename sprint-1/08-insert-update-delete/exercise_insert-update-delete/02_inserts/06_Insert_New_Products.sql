USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.

INSERT INTO products (product_name, category_id, unit_price, units_in_stock, units_on_order, reorder_level)
VALUES ('Mountain Bike', 9, 799, 5, 0, 3)
	, ('Yoga Mat', 9, 29, 20, 10, 8)
    , ('Tennis Racket', 9, 80, 10, 5, 5)
    , ('Running Shoes', 9, 120, 30, 10, 15)
    , ('Baseball Glove', 9, 69.50, 21, 5, 10)
    , ('Basketball', 9, 34.99, 23, 10, 15)
    , ('Fishing Rod', 9, 114.75, 20, 0, 10)
    , ('Golf Club Set', 9, 499, 32, 15, 20)
    , ('Yoga Pants', 9, 45, 50, 20, 25)
    , ('Soccer Ball', 9, 22.99, 28, 10, 25);
