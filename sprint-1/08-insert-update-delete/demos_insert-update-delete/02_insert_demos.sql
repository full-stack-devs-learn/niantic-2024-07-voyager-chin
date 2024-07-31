USE northwind;

-- a full INSERT statement with ALL columns specified
INSERT INTO products
(
	product_id
    , product_name
    , supplier_id
    , category_id
    , quantity_per_unit
    , unit_price
    , units_in_stock
    , units_on_order
    , reorder_level
    , discontinued
)
VALUES
(
	78
    , 'Ritter Sport - Marzipan'
    , 1
    , 3
    , '1 bar'
    , 2.99
    , 100
    , 0
    , 20
    , false
);

-- more common INSERT where we specify only the required fields
INSERT INTO products
(
	-- product_id is an auto_increment field so we do not need to specify it
    product_name
    , unit_price
)
VALUES
(
	'Ritter Sport - Marzipan'
    , 2.99
);

-- single line INSERT
INSERT INTO products (product_name, unit_price) VALUES ('Milka Alpenmilch', 3.99);

-- multiple row INSERT
-- these are great for populating database scripts
INSERT INTO products (product_name, unit_price) 
VALUES ('Milka Alpenmilch', 3.99)
	 , ('Red Vines', 2.50)
	 , ('Sour Patch Kids (L)', 6.50);
    

INSERT INTO products (product_name, unit_price) VALUES ('Chocolate Chip Cookies', 2.99);
     
-- HOW do I get the new ID?
SELECT LAST_INSERT_ID();

SET @new_id = last_insert_id();

SELECT @new_id;

SELECT *
FROM products
WHERE product_id = @new_id;