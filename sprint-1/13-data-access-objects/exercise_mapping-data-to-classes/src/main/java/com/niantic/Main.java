package com.niantic;

import com.niantic.application.NorthwindApplication;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;

public class Main
{
    public static void main(String[] args)
    {
        var app = new NorthwindApplication();
        app.run();
    }
}