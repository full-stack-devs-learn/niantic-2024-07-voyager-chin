# Exercise - Using React Hooks

In this exercise you will work with the Existing Northwind React Project.

## Step 1 - Display all products in the Products Page

This page structure should be similar to the CategoriesPage. You will display all products
in a card or list format. The product information should come from the NorthwindAPI

* Create a ProductService.js file in the services folder
* Create a getAllProducts method that calls the Northwind API
* Add the required new React Components in the `components/products` folder
    * `ProductCardContainer`
    * `ProductCard`
* Add the ProductCardContainer to the ProductsPage
* In the `ProductCardContainer` add logic to get all products from the productService
    * Use `useState` to store the array of products
    * Use `useEffect` to make the api call

## Optional: Step 2 - Create an Add Product Component

We need the ability to add new products to our database. You will create a component
that allows users to add product information and save it to the database.

Add the component to the `ProductsPage`.

* Create the ProductAdd component
* Add it to the ProductsPage
* Use state to show/hide the product list and product add components 
    * only one of the components should be visible at a time
* After the product is added, hide the ProductAdd component and refresh the list

## Optional: Step 3 - Delete Product

Each product card should have a delete icon. When the user clicks the delete icon
the productService.delete(productId) should be called and the product should be 
deleted from the database.

* Use a ReactBootstrapIcon to display a delete button
* the Click event should trigger a call to the API
* The ProductCardContainer should be updated to remove the deleted product


## OPTIONAL: Step 4 - Display Products for the Selected Category on the Categories Page

* Create a getProductByCategoryId method in the productService
* Update the ProductsList component to display a list of products for the 
  selected category Id
    * You can choose to use the ProductCard component to display the filtered list
      if you want, or you can display a simple list of product names only


