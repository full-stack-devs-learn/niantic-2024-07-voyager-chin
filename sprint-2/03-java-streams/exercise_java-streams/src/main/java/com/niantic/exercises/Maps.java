package com.niantic.exercises;

import com.niantic.models.LineItem;

import java.util.ArrayList;
import java.util.List;

public class Maps
{

    /*
    1) using a chain of Java Stream functions, convert the list of line items to
       a list of company names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by company name

     */
    public List<String> mapCompanyNames(List<LineItem> lineItems)
    {
        return new ArrayList<>();
    }

    /*
    2) using a chain of Java Stream functions, convert the list of line items to
       a list of category names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by category name

     */
    public List<String> mapCategories(List<LineItem> lineItems)
    {
        return new ArrayList<>();
    }

    /*
    3) using a chain of Java Stream functions, convert the list of line items to
       a list of product names.

       The list should not have any duplicate values
       and the list should be sorted alphabetically (A-Z) by product name

     */
    public List<String> mapProducts(List<LineItem> lineItems)
    {
        return new ArrayList<>();
    }

    /*
    4) using a chain of Java Stream functions, convert the list of line items to
       a list of order year.

       The list should not have any duplicate values
       and the list should be sorted numerically (0-9) by year

     */
    public List<String> mapYears(List<LineItem> lineItems)
    {
        return new ArrayList<>();
    }

    /*
    5) using a chain of Java Stream functions, convert the list of line items to
       a list of order id.

       The list should not have any duplicate values
       and the list should be sorted numerically (0-9) by order id

     */
    public List<String> mapOrderIds(List<LineItem> lineItems)
    {
        return new ArrayList<>();
    }
}
