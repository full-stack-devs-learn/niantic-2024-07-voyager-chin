package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;

public class ProductDao
{
    private final JdbcTemplate jdbcTemplate;

    public ProductDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
    Return a list of all Products with the specified categoryId
     */
    public ArrayList<Product> getProductsByCategory(int categoryId)
    {
        return null;
    }

    /*
    Find and return a Product by Id
     */
    public Product getProduct(int productId)
    {
        return null;
    }

    /*
    Add a new product
     */
    public void addProduct(Product product)
    {
    }

    /*
    Update product by Id
     */
    public void updateProduct(Product product)
    {
    }

    /*
    Delete a product by Id
     */
    public void deleteProduct(int id)
    {
    }

}
