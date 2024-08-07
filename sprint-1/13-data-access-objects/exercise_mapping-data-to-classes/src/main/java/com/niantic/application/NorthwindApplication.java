package com.niantic.application;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;

import java.util.Scanner;

import static java.util.FormatProcessor.FMT;

public class NorthwindApplication
{
    Scanner userInput = new Scanner(System.in);

    CategoryDao categoryDao = new CategoryDao();
    ProductDao productDao = new ProductDao();

    // <editor-fold desc="Home Page - Northwind Application">
    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayCategories();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Northwind!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
            }
        }

    }


    private int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Welcome to Northwind");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Manage Categories");
        System.out.println("  2) Manage Products");
        System.out.println("  0) Quit");
        System.out.println();

        return getUserInt("Enter your selection: ");
    }

    // </editor-fold>

    // <editor-fold desc="Categories">
    private void displayCategories()
    {
        while(true)
        {
            int choice = categoriesSelection();
            switch(choice)
            {
                case 1:
                    listCategories();
                    break;
                case 2:
                    categoryDetail();
                    break;
                case 3:
                    addCategory();
                    break;
                case 4:
                    updateCategory();
                    break;
                case 5:
                    deleteCategory();
                    break;
                case 0:
                    // go back to home screen
                    return;
                default:
                    System.out.println("That was an invalid selection, please select from the available options.");
            }
        }
    }

    private int categoriesSelection()
    {
        System.out.println();
        System.out.println("Categories");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) List All Categories");
        System.out.println("  2) Display Category Details");
        System.out.println("  3) Add Category");
        System.out.println("  4) Update Category");
        System.out.println("  5) Delete Category");
        System.out.println("  0) Back");
        System.out.println();

        return getUserInt("Enter your selection: ");
    }

    private void listCategories()
    {
        var categories = categoryDao.getCategories();

        System.out.println();
        System.out.println("All Categories");
        System.out.println("-".repeat(100));
        categories.forEach(System.out::println);

        waitForUser();
    }

    private void categoryDetail()
    {
        System.out.println();
        System.out.println("Category Details");
        System.out.println("-".repeat(100));
        int categoryId = getUserInt("Enter category id: ");
        System.out.println();

        var category = categoryDao.getCategoryById(categoryId);

        displayCategoryDetail(category);

        waitForUser();
    }

    private void displayCategoryDetail(Category category)
    {
        System.out.println(STR."Category ID:   \{category.getCategoryId()}");
        System.out.println(STR."Category Name: \{category.getCategoryName()}");
        System.out.println(STR."Desription:    \{category.getDescription()}");
    }

    private void addCategory()
    {
        System.out.println();
        System.out.println("Add Category");
        System.out.println("-".repeat(100));

        String categoryName = getUserString("Enter category name: ");
        String description = getUserString("Enter description: ");
        System.out.println();

        var category = new Category()
        {{
            setCategoryName(categoryName);
            setDescription(description);
        }};
        categoryDao.addCategory(category);

        System.out.println(STR."\{categoryName} has been added.");

        listCategories();

    }

    private void updateCategory()
    {
        System.out.println();
        System.out.println("Update Category");
        System.out.println("-".repeat(100));
        int categoryId = getUserInt("Enter category id: ");
        System.out.println();

        var category = categoryDao.getCategoryById(categoryId);

        // display current information
        System.out.println();
        System.out.println("Current Category Details");
        System.out.println("-".repeat(100));
        displayCategoryDetail(category);

        // get updated information
        System.out.println();
        System.out.println("Enter New Information");
        System.out.println("-".repeat(100));
        System.out.println("(Leave blank to remain unchanged)");

        // update category
        String categoryName = getUserString("Enter category name: ").strip();
        String description = getUserString("Enter description: ").strip();

        String newCategoryName = !categoryName.isEmpty() ? categoryName : category.getCategoryName();
        String newDescription = !description.isEmpty() ? description : category.getDescription();

        var newCategory = new Category(categoryId, newCategoryName, newDescription);
        categoryDao.updateCategory(newCategory);

        // display updated information
        var updatedCategory = categoryDao.getCategoryById(categoryId);
        System.out.println();
        System.out.println("**NEW** Category Details");
        System.out.println("-".repeat(100));
        displayCategoryDetail(updatedCategory);

        waitForUser();
    }

    private void deleteCategory()
    {
        System.out.println();
        System.out.println("Delete Category");
        System.out.println("-".repeat(100));
        int categoryId = getUserInt("Enter category id: ");
        System.out.println();

        var category = categoryDao.getCategoryById(categoryId);

        String choice = getUserString(STR."You are about to DELETE \{category.getCategoryName()}. This is a permanent action!\n\nDo you want to continue? (Y/N) ");

        if(choice.equalsIgnoreCase("y"))
        {
            try
            {
                categoryDao.deleteCategory(categoryId);
                System.out.println(STR."\{category.getCategoryName()} has been deleted.");
            }
            catch(Exception e)
            {
                System.out.println(STR."\{category.getCategoryName()} could not be deleted. There may still be products in this category.");
            }

            waitForUser();
        }
    }

    // </editor-fold>

    // <editor-fold desc="Products">
    private void displayProducts()
    {
        while(true)
        {
            int choice = productsSelection();
            switch(choice)
            {
                case 1:
                    listProducts();
                    break;
                case 2:
                    productDetail();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 0:
                    // go back to home screen
                    return;
                default:
                    System.out.println("That was an invalid selection, please select from the available options.");
            }
        }
    }

    private int productsSelection()
    {
        System.out.println();
        System.out.println("Products");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) List All Products by Category");
        System.out.println("  2) Display Product Details");
        System.out.println("  3) Add Product");
        System.out.println("  4) Update Product");
        System.out.println("  5) Delete Product");
        System.out.println("  0) Back");
        System.out.println();

        return getUserInt("Enter your selection: ");
    }

    private void listProducts()
    {
        System.out.println();
        System.out.println("Products by Category");
        System.out.println("-".repeat(100));
        int categoryId = getUserInt("Enter category id: ");
        System.out.println();

        var products = productDao.getProductsByCategory(categoryId);

        products.forEach(System.out::println);

        waitForUser();
    }

    private void productDetail()
    {
        System.out.println();
        System.out.println("Product Details");
        System.out.println("-".repeat(100));
        int productId = getUserInt("Enter product id: ");

        var product = productDao.getProduct(productId);
        displayProduct(product);

        waitForUser();
    }

    public void displayProduct(Product product)
    {
        System.out.println();
        System.out.println(STR."Product ID:      \{product.getProductId()}");
        System.out.println(STR."Product Name:    \{product.getProductName()}");
        System.out.println(STR."Package Size:    \{product.getQuantityPerUnit()}");
        System.out.println(FMT."Product Price:   $ %.2f\{product.getUnitPrice()}");
        System.out.println(STR."Units In Stock:  \{product.getUnitsInStock()}");
        System.out.println(STR."Units On Order:  \{product.getUnitsOnOrder()}");
        System.out.println(STR."ReOrder Level:   \{product.getReorderLevel()}");
    }

    private void addProduct()
    {
        System.out.println();
        System.out.println("Add Product");
        System.out.println("-".repeat(100));

        String productName = getUserString("Enter product name: ");
        int categoryId = getUserInt("Enter categoryId: ");
        String description = getUserString("Enter package size: ");
        double price = getUserDouble("Enter price: ");
        int unitsInStock = getUserInt("Enter units in stock: ");
        int unitsOnOrder = getUserInt("Enter units on order: ");
        int reorderLevel = getUserInt("Enter reorder level: ");

        System.out.println();

        var product = new Product()
        {{
            setProductName(productName);
            setCategoryId(categoryId);
            setQuantityPerUnit(description);
            setUnitPrice(price);
            setUnitsInStock(unitsInStock);
            setUnitsOnOrder(unitsOnOrder);
            setReorderLevel(reorderLevel);
        }};

        try
        {
            productDao.addProduct(product);

            System.out.println(STR."\{productName} has been added.");

            var products = productDao.getProductsByCategory(categoryId);

            System.out.println("-".repeat(100));
            products.forEach(System.out::println);

        }
        catch (Exception e)
        {
            System.out.println(STR."There was a problem adding \{productName}.");
        }

        waitForUser();
    }

    private void updateProduct()
    {
        System.out.println();
        System.out.println("Update Product");
        System.out.println("-".repeat(100));
        int productId = getUserInt("Enter product id: ");
        System.out.println();

        // find and display current product
        System.out.println("Current Product Details");
        System.out.println("-".repeat(100));
        var product = productDao.getProduct(productId);
        displayProduct(product);

        // get new product info
        System.out.println();
        System.out.println("Enter Updated Product Information");
        System.out.println("-".repeat(100));
        System.out.println("(Leave blank to remain unchanged)");

        String productName = getUserString("Enter product name: ");
        String categoryId = getUserString("Enter categoryId: ");
        String quantityPerUnit = getUserString("Enter package size: ");
        String price = getUserString("Enter price: ");
        String unitsInStock = getUserString("Enter units in stock: ");
        String unitsOnOrder = getUserString("Enter units on order: ");
        String reorderLevel = getUserString("Enter reorder level: ");

        String newProductName = !productName.isEmpty() ? productName : product.getProductName();
        int newCategoryId = !categoryId.isEmpty() ? Integer.parseInt(categoryId) : product.getCategoryId();
        String newQuantityPerUnit = !quantityPerUnit.isEmpty() ? quantityPerUnit : product.getQuantityPerUnit();
        double newPrice = !price.isEmpty() ? Double.parseDouble(price) : product.getUnitPrice();
        int newUnitsInStock = !unitsInStock.isEmpty() ? Integer.parseInt(unitsInStock) : product.getUnitsInStock();
        int newUnitsOnOrder = !unitsOnOrder.isEmpty() ? Integer.parseInt(unitsOnOrder) : product.getUnitsOnOrder();
        int newReorderLevel = !reorderLevel.isEmpty() ? Integer.parseInt(reorderLevel) : product.getReorderLevel();

        var updatedProduct = new Product(){{
            setProductId(productId);
            setProductName(newProductName);
            setCategoryId(newCategoryId);
            setQuantityPerUnit(newQuantityPerUnit);
            setUnitPrice(newPrice);
            setUnitsInStock(newUnitsInStock);
            setUnitsOnOrder(newUnitsOnOrder);
            setReorderLevel(newReorderLevel);
        }};

        try
        {
            productDao.updateProduct(updatedProduct);

            System.out.println(STR."\{newProductName} has been successfully updated.");
            System.out.println("-".repeat(100));
            displayProduct(updatedProduct);
        }
        catch (Exception e)
        {
            System.out.println(STR."There was an error updating \{product.getProductName()}");
        }

        waitForUser();
    }

    private void deleteProduct()
    {
        System.out.println();
        System.out.println("Delete Product");
        System.out.println("-".repeat(100));
        int productId = getUserInt("Enter product id: ");
        System.out.println();

        var product = productDao.getProduct(productId);
        String choice = getUserString(STR."You are about to DELETE \{product.getProductName()}. This is a permanent action.\n\nDo you want to continue? (Y/N) ");

        if(choice.equalsIgnoreCase("y"))
        {
            try
            {
                productDao.deleteProduct(productId);

                System.out.println(STR."\{product.getProductName()} has been deleted.");
            }
            catch(Exception e)
            {
                System.out.println(STR."\{product.getProductName()} could not be deleted.");
            }

            waitForUser();
        }
    }

    // </editor-fold>

    // <editor-fold desc="Helpers">

    private void waitForUser()
    {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        userInput.nextLine();
    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine();
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    private double getUserDouble(String message)
    {
        return Double.parseDouble(getUserString(message));
    }

    // </editor-fold>
}
