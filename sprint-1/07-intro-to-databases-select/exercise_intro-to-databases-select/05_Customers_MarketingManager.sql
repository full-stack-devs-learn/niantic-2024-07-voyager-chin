USE northwind;

-- The company name, contact name, title and phone of 
-- all customers where the contact is the 
-- Marketing Manager of the company
-- Expected: 12 rows

SELECT company_name
	, contact_name
    , contact_title
    , phone
FROM customers
WHERE contact_title = 'Marketing Manager';