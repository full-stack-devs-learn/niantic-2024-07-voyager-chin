USE world;

SELECT *
FROM city
WHERE name = 'Grantsville';

UPDATE city
SET population = 13500
	, CountryCode = 'USA'
    , District = 'Utah'
WHERE id = 4081;
