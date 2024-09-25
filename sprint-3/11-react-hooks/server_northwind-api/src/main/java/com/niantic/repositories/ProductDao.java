package com.niantic.repositories;

import com.niantic.models.Product;

import java.util.List;

public interface ProductDao
{
    List<Product> getByCategoryId(int categoryId);

    Product getById(int id);

    Product addProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
