-- 5. Using only sub queries, display the top 5 orders with the following information

-- order id
-- company name (or the customer)
-- the total sales amount  - line_item_total calculation -> unit_price * quantity * (1 - discount)

-- use the orders table as your base query
-- use a sub query to get the customer name
-- use a sub query to get the order sales amount

-- The first 5 rows should be
-- order_id     company_name			    sales_total
-- 10865        QUICK-Stop                  16387.5
-- 10981        Hanari Carnes               15810
-- 11030        Save-a-lot Markets          12615.05
-- 10889        Rattlesnake Canyon Grocery  11380
-- 10417        Simons bistro               11188.4


-- (top 5 rows)

USE northwind;


