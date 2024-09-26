package com.niantic.controllers;

import com.niantic.exceptions.HttpError;
import com.niantic.models.Product;
import com.niantic.repositories.CategoryDao;
import com.niantic.repositories.ProductDao;
import com.niantic.services.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    private final ProductDao productDao;
    private final CategoryDao categoryDao;
    private final LoggingService logger;

    @Autowired
    public ProductsController(ProductDao productDao, CategoryDao categoryDao, LoggingService logger)
    {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<?> searchByCategory(@RequestParam(defaultValue = "1", name = "catId") Integer  categoryId)
    {
        try
        {
            var category = categoryDao.getCategory(categoryId);
            if(category == null)
            {
                logger.logMessage("Category id " + categoryId + " not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Category " + categoryId + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            var products = productDao.getByCategoryId(categoryId);

            return ResponseEntity.ok(products);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable int id)
    {
        try
        {
            var product = productDao.getById(id);
            if(product == null)
            {
                logger.logMessage("Product id " + id + " not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product id " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(product);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody Product product)
    {
        try
        {
            var newProduct = productDao.addProduct(product);

            return ResponseEntity.ok(newProduct);
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> udpate(@PathVariable int id, @RequestBody Product product)
    {
        try
        {
            var current = productDao.getById(id);
            if(current == null)
            {
                logger.logMessage("Product id " + id + " not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product id " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productDao.updateProduct(id, product);

            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> udpate(@PathVariable int id)
    {
        try
        {
            var current = productDao.getById(id);
            if(current == null)
            {
                logger.logMessage("Product id " + id + " not found");
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product id " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productDao.deleteProduct(id);

            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            logger.logMessage(e.getMessage());
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
