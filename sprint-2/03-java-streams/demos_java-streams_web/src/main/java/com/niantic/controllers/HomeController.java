package com.niantic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController
{

    @GetMapping
    public String index() throws IOException
    {
        return "index";
    }
}
