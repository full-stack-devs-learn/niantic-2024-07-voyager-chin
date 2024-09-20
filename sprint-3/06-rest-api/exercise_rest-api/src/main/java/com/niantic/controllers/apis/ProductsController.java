package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.niantic.models.HttpError;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController
{
    private ProductDao productDao;
    private CategoryDao categoryDao;

    @Autowired
    public ProductsController(ProductDao productDao, CategoryDao categoryDao)
    {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public ResponseEntity<?> getProducts(@RequestParam(required = false) Integer catId)
    {
        try
        {
            List<Product> products = new ArrayList<>();

            if(catId == null)
            {
                products = productDao.getProducts();
            }
            else
            {
                var category = categoryDao.getCategory(catId);
                if(category == null)
                {
                    var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Category " + catId + " is invalid");
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
                }
                products = productDao.getProductsByCategory(catId);
            }

            return ResponseEntity.ok(products);
        }
        catch (Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id)
    {
        try
        {
            var product = productDao.getProduct(id);

            if(product == null)
            {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            return ResponseEntity.ok(product);
        }
        catch (Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        try
        {
            productDao.addProduct(product);
            return ResponseEntity.ok(product);
        }
        catch (Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        try
        {
            var existingProduct = productDao.getProduct(id);
            if(existingProduct == null)
            {
                var error = new HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            productDao.updateProduct(id, product);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@PathVariable int id)
    {
        try
        {
            var product = productDao.getProduct(id);

            if(product == null)
            {
                var error = new  HttpError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.toString(), "Product " + id + " is invalid");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productDao.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            var error = new HttpError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Oops something went wrong");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
