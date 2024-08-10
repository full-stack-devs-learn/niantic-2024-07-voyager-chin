package com.niantic.models;

public class SubCategory {
    // Declare private variables
    private int subCategoryId;
    private String subCategoryName;
    private String description;

    // Parameterless
    public SubCategory()
    {
    }

    // Parameterized
    public SubCategory(int subCategoryId, String subCategoryName, String description)
    {
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.description = description;
    }

    // Getters and Setters

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
