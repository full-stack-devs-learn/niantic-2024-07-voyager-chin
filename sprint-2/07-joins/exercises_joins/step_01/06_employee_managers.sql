-- 6. Select the full name of each employee
-- and the full name of their manager

-- hint look at the employee table to see how to
-- determine who the manager is of each employee

-- you will need to do a "self join" to the employees table
-- and you will need to create table aliases to complete this query

-- (9 rows)

USE northwind;

SELECT CONCAT(e.last_name, ' ', e.first_name) AS Employee
	, CONCAT(m.last_name, ' ', m.first_name) AS Manager
FROM employees AS e
LEFT OUTER JOIN employees AS m
	ON m.employee_id = e.reports_to
ORDER BY Employee;
