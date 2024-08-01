USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default

-- To check the contents of employees table:
-- SELECT *
-- FROM employees;

-- Insert new hire data
INSERT INTO employees
(
	last_name
    , first_name
    , title
    , title_of_courtesy
    , birth_date
	, hire_date
    , address
    , notes
)
VALUES
(
	'Antalan'
    , 'Chin'
    , 'Sales Associate'
    , 'Ms.'
    , '1992-03-27 00:00:00'
    , '2024-07-31 00:00:00'
    , '1234 5th St.'
    , ' '
);

-- To view inserted data
-- SELECT *
-- FROM employees
-- WHERE employee_id = last_insert_id();