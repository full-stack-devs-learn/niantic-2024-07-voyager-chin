USE chores;

-- INNER JOIN
SELECT p.person_name
	, t.task_name
    , p.person_id
FROM person AS p
INNER JOIN task  AS t
	ON p.person_id = t.person_id
;

-- OUTER JOIN
-- LEFT OUTER JOIN
SELECT *
FROM person AS p 
LEFT OUTER JOIN task as t
	ON p.person_id = t.person_id
WHERE t.person_id IS NULL;

-- give me a list 
-- of tasks that have not been assigned
SELECT *
FROM person AS p
RIGHT OUTER JOIN task as t
	ON p.person_id = t.person_id;
    

-- FULL OUTER JOIN (not directly supported in MySQL)
-- we have to use UNION  
SELECT *
FROM person AS p
LEFT OUTER JOIN task as t
	ON p.person_id = t.person_id
    
UNION
    
SELECT *
FROM person AS p
RIGHT OUTER JOIN task as t
	ON p.person_id = t.person_id;




