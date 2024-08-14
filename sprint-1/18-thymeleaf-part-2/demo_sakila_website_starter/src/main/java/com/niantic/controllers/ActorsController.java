package com.niantic.controllers;

import com.niantic.models.Actor;
import com.niantic.services.ActorsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ActorsController
{
    private ActorsDao actorsDao = new ActorsDao();

    // https://localhost:8080/actors
    @GetMapping("/actors")
    public String getAllActors(Model model, @RequestParam(required = false) String last)
    {
        ArrayList<Actor> actors;

        if(last == null)
        {
            actors = actorsDao.getAllActors();
        }
        else
        {
            actors = actorsDao.getActorsByLastName(last);
        }

        StringBuilder builder = new StringBuilder();

        model.addAttribute("actors", actors);
        return "actors/index";
    }

    @GetMapping("/actors/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var actor = actorsDao.getActorById(id);
        model.addAttribute("actor", actor);
        return "actors/details";
    }
}
