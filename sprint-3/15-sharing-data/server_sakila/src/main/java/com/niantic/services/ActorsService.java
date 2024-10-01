package com.niantic.services;

import com.niantic.models.Actor;

import java.util.List;

public interface ActorsService
{
    List<Actor> getActors(String searchName, Integer page);
    Actor getActorById(int id);
    Actor addActor(Actor actor);
    void updateActor(int id, Actor actor);
    void deleteActor(int id);
}
