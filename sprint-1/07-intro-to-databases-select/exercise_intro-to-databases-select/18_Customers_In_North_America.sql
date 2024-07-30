USE northwind;

-- The name and country
-- of all customers in North America
-- Canada, USA, Mexico
-- Sort the results by country in alphabetic order

-- Expected: 21 Rows

SELECT contact_name
	, country
FROM customers
WHERE country = 'Canada'
	OR country = 'USA'
    OR country = 'Mexico';