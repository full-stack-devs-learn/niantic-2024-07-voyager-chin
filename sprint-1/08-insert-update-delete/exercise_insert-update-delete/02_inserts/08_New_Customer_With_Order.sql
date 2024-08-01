-- Create a full script with variables that allows you
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products (*product id). Create 5 variables at the top of the script
-- that store the 5 product names(*ID) the customer wants to buy. You will use
-- the product names to find the id

-- To add new customer details, please replace the values here:
SET @new_customer_id = 'ZZENT';
SET @new_company_name = 'ZebraZone Enterprises';
SET @new_contact_name = 'Zara Zinnia';
SET @new_address = '987 Zebra Lane';
SET @new_city = 'San Francisco';
SET @new_region ='CA';
SET @new_postal_code = 94120;
SET @new_country = 'USA';

-- Please input the product names for the new order:
SET @product_1 = 'Chai';
SET @product_2 = 'Chang';
SET @product_3 = 'Aniseed Syrup';
SET @product_4 = 'Mishi Kobe Niku';
SET @product_5 = 'Ikura';
-- (Note: Each product order will have a default quantity of 1)

-- Please change the order date if needed
SET @date_today = '2024-07-31 00:00:00';

-- ----------------------------------------------------------- --
-- Please do not change any values after this line. Thank you! --
-- ----------------------------------------------------------- --

-- Get product ids:
SELECT @product_id1:= product_id
FROM products
WHERE product_name = @product_1;
SELECT @product_id2:= product_id
FROM products
WHERE product_name = @product_2;
SELECT @product_id3:= product_id
FROM products
WHERE product_name = @product_3;
SELECT @product_id4:= product_id
FROM products
WHERE product_name = @product_4;
SELECT @product_id5:= product_id
FROM products
WHERE product_name = @product_5;

-- Get product prices:
SELECT @price1:= unit_price
FROM products
WHERE product_id = @product_id1;
SELECT @price2:= unit_price
FROM products
WHERE product_id = @product_id2;
SELECT @price3:= unit_price
FROM products
WHERE product_id = @product_id3;
SELECT @price4:= unit_price
FROM products
WHERE product_id = @product_id4;
SELECT @price5:= unit_price
FROM products
WHERE product_id = @product_id5;

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/

-- ADD NEW CUSTOMER:
INSERT INTO customers (customer_id, company_name, contact_name, address, city, region, postal_code, country)
VALUES (@new_customer_id, @new_company_name, @new_contact_name, @new_address, @new_city, @new_region, @new_postal_code, @new_country);

-- ADD NEW ORDER:
INSERT INTO orders (customer_id, order_date)
VALUES (@new_customer_id, @date_today);

-- ADD PRODUCTS TO ORDER:
INSERT INTO order_details (order_id, product_id, unit_price, quantity, discount)
VALUES (@order_id, product_id1, @price1, 1, 0)
	, (@order_id, product_id2, @price2, 1, 0)
    , (@order_id, product_id3, @price3, 1, 0)
	, (@order_id, product_id4, @price4, 1, 0)
	, (@order_id, product_id5, @price5, 1, 0);
