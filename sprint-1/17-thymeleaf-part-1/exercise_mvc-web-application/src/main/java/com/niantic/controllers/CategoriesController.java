package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao = new CategoryDao();

    @GetMapping("/categories")
    public String getAllCategories(Model model, @RequestParam(required = false) String category)
    {
        ArrayList<Category> categories;

        if(category == null)
        {
            categories = categoryDao.getAllCategories();
        }
        else
        {
            categories = categoryDao.getCategoryByName(category);
        }

        StringBuilder builder = new StringBuilder();

        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/categories/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/details";
    }
}
