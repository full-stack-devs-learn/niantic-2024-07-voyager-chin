package com.niantic.controllers.apis;

import com.niantic.models.Product;
import com.niantic.services.MySqlProductDao;
import com.niantic.services.ProductDao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController
{
    private ProductDao productDao = new MySqlProductDao();

    @GetMapping("/api/products")
    public List<Product> getAllProducts() { return productDao.getProducts(); }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable int id) { return productDao.getProduct(id); }

    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) { return productDao.addProduct(product); }

    @PutMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        productDao.updateProduct(id, product);
    }

    @DeleteMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) { productDao.deleteProduct(id); }

    //NOT WORKING YET
//    @GetMapping("/api/products/")
//    public List<Product> getProductsByCategoryId(@RequestParam("catId") int catId)
//    {
//        return productDao.getProductsByCategory(catId);
//    }
}
