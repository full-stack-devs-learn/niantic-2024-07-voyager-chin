-- this script creates a full database
-- with tables and sample data

DROP DATABASE IF EXISTS store;

CREATE DATABASE	store;

USE store;

-- create tables
CREATE TABLE categories
(
	category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(200) NOT NULL,
    description TEXT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE products
(
	product_id INT NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(200) NOT NULL,
    description VARCHAR(2000) NULL,
    price DECIMAL(10,2) NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);


-- add seed data
-- categories
INSERT INTO categories(category_id, category_name, description)
VALUES (1001, 'Electronics', '')
	, (1002, 'Shoes','')
    , (1003, 'Kitchen','');
    
    
ALTER TABLE products AUTO_INCREMENT = 30001;
 
INSERT INTO products( product_name, category_id, price)
VALUES ('AirPods 3',1001, 159.50)
	, ('Wireless Mouse', 1001, 19.99)
    , ('Air Jordans',1002, 500)
    ;
    
    
