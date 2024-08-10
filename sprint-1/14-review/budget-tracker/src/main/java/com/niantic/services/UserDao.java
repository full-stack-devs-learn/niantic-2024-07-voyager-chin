package com.niantic.services;
import com.niantic.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class UserDao
{
    private final JdbcTemplate jdbcTemplate;

    // Connect to data source
    public UserDao()
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

    // + getAllUsers(): ArrayList<User>
    // + getUserById(userId: int): User

    // + PRIORITY: getUserByName(name: String): User
    public User getUserByName(String userName)
    {
        // Remove whitespace and convert to lowercase
        userName = userName.toLowerCase().trim();

        // Build query to SELECT values that will match userId
        String sql = """
                SELECT user_id
                    , user_name
                    , first_name
                    , last_name
                    , phone
                    , email
                FROM users
                WHERE user_name = ?;
                """;

        // Execute query
        var row = jdbcTemplate.queryForRowSet(sql, userName);


        int userId = row.getInt("user_id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");
        String phone = row.getString("phone");
        String email = row.getString("email");

        // Put found user in a variable
        User user = new User(userId, userName, firstName, lastName, phone, email);

        // Return userId found
        return user;
    }

    // + addUser(user: User): void
    // + updateUser(user: User): void
    // + deleteUser(userId: int): void

}
