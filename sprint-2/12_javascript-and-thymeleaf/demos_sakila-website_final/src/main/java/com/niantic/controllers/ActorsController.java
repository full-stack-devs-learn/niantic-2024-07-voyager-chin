package com.niantic.controllers;

import com.niantic.models.Actor;
import com.niantic.services.ActorsDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ActorsController
{
    private ActorsDao actorsDao = new ActorsDao();


    // http://localhost:8080/actors
    @GetMapping("/actors")
    public String getAllActors(Model model, @RequestParam(defaultValue = "1") Integer page)
    {
        ArrayList<Actor> actors;

        actors = actorsDao.getActors(page);

        model.addAttribute("actors", actors);
        return "actors/index";
    }

    @GetMapping("/actors/page/{page}")
    public String getAllActors(Model model, @PathVariable int page)
    {
        ArrayList<Actor> actors;
        actors = actorsDao.getActors(page);

        StringBuilder builder = new StringBuilder();

        model.addAttribute("actors", actors);
        return "/actors/fragments/actor-table-list";
    }

    @GetMapping("/actors/{id}")
    public String details(Model model, @PathVariable int id)
    {
        var actor = actorsDao.getActorById(id);
        model.addAttribute("actor", actor);
        return "actors/details";
    }

    @GetMapping("/actors/add/{name}")
    public String addSuccess(Model model, @PathVariable String name)
    {
        model.addAttribute("name", name);
        return "actors/add_success";
    }

    // GET = show me the form
    @GetMapping("/actors/add")
    public String addActor(Model model)
    {
        model.addAttribute("actor", new Actor());
        model.addAttribute("action", "add");
        return "actors/add_edit";
    }

    // POST = I am submitting the form
    @PostMapping("/actors/add")
    public String addActor(Model model, @Valid @ModelAttribute("actor") Actor actor, BindingResult result)
    {
        if(result.hasErrors())
        {
            model.addAttribute("isInvalid", true);
            // redirect back to the add page
            return "actors/add_edit";
        }

        actorsDao.addActor(actor);
        return "redirect:/actors/add/" + actor.getFirstName();
    }

    @GetMapping("/actors/{id}/edit")
    public String editActor(Model model, @PathVariable int id)
    {
        Actor actor = actorsDao.getActorById(id);
        model.addAttribute("actor", actor);
        model.addAttribute("action", "edit");
        return "actors/add_edit";
    }

    @PostMapping("/actors/{id}/edit")
    public String editActor(@ModelAttribute("actor") Actor actor, @PathVariable int id)
    {
        actor.setActorId(id);
        actorsDao.updateActor(actor);
        return "redirect:/actors";
    }

    @GetMapping("/actors/{id}/delete")
    public String deleteActor(Model model, @PathVariable int id)
    {
        Actor actor = actorsDao.getActorById(id);
        if(actor == null)
        {
            model.addAttribute("message", String.format("There is no actor with id %d", id));
            return "404";
        }

        model.addAttribute("actor", actor);
        return "actors/delete";
    }

    @PostMapping("/actors/{id}/delete")
    public String deleteActor(@PathVariable int id)
    {
        actorsDao.deleteActor(id);

        return "redirect:/actors";
    }
}
