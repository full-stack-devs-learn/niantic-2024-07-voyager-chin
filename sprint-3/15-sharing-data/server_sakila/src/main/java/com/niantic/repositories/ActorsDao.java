package com.niantic.repositories;

import com.niantic.models.Actor;

import java.util.ArrayList;

public interface ActorsDao
{
    ArrayList<Actor> getAllActors();
    ArrayList<Actor> getActors(String searchName, Integer page);
    Actor getActorById(int id);
    Actor addActor(Actor actor);
    void updateActor(Actor actor);
    void deleteActor(int id);
}
