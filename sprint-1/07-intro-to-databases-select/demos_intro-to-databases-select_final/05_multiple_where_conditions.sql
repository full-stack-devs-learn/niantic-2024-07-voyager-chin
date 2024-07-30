USE northwind;

-- All sales reps in washington
-- first name, last name, title, state
SELECT first_name
	, last_name
    , title
    , region as state
FROM employees
WHERE title LIKE 'Sales%'
	AND region = 'WA'
;