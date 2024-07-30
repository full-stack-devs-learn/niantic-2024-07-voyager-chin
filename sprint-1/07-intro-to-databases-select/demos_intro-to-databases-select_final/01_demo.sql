USE world;

/*


*/

-- give me all rows and columns from the city table
SELECT * -- ALL COLUMNS
FROM country;

-- give me the name, country and population of all cities in Germany
-- sorted by population largest to smallest
SELECT 
	Name
 	, CountryCode
    , Population
FROM city
WHERE CountryCode = 'DEU'
ORDER BY Population DESC
LIMIT 5; -- show only the first 5 rows

/*
Naming Conventions:

MS SQL Server - PascalCase
MySQL 		  - lower_snake_case
Postgresql    - lower_snake_case
*/

