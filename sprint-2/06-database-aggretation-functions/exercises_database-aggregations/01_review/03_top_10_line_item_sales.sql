-- 3. Display the
        -- product_name,
        -- sales_price,
        -- quantity,
        -- sub_total (price * qty)
        -- total_discount (sub_total * discount %)
        -- line_total (sub_total - discount amount)

-- Display the top 10 most expensive line items.
-- (Use the customer_orders View)


-- Order the results by line_total, highest first.
-- (10 rows)

USE northwind;

SELECT product_name
	, sales_price
    , quantity
    , sales_price * quantity AS sub_total
    , sales_price * quantity * discount AS total_discount
    , sales_price * quantity - sales_price * quantity * discount AS line_total
FROM customer_orders
ORDER BY line_total DESC
LIMIT 10;

