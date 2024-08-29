-- 4. Select the full name of each employee
-- using a sub-query also display the full name of the employees manager

-- NO JOINS allowed

-- employee             manager
-- ------------------   -------------------
-- Nancy Davolio        Andrew Fuller
-- Andrew Fuller        <null>
-- Janet Leverling      Andrew Fuller
-- Margaret Peacock     Andrew Fuller
-- Steven Buchanan      Andrew Fuller
-- Michael Suyama       Steven Buchanan
-- Robert King          Steven Buchanan
-- Laura Callahan       Andrew Fuller
-- Anne Dodsworth       Steven Buchanan


-- (9 rows)

USE northwind;

SELECT CONCAT(first_name, ' ', last_name) AS employee
	, (
		SELECT CONCAT(first_name, ' ', last_name)
        FROM employees AS m
        WHERE e.reports_to = m.employee_id
    ) AS manager
FROM employees AS e;

