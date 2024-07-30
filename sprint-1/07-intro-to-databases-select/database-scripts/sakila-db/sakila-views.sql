USE sakila;

DROP VIEW IF EXISTS actors_and_films;

CREATE VIEW actors_and_films
AS
SELECT a.actor_id
	, a.first_name
	, a.last_name
	, f.film_id
    , f.title
    , f.description
    , f.release_year
    , f.rental_duration
    , f.rental_rate
    , f.length
    , f.rating
    , f.special_features
    , c.category_id
    , c.name AS category
FROM film as f 
INNER JOIN film_category AS fc ON f.film_id = fc.film_id
INNER JOIN category AS c ON fc.category_id = c.category_id
INNER JOIN film_actor AS fa ON fa.film_id = f.film_id
INNER JOIN actor AS a ON a.actor_id = fa.actor_id;



DROP VIEW IF EXISTS films_and_categories;

CREATE VIEW films_and_categories
AS
SELECT f.film_id
    , f.title
    , f.description
    , f.release_year
    , f.rental_duration
    , f.rental_rate
    , f.length
    , f.rating
    , f.special_features
    , c.category_id
    , c.name AS category
FROM film as f 
INNER JOIN film_category AS fc ON f.film_id = fc.film_id
INNER JOIN category AS c ON fc.category_id = c.category_id;


DROP VIEW IF EXISTS films_without_categories;

CREATE VIEW films_without_categories
AS
SELECT *
FROM film AS f
WHERE NOT EXISTS (
	SELECT 1
    FROM film_category AS fc
    WHERE fc.film_id = f.film_id
);


DROP VIEW IF EXISTS customer_and_address;

CREATE VIEW customer_and_address
AS
SELECT c.customer_id
	, c.first_name
    , c.last_name
    , c.email
    , a.address
    , ci.city
    , a.district AS state
    , a.postal_code AS zip
    , co.country
    , a.phone
FROM customer AS c
INNER JOIN address AS a ON c.address_id = a.address_id
INNER JOIN city AS ci ON a.city_id = ci.city_id
INNER JOIN country as co ON ci.country_id = co.country_id;


DROP VIEW IF EXISTS customer_rental;

CREATE VIEW customer_rental
AS
SELECT r.rental_id
	, r.customer_id
    , f.film_id
    , f.title
    , f.rental_rate AS price
    , r.rental_date
    , r.return_date
FROM rental AS r 
INNER JOIN inventory AS i ON r.inventory_id = i.inventory_id
INNER JOIN film AS f ON i.film_id = f.film_id;




