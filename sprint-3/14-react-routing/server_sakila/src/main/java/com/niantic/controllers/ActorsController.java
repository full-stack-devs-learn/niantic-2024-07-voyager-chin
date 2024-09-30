package com.niantic.controllers;

import com.niantic.models.Actor;
import com.niantic.services.ActorsDao;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ActorsController
{
    private ActorsDao actorsDao = new ActorsDao();

    // http://localhost:8080/actors
    @GetMapping("/actors")
    public ResponseEntity<?> getAllActors(@RequestParam(required = false) String last,@RequestParam(required = false) Integer page)
    {
        last = last == null ? "" : last;
        page = page == null ? 1 : page;

        var actors = actorsDao.getActors(last, page);

        return ResponseEntity.ok(actors);
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<?> details(@PathVariable int id)
    {
        var actor = actorsDao.getActorById(id);

        return ResponseEntity.ok(actor);
    }


    @PostMapping("/actors")
    public ResponseEntity<?> addActor(@RequestBody() Actor actor)
    {
        actorsDao.addActor(actor);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/actors/{id}")
    public ResponseEntity<?> editActor(@ModelAttribute("actor") Actor actor, @PathVariable int id)
    {
        actor.setActorId(id);
        actorsDao.updateActor(actor);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/actors/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable int id)
    {
        actorsDao.deleteActor(id);

        return ResponseEntity.ok().build();
    }
}
