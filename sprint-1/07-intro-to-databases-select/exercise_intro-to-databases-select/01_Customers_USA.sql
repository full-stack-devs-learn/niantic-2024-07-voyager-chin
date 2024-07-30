USE northwind;

-- The company_name, city and country of 
-- all customers in the USA
-- Expected: 13 rows

SELECT company_name
	, city
    , country
FROM customers
WHERE country = 'USA';
