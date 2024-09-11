package com.niantic.controllers;

import com.niantic.models.Actor;
import com.niantic.services.ActorsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ActorsController
{
    private ActorsService actorsService = new ActorsService();

    // https://localhost:8080/actors
    @GetMapping("/actors")
    public String getAllActors(Model model, @RequestParam(required = false) String last)
    {
        ArrayList<Actor> actors = actorsService.searchByLastName(last);
        model.addAttribute("actors", actors);
        return "actors/index";
    }

    @GetMapping("/actors/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var actor = actorsService.getById(id);
        model.addAttribute("actor", actor);
        return "actors/details";
    }
}
