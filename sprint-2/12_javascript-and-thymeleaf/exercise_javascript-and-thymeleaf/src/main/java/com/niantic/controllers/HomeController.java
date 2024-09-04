package com.niantic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{

    // home page
    @GetMapping("/")
    public String categories()
    {
        return "redirect:/products";
    }
}
