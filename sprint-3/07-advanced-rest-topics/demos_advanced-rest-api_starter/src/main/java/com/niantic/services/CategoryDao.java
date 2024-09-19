package com.niantic.services;

import com.niantic.models.Category;

import java.util.List;

public interface CategoryDao
{
    List<Category> getCategories();

    Category getCategory(int id);

    Category addCategory(Category Category);

    void updateCategory(int id, Category Category);

    void deleteCategory(int id);
}
