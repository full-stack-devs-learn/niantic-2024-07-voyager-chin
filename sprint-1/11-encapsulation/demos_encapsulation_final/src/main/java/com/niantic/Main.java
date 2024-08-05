package com.niantic;

import com.niantic.northwind_models.Category;

public class Main
{
    public static void main(String[] args)
    {

        // example of how variables are named
        String name = new String("Gregor");


        // Category = the datatype of the variable
        //       category = the variable name
        //                      Category() = the construction of the object
        // constructor 1 create object without initial values
        Category category = new Category();

        category.setId(1);
        category.setName("Beverages");
        category.setDescription("Anything related to drinks.");

        System.out.println(category.getId());
        System.out.println(category.getName());
        System.out.println(category.getDescription());

        // constructor 2 creates object with initial values
        category = new Category(2, "Condiments", "Sugar rush");

        System.out.println();
        System.out.println(category.getId());
        System.out.println(category.getName());
        System.out.println(category.getDescription());

    }
}