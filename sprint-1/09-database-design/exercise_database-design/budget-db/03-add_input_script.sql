USE budget;

-- NOTE: Before adding new payment, please check if person, vendor, subcategory, and category exists in the database. If it doesn't exist yet, please input them on the respective variables below.


-- ADD NEW PAYMENT to existing person, vendor in the database.
-- To add new payment, please replace values here:
SET @new_payment_date = '2024-08-02' -- FORMAT: YYYY-MM-DD
    , @new_payment_person_name = 'Anne' -- converts to person_id
    , @new_payment_vendor_name = 'Barnes and Noble' -- converts to vendor_id
	, @new_payment_amount = 75
    , @new_payment_notes = 'Database Design Book'
	;
-- --------------------------------- --
-- DO NOT EDIT BLOCK AFTER THIS LINE --
-- --------------------------------- --
-- Gets person_id from existing person_name provided
SELECT @person_id:= person_id
FROM person
WHERE person_name = @new_payment_person_name;
-- Gets vendor_id from existing vendor_name provided
SELECT @vendor_id:= vendor_id
FROM vendor
WHERE vendor_name = @new_payment_vendor_name;
-- Inserts new payment
INSERT INTO payments (payment_date, person_id, vendor_id, amount, notes)
VALUES (@new_payment_date, @person_id, @vendor_id, @new_payment_amount, @new_payment_notes);


-- ADD NEW PERSON
-- To add new person, please replace value here:
SET @new_person_name = 'Anne';
-- DO NOT EDIT BLOCK AFTER THIS LINE --
-- Inserts new person_name to person table
INSERT INTO person (person_name)
VALUES (@new_person_name);


-- ADD NEW CATEGORY
-- To add new category, please replace value here:
SET @new_category_name = 'Education';
-- DO NOT EDIT BLOCK AFTER THIS LINE --
-- Inserts new category_name to category table
INSERT INTO category (category_name)
VALUES (@new_category_name);


-- ADD NEW SUBCATEGORY (Existing category required. If new category, please add category to database first)
-- To add new payment, please replace values here:
SET @new_subcategory_name = 'Books'
	, @existing_category_name = 'Education';
-- --------------------------------- --
-- DO NOT EDIT BLOCK AFTER THIS LINE --
-- --------------------------------- --
-- Gets category_id of the existing category name provided
SELECT @category_id := category_id
FROM category
WHERE category_name = @existing_category_name;
-- Inserts new subcategory_name to subcategory table
INSERT INTO subcategory (subcategory_name, category_id)
VALUES (@new_subcategory_name, @category_id);


-- ADD NEW VENDOR (Existing category and subcategory required. If new category/subcategory, please add category/subcategory to database first)
-- To add new vendor, please replace values here:
SET @new_vendor_name = 'Barnes and Noble'
	, @existing_subcategory_name = 'Books';
-- --------------------------------- --
-- DO NOT EDIT BLOCK AFTER THIS LINE --
-- --------------------------------- --
-- Gets subcategory_id of the existing subcategory name provided
SELECT @subcategory_id := subcategory_id
FROM subcategory
WHERE subcategory_name = @existing_subcategory_name;
-- Inserts new vendor_name to vendor table
INSERT INTO vendor (vendor_name, subcategory_id)
VALUES (@new_vendor_name, @subcategory_id);


