USE northwind;

-- CTE = Common Table Expression
-- or Named Query
WITH orders_2 AS (
     SELECT innerO.order_id
          , od.product_id
          , innerO.customer_id
          , od.unit_price
          , od.quantity
     FROM orders AS innerO
     INNER JOIN order_details AS od ON innerO.order_id = od.order_id
 ), category_products AS (
      SELECT innerP.product_id
           , innerP.product_name
           , c.category_name
      FROM products AS innerP
      INNER JOIN categories AS c ON innerP.category_id = c.category_id
), beverages AS (
    SELECT *
    FROM category_products
    WHERE category_name = 'Beverages'
)
SELECT c.company_name
    , o.*
    , p.*
FROM customers AS c
INNER JOIN orders_2 AS o on c.customer_id = o.customer_id
INNER JOIN beverages as p ON o.product_id = p.product_id;




       

