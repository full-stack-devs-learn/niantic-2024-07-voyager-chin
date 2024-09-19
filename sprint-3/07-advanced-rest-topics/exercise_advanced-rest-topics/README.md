# Advanced REST API Topics

In this exercise, you will modify your Northwind API to add advanced API programming concepts to your project.

## Learning objectives

After completing this exercise, you'll understand how to:

* Return custom status codes to the API client, and hide internal error messages from end users.

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* The Products Controller should return the appropriate http status codes for each request type.

## Getting started

1. Continue working on the `exercise_rest-api` project in IntelliJ.


# Exercises

## 1: Create a Student Summary Report

Update your ProductsController to return `ResponseEntity<?>` for each request.

* GET list by category id 
  - add a try/catch block and return a ResponseEntity.ok(products) for the products if they are found
  - use a CategoryDao to find a category by id, if the category does not exist you should return a 404 - not found
  - if an exception is caught you should return a 500 internal server error - be sure not to include any internal error information
* GET product by id
  - return OK (200) if all goes well
  - return 404 if the product id does not exist
  - return 500 if there is an error with the DAO execution
* POST new product
  - return Created (201) if all goes well
  - return 500 if there is an error with the insertion
* PUT to update an existing product
  - return No Content (204) if the update was successful
  - return 404 if the product id being updated does not exist
  - return 500 if there is an error with the update
* DELETE to delete an existing product
  - return No Content (204) if the delete was successful
  - return 404 if the product id does not exist
  - return 500 if there is an error deleting the product

## 2: Optional / Challenge: Add a global exeption handler

If a user requests a resource that does not exist, or if any other execption occurs
you should return a generic error message with out giving details about the internal error.

Use the demo code as a guide:
* A resource not found exception should return a 404 status code
* Any other error should return a 500 status


## 3: Optional / Challenge: Add Dependency Injection to the project

Modify the database connection string in the `src/main/resources/application.properties` file to point to the `northwind` database.

* Annotate the MySqlProductsDao with the `@Repository` annotation to registerit as a Spring Bean
  * Autuwire the constructor and accept a DataSource object as a parameter
  * Use the injected DataSource to create the jdbcTemplate object.
* Modify the `ProductsController` to `@Autowire` the `ProductsDao` in the constructor.
* Update the MySqlCategoriesDao to register it as a Spring Bean
* Update the CategoriesController to autowire and inject the DategoriesDao in the constructor.




