package com.niantic.models;

public class Category {

    // Declare private variables
    private int categoryId;
    private String categoryName;
    private String description;

    // Parameterless
    public Category()
    {
    }

    // Parameterized
    public Category(int categoryId, String categoryName, String description)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    // Getters and setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
