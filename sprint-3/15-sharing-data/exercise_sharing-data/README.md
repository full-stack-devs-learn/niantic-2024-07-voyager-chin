# Exercise - Sharing Data Between Components

## NOTE
**If you have completed these steps, or are tired of working with the Northwind 
project, you could choose to modify your SWAPI or Pokemon project instead**


This exercise is a continuation of yesterday's exercise, which was
navigating through pages with Routing.

You will add services for categories and products and use those services
to provide the data for your components.

You are not required to use Context or REDUX for this assignment, the 
primary concern is to create service classes that pull data from APIs.

(If you have already completed this exercise, you may want to try to 
implement Context or REDUX in your project)

## Step 1 - Add a Categories Service

Create a new categories service (or pull one from a previous project).
Use axios to call your northwind server api.

Modify your category components to pull data from the API and display
it on the appropriate pages.

```bash
HomePage                http://localhost:8080
CategoriesPage          
    - CategoriesList    http://localhost:8080/categories 
      default view
    - CategoryDetails   http://localhost:8080/categories/3
    - CategoryAdd       http://localhost:8080/categories/add
    - CategoryEdit      http://localhost:8080/categories/3/edit
```

## Step 2 - Add a Products Service

Create a new products service (or pull one from a previous project).
Use axios to call your northwind server api.

Modify your product components to pull data from the API and display it
on the appropriate pages.

```bash
ProductPage
    - ProductSearch     http://localhost:8080/products?minPrice=5&maxPrice=20&name=chai&catId=1
    - ProductDetails    http://localhost:8080/products/32
    - ProductAdd        http://localhost:8080/products/add
    - ProductEdit       http://localhost:8080/products/32/edit
```

