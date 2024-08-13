package com.niantic.controllers;

import com.niantic.models.Actor;
import com.niantic.services.ActorsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ActorsController
{
    private ActorsDao actorsDao = new ActorsDao();

    // https://localhost:8080/actors
    @GetMapping("/actors")
    public String getAllActors(Model model)
    {
        ArrayList<Actor> actors = actorsDao.getAllActors();
        model.addAttribute("actors", actors);
        return "actors/index";
    }
}
