USE northwind;

-- all employees for whom I don't know what state they live in
SELECT *
FROM employees
WHERE region IS NULL;

-- all employees for whom I DO know what state they live in
SELECT *
FROM employees
WHERE region IS NOT NULL;