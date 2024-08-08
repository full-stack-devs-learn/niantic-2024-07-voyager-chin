package com.niantic.exercises;

import com.niantic.models.OrderLineItem;

import java.util.ArrayList;
import java.util.OptionalDouble;


/*
The exercises in this class are optional - this is the challenge exercise
 */
public class Order
{
    // this ArrayList is the container (shopping cart) for all items that are being ordered
    private ArrayList<OrderLineItem> shoppingCart = new ArrayList<>();

    public ArrayList<OrderLineItem> getShoppingCart()
    {
        return shoppingCart;
    }

    /*
    1. Add logic to allow a user to add an Item to a shopping cart
        - if the item already exists in the cart, update the quantity
        - search for a line item by name, and add the new quantity to the original quantity
     */
    public void addItem(OrderLineItem item)
    {
        OrderLineItem itemToAdd = null;

        // Search item by name
        for (OrderLineItem itemInCart : shoppingCart)
        {
            if(itemInCart.getProduct().equalsIgnoreCase(item.getProduct()))
            {
                itemToAdd = itemInCart;
                break;
            }
        }

        if(itemToAdd != null)
        {
            // If item exist, update quantity to add to existing quantity
            int quantity = itemToAdd.getQuantity() + item.getQuantity();
            itemToAdd.setQuantity(quantity);
        }
        else
        {
            // If item doesn't exist yet, add item and quantity
            shoppingCart.add(item);
        }
    }

    /*
    2. Add logic to allow a user to remove an Item to a shopping cart
        - search for a line item by name, and remove it from the list
     */
    public void removeItem(OrderLineItem item)
    {
        shoppingCart.remove(item);
    }

    /*
    3. Search for the highest priced item in the shopping cart and return the
        line item that contains that item.

        If the shopping cart is empty return null
     */
    public OrderLineItem findHighestPriceProduct()
    {
        // Check if shopping cart is empty then return null
        if (shoppingCart.isEmpty())
        {
            return null;
        }
        // If shopping cart contain item/s:
        else
        {
            OrderLineItem highestPrice = shoppingCart.getFirst();

            // Find the highest price then return it
            for (OrderLineItem itemInCart : shoppingCart)
            {
                if (itemInCart.getPrice() > highestPrice.getPrice())
                {
                    highestPrice = itemInCart;
                }
            }

            return highestPrice;
        }

    }

    /*
    4. Search for the most expensive line item in the shopping cart
        and return it

        If the shopping cart is empty return null
     */
    public OrderLineItem findMostExpensiveLineItem()
    {
        // Check if shopping cart is empty then return null
        if (shoppingCart.isEmpty())
        {
            return null;
        }
        else
        {
            // If shopping cart is not empty, find the highest line price:
            OrderLineItem mostExpensive = shoppingCart.getFirst();

            for (OrderLineItem itemInCart : shoppingCart)
            {
                // Calculate total line price
                double itemPrice = itemInCart.getQuantity() * itemInCart.getPrice();
                double highestPrice = mostExpensive.getQuantity() * mostExpensive.getPrice();

                // Replace variable if current item line price is higher than existing line price
                if (itemPrice > highestPrice)
                {
                    mostExpensive = itemInCart;
                }
            }
            return mostExpensive;
        }
    }

    /*
    5. Calculate and return the order total
     */
    public double getOrderTotal()
    {
        double orderTotal = 0;

        // Calculate item total price  for each line order
        for (OrderLineItem itemInCart : shoppingCart)
        {
            double itemTotal = itemInCart.getPrice() * itemInCart.getQuantity();
            orderTotal += itemTotal; // Add each line total to order total variable
        }

        return orderTotal;
    }

    /*
    6. Return the total number of items in the cart
     */
    public int getTotalItemCount()
    {
        int totalItemCount = 0;

        // Get quantity of all items in cart
        for (OrderLineItem itemInCart : shoppingCart)
        {
            int itemQuantity = itemInCart.getQuantity();
            // Add each item quantity to the total item count
            totalItemCount += itemQuantity;
        }

        return totalItemCount;
    }

    /*
    7. Calculate the average price for all items in the shopping cart
     */
    public double getAveragePricePerItem()
    {
        double totalPrice = 0;
        double totalQuantity = 0;

        for (OrderLineItem itemInCart : shoppingCart)
        {
           //Calculate total price per item and add to totalPrice
           totalPrice += itemInCart.getPrice() * itemInCart.getQuantity();
           //Get quantity of each item and add to totalQuantity
           totalQuantity += itemInCart.getQuantity();
        }

        return totalPrice / totalQuantity;
    }
}
