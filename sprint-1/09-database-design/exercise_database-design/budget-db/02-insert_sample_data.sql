USE budget;

-- ------------- --
-- ADD SEED DATA --
-- ------------- --

-- Category Table Data
INSERT INTO category(category_name)
VALUES ('Entertainment')
	, ('Food')
    , ('Healthcare')
    , ('Housing')
    , ('Transportation')
    , ('Vacation/Travel')
    ;
 
-- Subcategory Table Data  
INSERT INTO subcategory(subcategory_name, category_id)
VALUES ('Car Maintenance', 5)
	, ('Car Rental', 6)
    , ('Dr Visit', 3)
    , ('Flight', 6)
    , ('Gas', 5)
    , ('Groceries', 2)
    , ('Hotel', 6)
    , ('Internet', 4)
    , ('Movies', 1)
    , ('Netflix', 1)
    , ('OTC Medicine', 3)
    , ('Rent', 4)
    , ('Restaurant', 2)
    , ('Rx', 3)
    , ('Snacks', 2)
    , ('Sports', 1)
    , ('Subway', 5)
    , ('Utilities', 4)
    ;

-- Vendor Table Data 
INSERT INTO vendor(vendor_name, subcategory_id)
VALUES ('Autoworks', 1)
	, ('Cinemax Theater', 9)
    , ('CVS Pharmacy', 3)
    , ('Delta Airlines', 4)
    , ('Farmer''s Market', 6)
    , ('FastNet', 8)
    , ('Fresh Mart', 6)
    , ('HealthFirst Clinic', 3)
    , ('Joe''s Diner', 13)
    , ('Landlord Inc.', 12)
    , ('Metro Transit', 17)
    , ('Netflix', 10)
    , ('Oceanfront Resort', 7)
    , ('Pharmax', 11)
    , ('PowerCo', 18)
    , ('Shell Gas Station', 5)
    , ('Snack Haven', 15)
    , ('Sports Arena', 16)
    , ('WaterWorks', 18)
    , ('Zoom Car Rentals', 2)
    ;


-- Person Table Data
INSERT INTO person (person_name)
VALUES ('John'), ('Sarah');

-- Payments Table Data
INSERT INTO payments (payment_date, person_id, vendor_id, amount, notes)
VALUES ('2024-05-04', 1, 1, 100, 'Car oil change')
	, ('2024-05-10', 1, 2, 30, 'Movie night out')
    , ('2024-05-07', 2, 3, 20, 'Prescription refill')
    , ('2024-05-12', 2, 4, 300, 'Booked flight for upcoming trip')
    , ('2024-05-26', 2, 5, 80, 'Fresh produce and groceries')
    , ('2024-05-30', 1, 6, 60, 'Internet service provider bill')
    , ('2024-05-05', 1, 7, 150, 'Weekly grocery shopping')
    , ('2024-05-22', 2, 8, 50, 'Routine check-up')
    , ('2024-05-20', 1, 9, 25, 'Dinner with friends')
    , ('2024-05-01', 1, 10, 1200, 'Monthly rent payment')
    , ('2024-05-17', 2, 11, 20, 'Monthly subway pass')
    , ('2024-05-25', 1, 12, 15, 'Monthly subscription fee')
    , ('2024-05-28', 2, 13, 200, 'Hotel booking for vacation')
    , ('2024-05-14', 1, 14, 15, 'Cold medicine')
    , ('2024-05-15', 1, 15, 100, 'Electricity bill payment')
    , ('2024-05-03', 2, 16, 40, 'Filled up the car''s tank')
    , ('2024-05-09', 2, 17, 10, 'Snacks for movie night')
    , ('2024-05-18', 2, 18, 50, 'Tickets to a baseball game')
    , ('2024-05-01', 2, 19, 50, 'Water bill payment')
    , ('2024-05-23', 1, 20, 150, 'Rental car for trip')
    ;