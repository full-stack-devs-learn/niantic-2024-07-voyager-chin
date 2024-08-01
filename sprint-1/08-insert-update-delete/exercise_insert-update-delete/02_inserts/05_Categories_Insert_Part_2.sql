USE northwind;

-- Select the new Category id
SELECT *
FROM CATEGORIES
WHERE category_id = last_insert_id();
