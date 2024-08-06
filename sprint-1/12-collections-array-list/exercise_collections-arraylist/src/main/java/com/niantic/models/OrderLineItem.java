package com.niantic.models;

import java.util.Objects;

public class OrderLineItem
{
    private int id;
    private int orderId;
    private String product;
    private String category;
    private double price;
    private int quantity;

    public OrderLineItem(int id, int orderId, String product, String category, double price, int quantity)
    {
        this.id = id;
        this.orderId = orderId;
        this.product = product;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderLineItem()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public String getProduct()
    {
        return product;
    }

    public void setProduct(String product)
    {
        this.product = product;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getLineTotal()
    {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OrderLineItem that = (OrderLineItem) o;
        return Objects.equals(product, that.product);
    }
}
