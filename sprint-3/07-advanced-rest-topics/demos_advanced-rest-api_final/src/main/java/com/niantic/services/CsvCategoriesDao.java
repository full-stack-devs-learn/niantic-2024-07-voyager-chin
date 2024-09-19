package com.niantic.services;

import com.niantic.models.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

public class CsvCategoriesDao implements CategoryDao
{
    @Override
    public List<Category> getCategories()
    {
        return List.of();
    }

    @Override
    public Category getCategory(int id)
    {
        return null;
    }

    @Override
    public Category addCategory(Category Category)
    {
        return null;
    }

    @Override
    public void updateCategory(int id, Category Category)
    {

    }

    @Override
    public void deleteCategory(int id)
    {

    }
}
