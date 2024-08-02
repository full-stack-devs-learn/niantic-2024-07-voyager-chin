USE budget;

-- ------------------------------- --
-- REPORTS: FINANCIAL TRANSACTIONS --
-- ------------------------------- --


-- --------------------------------------------------- --
-- ------------ ALL CATEGORIES - by Month ------------ --
-- To select month, please input with FORMAT: YYYY-MM:
SET @selected_month = '2024-05';

-- Do not edit the block after this line --
SELECT category.category_name
	, SUM(payments.amount) AS category_total
FROM payments
JOIN vendor ON payments.vendor_id = vendor.vendor_id
JOIN subcategory ON vendor.subcategory_id = subcategory.subcategory_id
JOIN category ON subcategory.category_id = category.category_id
WHERE payment_date LIKE CONCAT(@selected_month, '%')
GROUP BY category.category_id, category.category_name;
-- --------------------------------------------------- --


-- --------------------------------------------------- --
-- ----------- SELECTED CATEGORY - by Month----------- --
-- To select category, please replace the value below:
SET @selected_category_name = 'Housing';
-- To select month, please input with FORMAT: YYYY-MM:
SET @selected_month = '2024-05'; 

-- Do not edit the block after this line --
-- Converts category_name to category_id
SELECT @selected_category_id := category_id
FROM category
WHERE category_name = @selected_category_name;
-- Displays the subcategory list and subcategory total of the selected category
SELECT subcategory.subcategory_name
	, SUM(payments.amount) AS subcategory_total
FROM payments
JOIN vendor ON payments.vendor_id = vendor.vendor_id
JOIN subcategory ON vendor.subcategory_id = subcategory.subcategory_id
JOIN category ON subcategory.category_id = category.category_id
WHERE payment_date LIKE CONCAT(@selected_month, '%') AND category.category_id = @selected_category_id 
GROUP BY subcategory.subcategory_id, subcategory.subcategory_name;
-- --------------------------------------------------- --