package com.niantic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beans")
public class BeansController
{
    @Autowired
    ApplicationContext applicationContext;

    @GetMapping
    public ResponseEntity<?> getBeans()
    {
        var beans = applicationContext.getBeanDefinitionNames();
        return ResponseEntity.ok(beans);
    }
}
