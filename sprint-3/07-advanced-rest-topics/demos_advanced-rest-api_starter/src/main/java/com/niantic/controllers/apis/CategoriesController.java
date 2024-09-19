package com.niantic.controllers.apis;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import com.niantic.services.MySqlCategoryDao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController
{
    private CategoryDao categoryDao = new MySqlCategoryDao();

    @GetMapping("/api/categories")
    public List<Category> getAllCategories()
    {
        return categoryDao.getCategories();
    }

    @GetMapping("/api/categories/{id}")
    public Category getCategory(@PathVariable int id)
    {
        return categoryDao.getCategory(id);
    }

    @PostMapping("/api/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        return categoryDao.addCategory(category);
    }

    @PutMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        categoryDao.updateCategory(id, category);
    }

    @DeleteMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);
    }

}
