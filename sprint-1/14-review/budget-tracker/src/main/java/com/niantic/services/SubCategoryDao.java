package com.niantic.services;
import com.niantic.models.SubCategory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class SubCategoryDao
{
    private final JdbcTemplate jdbcTemplate;

    // Connect to data source
    public SubCategoryDao()
    {
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

    //+ getSubCategoriesByCategory(): ArrayList<SubCategory>
    //+ getSubCategoryById(subCategoryId: int): SubCategory
    //+ PRIORITY getSubCategoryByName(name: String): SubCategory
    public SubCategory getSubCategoryByName(String subCategoryName)
    {
        // Remove whitespace and convert to lowercase
        subCategoryName = subCategoryName.toLowerCase().trim();

        // Build query to SELECT values that will match userId
        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories
                WHERE sub_category_name = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, subCategoryName);

        if (row.next())
        {
            // Store values from query to variables
            int subCategoryId = row.getInt("sub_category_id");
            int categoryId = row.getInt("category_id");
            String description = row.getString("description");

            // Put found subcategory in a variable
            return new SubCategory(subCategoryId, subCategoryName, description);
        }

        // Return subCategory
        return null;
    }



    //+ addSubCategory(subCategory: SubCategory): void
    //+ updateSubCategory(subCategory: SubCategory): void
    //+ deleteSubCategory(subCategoryId: int): void
}
