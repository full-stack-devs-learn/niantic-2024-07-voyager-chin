package com.niantic.repositories;

import com.niantic.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySqlProductDao implements ProductDao
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlProductDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getByCategoryId(int categoryId)
    {
        List<Product> products = new ArrayList<>();

        var sql = """
                SELECT product_id
                    , product_name
                    , category_id
                    , quantity_per_unit
                    , unit_price
                FROM products;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while (row.next())
        {
            Product product = mapRowToProduct(row);
            products.add(product);
        }

        return products;
    }

    @Override
    public Product getById(int id)
    {
        var sql = """
                SELECT product_id
                    , product_name
                    , category_id
                    , quantity_per_unit
                    , unit_price
                FROM products
                WHERE product_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, id);

        while (row.next())
        {
            return mapRowToProduct(row);
        }

        return null;
    }

    @Override
    public Product addProduct(Product product)
    {
        var sql = """
                INSERT INTO products (product_name, category_id, quantity_per_unit, unit_price)
                VALUES (?, ?, ?, ?);
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, product.getName());
            statement.setInt(2, product.getCategoryId());
            statement.setString(3, product.getQuantityPerUnit());
            statement.setBigDecimal(4, product.getUnitPrice());

            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey().intValue();

        return getById(newId);
    }

    @Override
    public void updateProduct(int id, Product product)
    {
        var sql = """
                UPDATE products
                SET product_name = ?
                    , category_id = ?
                    , quantity_per_unit = ?
                    , unit_price = ?
                WHERE product_id = ?;
                """;

        jdbcTemplate.update(sql, product.getName(), product.getCategoryId(), product.getQuantityPerUnit(), product.getUnitPrice(), id);
    }

    @Override
    public void deleteProduct(int id)
    {
        var sql = "DELETE FROM products WHERE product_id = ?;";

        jdbcTemplate.update(sql, id);
    }

    private Product mapRowToProduct(SqlRowSet row)
    {
        int id = row.getInt("product_id");
        String name = row.getString("product_name");
        int categoryId = row.getInt("category_id");
        String quantityPerUnit = row.getString("quantity_per_unit");
        BigDecimal unitPrice = row.getBigDecimal("unit_price");

        return new Product(id, name,categoryId, quantityPerUnit, unitPrice);
    }
}
