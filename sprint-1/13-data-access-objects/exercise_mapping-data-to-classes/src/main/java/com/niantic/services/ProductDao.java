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
        // Create ArrayList that will store matching products by category
        var products = new ArrayList<Product>();

        // Build query to SELECT values that will match categoryId
        String sql = """
                SELECT product_id
                    , product_name
                    , quantity_per_unit
                    , unit_price
                    , units_in_stock
                    , units_on_order
                    , reorder_level
                FROM products
                WHERE category_id = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, categoryId);

        // Loop through rows to get product information
        while (row.next())
        {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            // Add products to the ArrayList
            var product = new Product(productId, categoryId, productName, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel);
            products.add(product);
        }

        // Return ArrayList of products that match selected categoryId
        return products;
    }

    /*
    Find and return a Product by Id
     */
    public Product getProduct(int productId)
    {
        // Build query to SELECT values that will match productId
        String sql = """
                SELECT category_id
                    , product_name
                    , quantity_per_unit
                    , unit_price
                    , units_in_stock
                    , units_on_order
                    , reorder_level
                FROM products
                WHERE product_id = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, productId);

        // Loop through rows to get product information
        if(row.next())
        {
            int categoryId = row.getInt("category_id");
            String productName = row.getString("product_name");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            // Return product details that match selected productId
            return new Product(productId, categoryId, productName, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel);
        }

        return null;
    }

    /*
    Add a new product
     */
    public void addProduct(Product product)
    {
        // Build query to insert values into products table
        String sql = "INSERT INTO products (category_id, product_name, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level) VALUES (?,?,?,?,?,?,?);";

        // Execute query to add product details using get function
        jdbcTemplate.update(sql,
                product.getCategoryId(),
                product.getProductName(),
                product.getQuantityPerUnit(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getUnitsOnOrder(),
                product.getReorderLevel()
        );
    }

    /*
    Update product by Id
     */
    public void updateProduct(Product product)
    {
        // Build query to update values matching given product
        String sql = """
                UPDATE products
                SET category_id = ?
                    , product_name = ?
                    , quantity_per_unit = ?
                    , unit_price = ?
                    , units_in_stock = ?
                    , units_on_order = ?
                    , reorder_level = ?
                WHERE product_id = ?
                """;

        // Execute query to update product details using get function
        jdbcTemplate.update(sql,
                product.getCategoryId(),
                product.getProductName(),
                product.getQuantityPerUnit(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getUnitsOnOrder(),
                product.getReorderLevel(),
                product.getProductId()
        );
    }

    /*
    Delete a product by Id
     */
    public void deleteProduct(int id)
    {
        // Build query to delete product that matches given product id
        String sql = "DELETE FROM products WHERE product_id = ?;";

        // Execute query to delete the row
        jdbcTemplate.update(sql, id);
    }

}
