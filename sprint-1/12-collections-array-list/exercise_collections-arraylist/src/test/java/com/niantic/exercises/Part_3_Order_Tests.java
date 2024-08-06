package com.niantic.exercises;

import com.niantic.models.OrderLineItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Part_3_Order_Tests
{
    private Order order;

    OrderLineItem lineItem1 = new OrderLineItem(1, 10248, "Queso Cabrales", "Dairy Products", 14.00, 14);
    OrderLineItem lineItem2 = new OrderLineItem(2, 10248, "Mozzarella di Giovanni", "Dairy Products", 34.80, 5);
    OrderLineItem lineItem3 = new OrderLineItem(3, 10248, "Singaporean Hokkien Fried Mee", "Grains/Cereals", 9.80, 10);

    @BeforeEach
    void setUp()
    {
        order = new Order();
    }

    @Test
    public void addItem_should_addNewItem_toTheCart()
    {
        // arrange
        // act
        order.addItem(lineItem1);

        // assert
        var actual = order.getShoppingCart();
        assertEquals(1, actual.size(), "Only 1 item was added to the cart.");
        assertEquals(lineItem1, actual.get(0), "The cart should contain the line item that was added: " + lineItem1.getProduct());
    }

    @Test
    public void addItem_should_updateTheQuantity_inTheCart()
    {
        // arrange
        var expectedQuantity = lineItem1.getQuantity() * 2;

        // act
        order.addItem(lineItem1);
        order.addItem(lineItem1);

        // assert
        var actual = order.getShoppingCart();
        assertEquals(1, actual.size(), "The same Item was added to the cart twice, but the quantity should be updated.");
        assertEquals(expectedQuantity, actual.get(0).getQuantity(), "The line item was added twice, so the quantity should be doubled.");
    }

    @Test
    public void removeItem_should_removeTheItemFromTheCart()
    {
        // arrange
        var expectedQuantity = lineItem1.getQuantity();
        order.addItem(lineItem1);
        order.addItem(lineItem2);
        order.addItem(lineItem3);

        // act
        order.removeItem(lineItem3);

        // assert
        var actual = order.getShoppingCart();
        assertEquals(2, actual.size(), "Three items were added and one was removed");
        var removedItem = actual.stream().filter(item -> item.equals(lineItem3)).findFirst();
        assertFalse(removedItem.isPresent(), lineItem3.getProduct() + " should have been removed.");
    }

    @Test
    public void findHighestPriceProduct_should_returnTheHighestPriceProduct_lineItem()
    {
        // arrange
        var expected = lineItem2;
        order.addItem(lineItem1);
        order.addItem(lineItem2);
        order.addItem(lineItem3);

        // act
        var actual = order.findHighestPriceProduct();

        // assert
        assertEquals(expected.getProduct(), actual.getProduct(), expected.getProduct() + " should be highest price product: $ " + expected.getPrice());
        assertEquals(expected.getPrice(), actual.getPrice(), expected.getProduct() + " should be highest price product: $ " + expected.getPrice());
    }

    @Test
    public void findMostExpensiveLineItem_should_returnTheMostExpensiveLineItem()
    {
        // arrange
        var expected = lineItem1;
        order.addItem(lineItem1);
        order.addItem(lineItem2);
        order.addItem(lineItem3);

        // act
        var actual = order.findMostExpensiveLineItem();

        // assert
        assertEquals(expected.getProduct(), actual.getProduct(), expected.getProduct() + " should be most expensive line item: $ " + expected.getProduct());
        assertEquals(expected.getLineTotal(), actual.getLineTotal(), expected.getProduct() + " should be most expensive line item: $ " + expected.getProduct());
    }

    @Test
    public void getOrderTotal_should_calculateTheOrderTotal()
    {
        // arrange
        var expected = lineItem1.getLineTotal() + lineItem2.getLineTotal() + lineItem3.getLineTotal();
        order.addItem(lineItem1);
        order.addItem(lineItem2);
        order.addItem(lineItem3);

        // act
        var actual = order.getOrderTotal();

        // assert
        assertEquals(expected, actual, "Three LineItems were added to the cart and their line totals should add up to " + expected);
    }

    @Test
    public void getAveragePrice_should_calculateTheAveragePrice()
    {
        // arrange
        var orderTotal = lineItem1.getLineTotal() + lineItem2.getLineTotal() + lineItem3.getLineTotal();
        var itemCount = lineItem1.getQuantity() + lineItem2.getQuantity() + lineItem3.getQuantity();
        var expected = orderTotal / itemCount;

        order.addItem(lineItem1);
        order.addItem(lineItem2);
        order.addItem(lineItem3);

        // act
        var actual = order.getAveragePricePerItem();

        // assert
        assertEquals(expected, actual, "Three LineItems with a total item count of: " + itemCount + " and a total price of: $ " + orderTotal);
    }
}