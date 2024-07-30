USE northwind;

-- The name, contact, phone and fax number of 
-- all suppliers for whom we
-- have a fax number

-- Expected: 13 rows

SELECT company_name
	, contact_name
    , phone
    , fax
FROM suppliers
WHERE fax IS NOT NULL;