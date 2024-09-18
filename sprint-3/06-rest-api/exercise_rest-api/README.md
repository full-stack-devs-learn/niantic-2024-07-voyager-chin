# FileIO Writing to Files

In this exercise, you will build API controllers for the Northwind Traders company.

## Learning objectives

After completing this exercise, you'll understand how to:

* Create a RESTful API
* Respond to GET requests
* Respond to POST request to add data to a database
* Respond to PUT requests to update the database
* Respond to DELETE requests to delete a record from the database

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* You must have a functioning ProductController and ProductDao
  * GET requests should pull information from the database
  * POST requests should add new products from the database
  * PUT requests should update a product in the database
  * DELETE requests should delete a product from the database

## Getting started

1. Review the starter code which includes the following classes
   * Category model
   * CategoryDao interface
   * MySqlCategoryDao class (implements the CategoryDao interface)
   * CategoriesController REST controller
2. Use the starter code as a template to help build your classes


# Exercise 1

## Step 1: Create a ProductsController

First Create all of the classes that you will need for this exercise. You do not need to 
create the methods or any of the implementation code yet, just create
the classes that you will modify as you complete the exercises

* `Product` model
* `ProductDao` interface
* `MySqlProductDao` class
* `ProductsController` REST controller

Rather than writing all of the code for each class one class at a time, you should
write only the code that you need for each step. This means that you
will update multiple files in each step.

## Step 2: Add the @GetMapping for `getProductsByCategory`

Add the code necessary to allow users to search for products by the category id.

The url for the API should be `http://localhost:8080/api/products?catId=1`

* Product model - add all of the fields, constructors, and getters/setters for the product information
* ProductDao - define a method named `getProductsByCategory(int categoryId)`
* `MySqlProductsDao` - implement the `getProductsByCategory(int categoryId)` method
  * You will need to add a constructor to the DAO to create a BasicDataSource and initialize the JdbcTemplate
* `ProductsController` - add the `@GetMapping` to match the url specified

## Step 3: Add the @GetMapping for `getProductById`

Add the code necessary to allow users to get a product by Id.

The url for the API should be `http://localhost:8080/api/products/35` (with the id number being changeable)

Update each of the files as necessary to complete this step

## Step 4: Add the @PostMapping for `addProduct`

Add the code necessary to allow users to add a new product.

The url for the API should be `http://localhost:8080/api/products` 

Update each of the files as necessary to complete this step - remember that 
the post mapping should return the new product that was added to the database.

## Step 5: Add the @PutMapping for `updateProduct`

Add the code necessary to allow users to update a product by id.

The url for the API should be `http://localhost:8080/api/products/35` (with the id number being changeable)

Update each of the files as necessary to complete this step - remember that
the post mapping should return the new product that was added to the database.

## Step 5: Add the @DeleteMapping for `deleteProduct`

Add the code necessary to allow users to delete a product by id.

The url for the API should be `http://localhost:8080/api/products/35` (with the id number being changeable)

Update each of the files as necessary to complete this step - remember that
the post mapping should return the new product that was added to the database.


# Exercise 2: Challenge / Optional - Extra Practice

## Challenge: Add an EmployeesController

Add a REST controller to allow users to search, add, edit and delete employees. Create all the files
necessary for the CRUD operations.

* GET - list/search
* GET - get by id
* POST - add
* PUT - update by id
* DELETE - delete by id




