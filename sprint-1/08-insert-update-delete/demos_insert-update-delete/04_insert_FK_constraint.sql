USE world;

SELECT *
FROM city;

INSERT INTO city
(
	Name
	, CountryCode
    , District
    , Population
)
VALUES
(
	'Grantsville'
    , 'USA'
    , 'Utah'
    , 13000
);

SELECT *
FROM city
WHERE District = 'Utah';