package com.niantic.services;
import com.niantic.models.Category;
import com.niantic.models.SubCategory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    // Connect to data source
    public CategoryDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //+ getAllCategories(): ArrayList<Category>
    //+ getCategoryById(userId: int): Category


    // PRIORITY: + getCategoryByName(name: String): Category
    public Category getCategoryByName(String categoryName)
    {
        // Remove whitespace and convert to lowercase
        categoryName = categoryName.trim();

        // Build query to SELECT values that will match userId
        String sql = """
                SELECT category_id
                    , category_name
                    , description
                FROM categories
                WHERE category_name LIKE ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, categoryName);

        // Store values from query to variables
        int categoryId = row.getInt("category_id");
        String description = row.getString("description");

        // Put found subcategory in a variable
        Category category = new Category(categoryId, categoryName, description);

        // Return subCategory
        return category;
    }


    //+ addCategory(category: Category): void
    //+ updateCategory(category: Category): void
    //+ deleteCategory(categoryId: int): void

}
