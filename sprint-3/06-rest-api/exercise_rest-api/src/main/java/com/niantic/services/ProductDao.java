package com.niantic.services;

import com.niantic.models.Product;
import java.util.List;

public interface ProductDao
{
    List<Product> getProducts();

    Product getProduct(int id);

    Product addProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    List<Product> getProductsByCategory(int categoryId);
}
