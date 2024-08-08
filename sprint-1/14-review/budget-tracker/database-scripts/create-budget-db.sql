DROP DATABASE IF EXISTS budget;

CREATE DATABASE budget;

USE budget;

-- create tables
CREATE TABLE categories (
    category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(200) NOT NULL,
    description TEXT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE sub_categories (
    sub_category_id INT NOT NULL AUTO_INCREMENT,
    category_id INT NOT NULL,
    sub_category_name VARCHAR(200) NOT NULL,
    description TEXT NULL,
    PRIMARY KEY (sub_category_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NULL,
    email VARCHAR(250) NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE vendors (
    vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(200) NOT NULL,
    website VARCHAR(2000) NULL,
    PRIMARY KEY (vendor_id)
);

CREATE TABLE transactions (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    sub_category_id INT NOT NULL,
    vendor_id INT NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    notes TEXT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (sub_category_id) REFERENCES sub_categories (sub_category_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id)
);

INSERT INTO categories (category_id, category_name, description)
VALUES (1, 'Housing', 'Rent or mortgage payments, property taxes, home insurance, and maintenance')
	 , (2, 'Utilities', 'Electricity, water, gas, trash collection, and internet services')
	 , (3, 'Groceries', 'Monthly expenditure on food and household supplies')
	 , (4, 'Transportation', 'Expenses related to commuting, car payments, fuel, maintenance, public transit, and insurance')
	 , (5, 'Healthcare', 'Medical expenses, insurance premiums, medications, and doctor visits')
	 , (6, 'Entertainment', 'Costs for movies, dining out, hobbies, events, and recreational activities')
	 , (7, 'Clothing', 'Purchases of clothing, shoes, and accessories')
	 , (8, 'Education', 'Tuition fees, books, school supplies, and educational courses')
	 , (9, 'Savings', 'Monthly savings, emergency funds, and investments')
	 , (10, 'Debt Repayment', 'Payments towards credit cards, loans, and other debts')
	 , (11, 'Gifts and Donations', 'Money spent on gifts and charitable contributions')
	 , (12, 'Miscellaneous', 'Other expenses that do not fit into the above categories');
    
INSERT INTO sub_categories (category_id, sub_category_name)
VALUES (1, 'Rent')
	 , (1, 'Mortgage')
     , (1, 'Property Taxes')
     , (1, 'Home Improvement')
     , (1, 'Yard Care')
     , (2, 'Power')
     , (2, 'Water')
     , (2, 'Trash')
     , (2, 'Internet')
     , (3, 'Produce')
     , (3, 'Snacks')
     , (3, 'Dairy')
     , (3, 'Meats')
     , (3, 'Baked Goods')
     , (4, 'Car Payment')
     , (4, 'Gas')
     , (4, 'Car Repair')
     , (4, 'Car Insurance')
     , (5, 'Dr Visit')
     , (5, 'Prescriptions')
     , (5, 'HSA Payment')
     , (5, 'Health Insurance')
     , (6, 'Movie')
     , (6, 'Dining Out')
     , (6, 'Date Night')
     , (6, 'Recreation')
     , (7, 'Casual Clothes')
     , (7, 'Shoes')
     , (7, 'Hats')
     , (7, 'Swimwear')
     , (7, 'Formalwear')
     , (8, 'Tuition')
     , (8, 'Books')
     , (8, 'School Supplies')
     , (9, 'Retirement')
     , (9, 'Emergency Fund')
     , (9, 'Home Repairs')
     , (10, 'Credit Card Payment')
     , (10, 'Loan Payment')
     , (11, 'Gifts')
     , (11, 'Charitable Donation')
     , (12, 'Miscellaneous');
    
INSERT INTO users (user_id, user_name, first_name, last_name, phone, email)
VALUES (1001, 'john.doe', 'John', 'Doe', '234-567-8901', 'john.doe@email.com')
	 , (1002, 'jane.smith', 'Jane', 'Smith', '345-678-9012', 'jane.smith@email.com')
	 , (1003, 'michael.johnson', 'Michael', 'Johnson', '456-789-0123', 'michael.johnson@email.com')
	 , (1004, 'emily.davis', 'Emily', 'Davis', '567-890-1234', 'emily.davis@email.com')
	 , (1005, 'david.wilson', 'David', 'Wilson', '678-901-2345', 'david.wilson@email.com')
	 , (1006, 'sarah.brown', 'Sarah', 'Brown', '789-012-3456', 'sarah.brown@email.com')
	 , (1007, 'james.taylor', 'James', 'Taylor', '890-123-4567', 'james.taylor@email.com')
	 , (1008, 'laura.anderson', 'Laura', 'Anderson', '901-234-5678', 'laura.anderson@email.com')
	 , (1009, 'chris.thomas', 'Chris', 'Thomas', '312-345-6789', 'chris.thomas@email.com')
	 , (1010, 'amanda.lee', 'Amanda', 'Lee', '123-456-7890', 'amanda.lee@email.com');
     
INSERT INTO vendors (vendor_name, website)
VALUES ('Amazon', 'www.amazon.com')
	 , ('Home Depot', 'www.homedepot.com')
     , ('Chevron', '')
     , ('JP Morgan Chase', 'www.jpmorganchase.com')
     , ('American Red Cross', '')
     , ('Rocky Mountain Power', '')
     , ('Albertsons', '')
     , ('Ralphs Food and Drug', '')
     , ('Walmart', 'www.walmart.com')
     , ('Target', 'www.target.com')
     , ('Costco', 'www.costco.com')
     , ('Foothills Property Management', 'www.foothills-rentals.com')
     , ('Intermountain Health Care', 'www.ihc.com')
     , ('Ford Finance', 'finance.ford.com')
     , ('University of California, Berkeley', 'www.berkeley.edu')
     , ('University of Washington', 'www.washington.edu')
     , ('University of Utah', 'www.utah.edu')
     , ('Bank of America', 'www.bankofamerica.com')
     , ('O''Reilley Auto Parts', 'www.oreillyauto.com')
     , ('XFinity', 'www.xfinity.com')
     ;
     
INSERT INTO transactions (user_id, sub_category_id, vendor_id, transaction_date, amount, notes)
VALUES (1003, 2, 4, '2024-01-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-02-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-03-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-04-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-05-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-06-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-07-05', 2453.87, 'house payment')
	 , (1003, 2, 4, '2024-08-05', 2453.87, 'house payment')
     -- internet
	 , (1003, 2, 20, '2024-01-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-02-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-03-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-04-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-05-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-06-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-07-02', 109.99, 'internet')
	 , (1003, 2, 20, '2024-08-02', 109.99, 'internet')
	 -- groceries
	 , (1008, 2, 7, '2024-01-02', 151.25, 'groceries')
	 , (1005, 2, 8, '2024-01-09', 123.45, 'groceries')
	 , (1008, 2, 7, '2024-01-16', 101.00, 'groceries')
	 , (1005, 2, 8, '2024-01-23', 203.56, 'groceries')
	 , (1006, 2, 8, '2024-02-02', 151.25, 'groceries')
	 , (1003, 2, 7, '2024-02-09', 123.45, 'groceries')
	 , (1004, 2, 8, '2024-02-16', 101.00, 'groceries')
	 , (1008, 2, 7, '2024-02-23', 203.56, 'groceries')
	 , (1008, 2, 8, '2024-03-02', 151.25, 'groceries')
	 , (1003, 2, 8, '2024-03-09', 123.45, 'groceries')
	 , (1006, 2, 8, '2024-03-16', 101.00, 'groceries')
	 , (1006, 2, 7, '2024-03-23', 203.56, 'groceries')
	 , (1008, 2, 7, '2024-04-02', 151.25, 'groceries')
	 , (1008, 2, 8, '2024-04-09', 123.45, 'groceries')
	 , (1007, 2, 7, '2024-04-16', 101.00, 'groceries')
	 , (1007, 2, 7, '2024-04-23', 203.56, 'groceries')
	 , (1005, 2, 7, '2024-05-02', 151.25, 'groceries')
	 , (1006, 2, 8, '2024-05-09', 123.45, 'groceries')
	 , (1008, 2, 8, '2024-05-16', 101.00, 'groceries')
	 , (1008, 2, 7, '2024-05-23', 203.56, 'groceries')
	 , (1010, 2, 8, '2024-06-02', 151.25, 'groceries')
	 , (1009, 2, 8, '2024-06-09', 123.45, 'groceries')
	 , (1009, 2, 7, '2024-06-16', 101.00, 'groceries')
	 , (1010, 2, 8, '2024-06-23', 203.56, 'groceries')
	 , (1010, 2, 7, '2024-07-02', 151.25, 'groceries')
	 , (1008, 2, 8, '2024-07-09', 123.45, 'groceries')
	 , (1007, 2, 8, '2024-07-16', 101.00, 'groceries')
	 , (1009, 2, 8, '2024-07-23', 203.56, 'groceries')
	 , (1010, 2, 7, '2024-08-02', 151.25, 'groceries');
