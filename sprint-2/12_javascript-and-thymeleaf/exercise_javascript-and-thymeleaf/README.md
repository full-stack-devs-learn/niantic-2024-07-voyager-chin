# JavaScript with Spring Boot and Thymeleaf

In this chapter you learned how to use JavaScript to enhance MVC web applications.

## Learning objectives

After completing this exercise, you'll understand:

* How to use JavaScript fetch() method to call web page fragments
* How to load data from a web request
* How to validate form data before submitting to the server


## Getting started

1. Run the application and navigate to the `/products` page
2. Modify the `ProductsController` and the `products/index.html` page. 
   * The page should not load the products by default
   * Add a GetMapping handler that accepts a category id - and load all products for the selected category
3. Create a ThymeLeaf fragment html page and use ThymeLeaf syntax to dynamically build the product rows
4. Using a JavaScript change event on the dropdown select list
   * Use the JavaScript `fetch()` method to load the data from the new GetMapping
   * Display all products
5. Add form validation to the add products page.

## Optional / Challenge

1. Create a new `ProductApiController` and annotate it with `@RestContoller`.
2. Add a GetMapping to retrieve all products for a specific categoryId.
3. Instead of returning the ThymeLeaf formatted page, return the `ArrayList<Product>` list
4. Modify the JavaScript to read the returned JSON data and build the HTML in the browser.




