package com.niantic;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static java.util.FormatProcessor.FMT;

public class Main
{
    public static void main(String[] args)
    {
        // 1. create a data source
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("P@ssw0rd");

        // this is the object used to execute SQL statements
        var jdbcTemplate = new JdbcTemplate(dataSource);

        // 2. execute a SQL statement
        String sql = """
                SELECT actor_id
                	, first_name
                    , last_name
                FROM actor;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        // 3. loop through the rows and
        //    do something with the data
        while(row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            String lineOutput1 = String.format("%-5d %-10s %-15s", actorId, firstName, lastName);
            String lineOutput = FMT."%-5d\{actorId} %-10s\{firstName} %-15s\{lastName}";

            System.out.println(lineOutput);

            //System.out.println(FMT."%5d\{actorId} %10s\{firstName} %15s\{lastName}");
        }



    }
}