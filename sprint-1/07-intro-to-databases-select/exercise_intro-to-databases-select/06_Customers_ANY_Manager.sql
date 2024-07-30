USE northwind;

-- The company name, contact name, title and phone of 
-- all customers where the contact has the word manager
-- in their title

-- Expected: 33 rows (changed from 17)

SELECT company_name
	, contact_name
    , contact_title
    , phone
FROM customers
WHERE contact_title LIKE '%Manager%';