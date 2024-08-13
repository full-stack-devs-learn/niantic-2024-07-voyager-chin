package com.niantic.controllers;

import com.niantic.services.CategoryDao;
import org.springframework.stereotype.Controller;

@Controller
public class CategoriesController
{
    CategoryDao categoryDao = new CategoryDao();
}
