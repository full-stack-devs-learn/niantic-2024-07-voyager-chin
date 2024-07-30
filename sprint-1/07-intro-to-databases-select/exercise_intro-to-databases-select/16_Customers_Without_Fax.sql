USE northwind;

-- The company_name, contact_name and phone of 
-- all customers for whom we do
-- not have a fax number

-- Expected: 22 rows

SELECT company_name
	, contact_name
    , phone
FROM customers
WHERE fax is NULL;