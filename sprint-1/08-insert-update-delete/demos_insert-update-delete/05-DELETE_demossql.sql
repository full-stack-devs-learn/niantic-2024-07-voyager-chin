USE world;

-- BEFORE performing a DELETE
-- ALWAYS test the WHERE clause 
-- with a SELECT
SELECT *
FROM city
WHERE id = 4004;


DELETE FROM city
WHERE id = 4004;

SELECT *
FROM country
WHERE Code = 'USA';

-- this will fail
-- because there are still cities
-- that use the CountryCode 'USA'
DELETE FROM country
WHERE Code = 'USA';