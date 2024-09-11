package com.niantic.services;

import com.niantic.models.Actor;
import com.niantic.repositories.ActorsDao;

import java.util.ArrayList;

// this is the business logic layer
public class ActorsService
{
    private ActorsDao actorsDao = new ActorsDao();

    public ArrayList<Actor> getAllActors()
    {
        return actorsDao.getAllActors();
    }

    public ArrayList<Actor> searchByLastName(String lastName)
    {
        if(lastName == null || lastName.isEmpty())
        {
            return actorsDao.getAllActors();
        }
        else
        {
            return actorsDao.getActorsByLastName(lastName);
        }
    }

    public Actor getById(int id)
    {
        return actorsDao.getActorById(id);
    }
}
