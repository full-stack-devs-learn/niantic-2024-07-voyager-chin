package com.niantic.controllers.apis;

import com.niantic.models.Category;
import com.niantic.models.HttpError;
import com.niantic.services.CategoryDao;
import com.niantic.services.MySqlCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.niantic.services.LoggingService.appLogger;
import static com.niantic.services.LoggingService.errorLogger;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController
{
    private CategoryDao categoryDao = new MySqlCategoryDao();

    @Autowired
    public CategoriesController(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> getAllCategories()
    {
        try
        {
            appLogger.logMessage("Displaying all categories");
            List<Category> categories = categoryDao.getCategories();
            return ResponseEntity.ok(categories);
        }
        catch (Exception e)
        {
            errorLogger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
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
                errorLogger.logMessage("Category " + id + " was not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Category " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            appLogger.logMessage("Displaying category " + id);
            return ResponseEntity.ok(category);
        }
        catch (Exception e)
        {
            errorLogger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addCategory(@RequestBody Category category)
    {
        try
        {
            categoryDao.addCategory(category);
            appLogger.logMessage("Added new category: " + category.getCategoryName());
            return ResponseEntity.ok(category);
        }
        catch (Exception e)
        {
            errorLogger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody Category category)
    {
        try
        {
            var existingCategory = categoryDao.getCategory(id);
            if(existingCategory == null)
            {
                errorLogger.logMessage("Category " + id + " was not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Category " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            categoryDao.updateCategory(id, category);
            appLogger.logMessage("Updated category " + id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            errorLogger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCategory(@PathVariable int id)
    {
        try
        {
            var category = categoryDao.getCategory(id);

            if(category == null)
            {
                errorLogger.logMessage("Category " + id + " was not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Category " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            categoryDao.deleteCategory(id);
            appLogger.logMessage("Deleted category " + id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            errorLogger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
