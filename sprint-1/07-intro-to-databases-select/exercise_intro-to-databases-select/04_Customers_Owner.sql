USE northwind;

-- The company name, contact name, title and phone of 
-- all customers where the contact is the owner 
-- of the company
-- Expected: 17 rows

SELECT company_name
	, contact_name
    , contact_title
    , phone
FROM customers
WHERE contact_title = 'Owner';