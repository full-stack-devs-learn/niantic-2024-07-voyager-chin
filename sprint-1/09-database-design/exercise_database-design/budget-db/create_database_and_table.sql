DROP DATABASE IF EXISTS budget;

CREATE DATABASE budget;

USE budget;

-- ------------- --
-- CREATE TABLES --
-- ------------- --

-- Category Table
CREATE TABLE category
(
	category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (category_id)
);

-- Subcategory Table
CREATE TABLE subcategory
(
	subcategory_id INT NOT NULL AUTO_INCREMENT,
    subcategory_name VARCHAR(200) NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (subcategory_id),
    FOREIGN KEY (category_id) REFERENCES category (category_id)
);

-- Vendor Table
CREATE TABLE vendor
(
	vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(200) NOT NULL,
    subcategory_id INT NOT NULL,
    PRIMARY KEY (vendor_id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategory (subcategory_id)
);

-- Person Table
CREATE TABLE person
(
	person_id INT NOT NULL AUTO_INCREMENT,
    person_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (person_id)
);

-- Payments Table
CREATE TABLE payments
(
	payment_id INT NOT NULL AUTO_INCREMENT,
    payment_date DATE NOT NULL,
    person_id INT NOT NULL,
    vendor_id INT NOT NULL,
    amount DECIMAL(10, 2),
    notes TEXT NULL ,
    PRIMARY KEY (payment_id),
    FOREIGN KEY (person_id) REFERENCES person (person_id),
    FOREIGN KEY (vendor_id) REFERENCES vendor (vendor_id)
);

-- ------------- --
-- ADD SEED DATA --
-- ------------- --


