package com.niantic.services;

import com.niantic.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MySqlCategoryDao implements CategoryDao
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlCategoryDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Category> getCategories()
    {
        List<Category> categories = new ArrayList<>();

        String sql = """
        
                SELECT category_id, category_name, description
        FROM category
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            Category category = new Category(categoryId, categoryName, description);

            categories.add(category);
        }

        return categories;
    }

    public Category getCategory(int categoryId)
    {
        Category category = null;

        String sql =
                """
                SELECT category_id, category_name,
                description
                FROM categories
                WHERE category_id = ?
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        if(row.next())
        {
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            category = new Category(categoryId, categoryName, description);

        }

        return category;
    }

    public Category addCategory(Category category)
    {
        String sql = """
                INSERT INTO categories (category_name, description)
                VALUES (?,?)
                """;


        // insert a new record and retrieve the generated id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            // we have to define the PreparedStatement directly
            // Statement.RETURN_GENERATED_KEYS is only used for auto generated ids
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey().intValue();

        return getCategory(newId);
    }


    public void updateCategory(int id, Category category)
    {
        String sql = """
                UPDATE categories
                SET category_name = ?
                    , description = ?
                WHERE category_id = ?
                """;

        jdbcTemplate.update(sql
                , category.getCategoryName()
                , category.getDescription()
                , id);
    }


    public void deleteCategory(int categoryId)
    {
        String sql = """
                DELETE FROM categories
                WHERE category_id = ?
                """;

        jdbcTemplate.update(sql, categoryId);
    }


}
