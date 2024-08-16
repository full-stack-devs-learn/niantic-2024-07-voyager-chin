package com.niantic.controllers;

import com.niantic.models.Category;
import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ProductsController
{
    private ProductDao productDao = new ProductDao();

    private CategoryDao categoryDao = new CategoryDao();

    @GetMapping("/products")
    public String getAllProducts(Model model, @RequestParam(required = false) String product)
    {
        ArrayList<Product> products;

        if(product == null)
        {
            products = productDao.getAllProducts();
        }
        else
        {
            products = productDao.getProductByName(product);
        }

        StringBuilder builder = new StringBuilder();

        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/products/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "products/details";
    }

    // Add Product
    @GetMapping("products/add")
    public String addProduct(Model model)
    {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryDao.getAllCategories());
        model.addAttribute("action", "add");
        return "products/add_edit";
    }

    @PostMapping("/products/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product)
    {
        productDao.addProduct(product);
        model.addAttribute("product", product);
        return "products/add_success";
    }

    // Edit Product
    @GetMapping("/products/{id}/edit")
    String editProduct(Model model, @PathVariable int id)
    {
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryDao.getAllCategories());
        model.addAttribute("action", "edit");
        return "products/add_edit";
    }

    @PostMapping("products/{id}/edit")
    public String editProduct(@ModelAttribute("product") Product product, @PathVariable int id)
    {
        product.setProductId(id);
        productDao.updateProduct(product);
        return "redirect:/products";
    }

    // Delete Product
    @GetMapping("products/{id}/delete")
    public String deleteProduct(Model model, @PathVariable int id)
    {
        Product product = productDao.getProductById(id);
        if(product == null)
        {
            model.addAttribute("message", String.format("Product not found for id %d", id));
            return "404";
        }

        model.addAttribute("product", product);
        return "products/delete";
    }

    @PostMapping("products/{id}/delete")
    public String deleteProduct(@PathVariable int id)
    {
        productDao.deleteProduct(id);

        return "redirect:/products";
    }
}
