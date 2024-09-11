package com.niantic.repositories;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DaoBase
{
    protected JdbcTemplate jdbcTemplate;

    public DaoBase()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("P@ssw0rd");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
