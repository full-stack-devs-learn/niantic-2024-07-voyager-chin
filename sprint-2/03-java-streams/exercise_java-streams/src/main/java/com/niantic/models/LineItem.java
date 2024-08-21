package com.niantic.models;

import java.time.LocalDate;

public class LineItem
{
    private String companyName;
    private int orderId;
    private LocalDate orderDate;
    private double unitPrice;
    private int quantity;
    private double lineTotal;
    private String productName;
    private String categoryName;

    public LineItem()
    {
    }

    public LineItem(String companyName, int orderId, LocalDate orderDate, double unitPrice, int quantity, double lineTotal, String productName, String categoryName)
    {
        this.companyName = companyName;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.lineTotal = lineTotal;
        this.productName = productName;
        this.categoryName = categoryName;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate)
    {
        this.orderDate = orderDate;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
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
        return lineTotal;
    }

    public void setLineTotal(double lineTotal)
    {
        this.lineTotal = lineTotal;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String toString()
    {
        return String.format("%-10d %-40s %-30s %-40s %-12s $ %-6.2f %-5d $ %.2f", orderId, companyName, categoryName, productName, orderDate, unitPrice, quantity, lineTotal);
    }
}
