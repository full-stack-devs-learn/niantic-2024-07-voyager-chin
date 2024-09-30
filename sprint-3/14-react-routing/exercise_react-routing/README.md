# Exercise - Working with Routes in React

In this exercise you will create a new React project that uses Routing, instead of state management to navigate between pages.

The goal of this exercise is to get you comfortable working with creating Routes, and using the browsers URL and navigation history to navigage between pages.

You will also pass information using URL path and query string parameters.

## Step 1 - Create the Project

Create a new project for Northwind Traders. You will use this project to practice navigating between pages.

* Add a dependency to your favorite bootstrap theme.
* Add a Header component that will allow you to navigate between pages
* Create components to meet the following site structure

```bash
HomePage                http://localhost:8080
CategoriesPage          
    - CategoriesList    http://localhost:8080/categories 
      default view
    - CategoryDetails   http://localhost:8080/categories/3
    - CategoryAdd       http://localhost:8080/categories/add
    - CategoryEdit      http://localhost:8080/categories/3/edit
ProductPage
    - ProductSearch     http://localhost:8080/products?minPrice=5&maxPrice=20&name=chai&catId=1
    - ProductDetails    http://localhost:8080/products/32
    - ProductAdd        http://localhost:8080/products/add
    - ProductEdit       http://localhost:8080/products/32/edit
```

## Step 2 - Add Routing logic

Import the React routing dependency

```bash
npm install react-router-dom
```

* Add routes to the `App.tsx`
* Add `Link`s to the Header navigation
* Add the necessary logic to read the Path and QueryString values on the pages that need those values


## Optional/Challenge - Add Services to call APIs

Use code from previous exercises to add services to your project. Call the Northwind API to get the category and product data, and display it on the pages.