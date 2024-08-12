package com.niantic.services;

import com.niantic.models.Category;
import com.niantic.models.Transaction;
import com.niantic.models.Vendor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class VendorDao
{
    private final JdbcTemplate jdbcTemplate;

    // Connect to data source
    public VendorDao()
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

    //+ getAllVendors(): ArrayList<Vendor>
    //+ getVendorById(userId: int): Vendor

    //PRIORITY + getVendorByName(name: String): Vendor
    public Vendor getVendorByName(String vendorName)
    {
        // Remove whitespace and convert to lowercase
        vendorName = vendorName.trim();

        // Build query to SELECT values that will match userId
        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors
                WHERE vendor_name LIKE ?;
                """;



        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, vendorName);

        if (row.next())
        {
            // Store values from query to variables
            int vendorId = row.getInt("vendor_id");
            String website = row.getString("website");

            // Put found category in a variable
            return new Vendor(vendorId, vendorName, website);
        }

        // Return Category
        return null;
    }

    //+ addVendor(vendor: Vendor): void
    //+ updateVendor(vendor: Vendor): void
    //+ deleteVendor(vendorId: int): void

}
