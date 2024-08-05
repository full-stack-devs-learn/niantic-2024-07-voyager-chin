package com.niantic.northwind_models;

public class Product
{
    private int id;
    private String name;
    private int supplierId;
    private int categoryId;
    private String description;
    private double price;
    private int stockLevel;
    private int unitsOnOrder;
    private int reorderLevel;
    private boolean isDiscontinued;

    public Product()
    {

    }

    public Product(int id, String name, int supplierId, int categoryId, String description, double price, int stockLevel, int unitsOnOrder, int reorderLevel, boolean isDiscontinued)
    {
        this.id = id;
        this.name = name;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.stockLevel = stockLevel;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.isDiscontinued = isDiscontinued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        isDiscontinued = discontinued;
    }
}
