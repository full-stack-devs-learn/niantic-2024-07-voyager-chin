-- 7. List the names of all actors who acted in
-- the film "HUMAN GRAFFITI"

-- (4 rows)

USE sakila;

SELECT a.first_name
	, a.last_name
FROM actor AS a
INNER JOIN film_actor AS fa
	ON a.actor_id = fa.actor_id
INNER JOIN film As f
	ON fa.film_id = f.film_id
WHERE f.title = 'HUMAN GRAFFITI';



