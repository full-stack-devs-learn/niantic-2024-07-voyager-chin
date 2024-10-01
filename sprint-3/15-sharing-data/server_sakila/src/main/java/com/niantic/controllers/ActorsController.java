package com.niantic.controllers;

import com.niantic.models.Actor;
import com.niantic.services.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ActorsController
{
    private final ActorsService actorsService;

    @Autowired
    public ActorsController(ActorsService actorsService)
    {
        this.actorsService = actorsService;
    }

    // http://localhost:8080/actors
    @GetMapping("/actors")
    public ResponseEntity<?> getActors(@RequestParam(required = false) String last, @RequestParam(required = false) Integer page)
    {
        var actors = actorsService.getActors(last, page);

        return ResponseEntity.ok(actors);
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<?> details(@PathVariable int id)
    {
        var actor = actorsService.getActorById(id);

        return ResponseEntity.ok(actor);
    }


    @PostMapping("/actors")
    public ResponseEntity<?> addActor(@RequestBody() Actor actor)
    {
        var newActor = actorsService.addActor(actor);
        return ResponseEntity.ok(newActor);
    }

    @PutMapping("/actors/{id}")
    public ResponseEntity<?> editActor(@ModelAttribute("actor") Actor actor, @PathVariable int id)
    {
        actorsService.updateActor(id, actor);

        return ResponseEntity.ok()
                             .build();
    }

    @DeleteMapping("/actors/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable int id)
    {
        actorsService.deleteActor(id);

        return ResponseEntity.ok()
                             .build();
    }
}
