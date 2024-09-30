package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class CategoriesController
{
    private CategoryDao categoryDao = new CategoryDao();

    // list all categories
    @GetMapping( "/categories")
    public String categories(Model model)
    {
        var categories = categoryDao.getCategories();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    // details page
    @GetMapping("/categories/{id}")
    public String getCategory(Model model, @PathVariable int id)
    {
        var categories = categoryDao.getCategories();
        var category = categories.stream().filter(c-> c.getCategoryId() == id).findFirst();

        if(category.isEmpty())
        {
            return "404";
        }

        model.addAttribute("category", category.get());
        return "categories/details";
    }

    // add category
    @GetMapping("/categories/add")
    public String addCategory(Model model)
    {
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    @PostMapping("/categories/add")
    public String saveCategory(@ModelAttribute("category") Category category)
    {
        categoryDao.addCategory(category);
        return "redirect:/categories";
    }

    // edit category
    @GetMapping("/categories/{id}/edit")
    public String editCategory(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategoryById(id);

        if(category == null)
        {
            return "404";
        }

        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@ModelAttribute("category") Category category, @PathVariable int id)
    {
        categoryDao.updateCategory(category);

        return "redirect:/categories";
    }


    // edit category
    @GetMapping("/categories/{id}/delete")
    public String deleteCategory(Model model, @PathVariable int id)
    {
        var category = categoryDao.getCategoryById(id);

        if(category == null)
        {
            return "404";
        }

        model.addAttribute("category", category);
        return "categories/delete";
    }

    @PostMapping("/categories/{id}/delete")
    public String deleteCategoryConfirm(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);

        return "redirect:/categories";
    }
}
