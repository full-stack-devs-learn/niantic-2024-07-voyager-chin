package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.HttpError;
import com.niantic.services.CategoryDao;
import com.niantic.services.LoggingService;
import com.niantic.services.MySqlCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/categories")
public class CategoriesController
{
    private CategoryDao categoryDao;
    private LoggingService logger;

    @Autowired
    public CategoriesController(CategoryDao categoryDao, LoggingService logger)
    {
        this.categoryDao = categoryDao;
        this.logger = logger;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCategories()
    {
        try
        {
            var categories = categoryDao.getCategories();

            return ResponseEntity.ok(categories);
        }
        catch (Exception e)
        {
            // log the error then return the exception
            logger.logMessage(e.getMessage());

            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id)
    {
        try
        {
            var category = categoryDao.getCategory(id);
            if(category == null)
            {
                logger.logMessage("Category with id " + id + " not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.toString(), "Category " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(category);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category)
    {
        return categoryDao.addCategory(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        try
        {
            var currentCategory = categoryDao.getCategory(id);
            if(currentCategory == null)
            {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.toString(), "Category " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            categoryDao.updateCategory(id, category);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id)
    {
        categoryDao.deleteCategory(id);
    }

}
