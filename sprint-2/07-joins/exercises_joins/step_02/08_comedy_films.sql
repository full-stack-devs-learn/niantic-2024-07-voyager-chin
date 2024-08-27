-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;

SELECT c.name AS 'Category Name'
	, f.title AS 'Film Title'
FROM actor AS a
INNER JOIN film_actor AS fa
	ON a.actor_id = fa.actor_id
INNER JOIN film As f
	ON fa.film_id = f.film_id
INNER JOIN film_category AS fc
	ON f.film_id = fc.film_id
INNER JOIN category AS c
	ON fc.category_id = c.category_id
WHERE c.name = 'Comedy'
GROUP BY f.title;
