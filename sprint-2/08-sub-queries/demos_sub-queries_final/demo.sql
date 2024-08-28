USE chores;

-- using sub-queries in select columns
SELECT person_name
     , (
           SELECT task_name
           FROM task AS t
           WHERE t.person_id = p.person_id
       ) AS task
FROM person AS p;

-- if you want 2 values from the same table
-- you need 2 sub-queries (maybe a join is better)
SELECT person_name
     , (
           SELECT task_name
           FROM task AS t
           WHERE t.person_id = p.person_id
       ) AS task
     , (
           SELECT task_id
           FROM task AS t
           WHERE t.person_id = p.person_id
       ) AS task_id
FROM person AS p;


USE northwind;

SELECT product_name
     , unit_price
FROM products
WHERE category_id = (
                        SELECT category_id
                        FROM categories
                        WHERE category_name = 'Dairy Products'
                    );


-- All customerids for canada customers

SELECT customer_id
FROM customers
WHERE country = 'USA';

SELECT order_id
     , order_date
FROM orders
WHERE customer_id = 'BOTTM'
   OR customer_id = 'LAUGB'
   OR customer_id = 'MEREP';


SELECT order_id
     , order_date
FROM orders
WHERE customer_id IN (
                         SELECT customer_id
                         FROM customers
                         WHERE country = 'Sweden'
                     );

SELECT order_id
     , order_date
FROM orders AS o
WHERE EXISTS (
                 SELECT *
                 FROM customers AS c
                 WHERE c.country = 'SWEDEN'
                   AND c.customer_id = o.customer_id
             );


-- Queries that REQUIRE a sub-query
-- all products that are MORE expensive than the average -in each category
-- 1. I need to find the avg price
-- 2. use the avg price as a subquery to help filter products by price

SELECT p.product_name
     , p.category_id
     , p.unit_price
     , average_price
FROM products AS p
INNER JOIN (
               SELECT category_id
                    , AVG(unit_price) AS average_price
               FROM products
               GROUP BY category_id
           ) AS average_prices ON p.category_id = average_prices.category_id
WHERE p.unit_price > average_prices.average_price
;


-- show my all prodcuts compared to the average price per category

SELECT p.product_name
     , p.category_id
     , p.unit_price
     , average_price
     , p.unit_price - average_price as difference
     , CASE
         WHEN unit_price - average_price > 100 THEN 'EXTREMELY HIGH'
         WHEN unit_price - average_price > 10 THEN 'HIGH'
         WHEN unit_price - average_price > -10 THEN 'AVERAGE'
         ELSE 'LOW'
    END AS diff
FROM products AS p
INNER JOIN (
               SELECT category_id
                    , AVG(unit_price) AS average_price
               FROM products
               GROUP BY category_id
           ) AS average_prices ON p.category_id = average_prices.category_id
;



-- ADVANCED TOPIC
-- breaking a large query into sub-queries
SELECT c.company_name
     , outerO.*
     , outerP.*
FROM customers AS c
INNER JOIN (
               SELECT innerO.order_id
                    , od.product_id
                    , innerO.customer_id
                    , od.unit_price
                    , od.quantity
               FROM orders AS innerO
               INNER JOIN order_details AS od ON innerO.order_id = od.order_id
           ) AS outerO ON c.customer_id = outerO.customer_id
INNER JOIN (
               SELECT innerP.product_id
                    , innerP.product_name
                    , c.category_name
               FROM products AS innerP
               INNER JOIN categories AS c ON innerP.category_id = c.category_id
           ) AS outerP ON outerO.product_id = outerP.product_id;



       

