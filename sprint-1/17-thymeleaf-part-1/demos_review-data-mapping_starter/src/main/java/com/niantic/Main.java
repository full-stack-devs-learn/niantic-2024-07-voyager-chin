package com.niantic;

import com.niantic.application.SakilaApplication;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static java.util.FormatProcessor.FMT;

public class Main
{
    public static void main(String[] args)
    {
        var app = new SakilaApplication();
        app.run();
    }
}