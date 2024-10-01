package com.niantic.services;

import com.niantic.models.Actor;
import com.niantic.repositories.ActorsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SakilaActorsService implements ActorsService
{
    private final ActorsDao actorsDao;

    @Autowired
    public SakilaActorsService(ActorsDao actorsDao)
    {
        this.actorsDao = actorsDao;
    }

    @Override
    public List<Actor> getActors(String last, Integer page)
    {
        last = last == null ? "" : last;

        List<Actor> actors;
        if(page != null)
        {
            actors = actorsDao.getActors(last, page);
        }
        else
        {
            actors = actorsDao.getAllActors();
        }

        return actors;
    }

    @Override
    public Actor getActorById(int id)
    {
        return actorsDao.getActorById(id);
    }

    @Override
    public Actor addActor(Actor actor)
    {
        return actorsDao.addActor(actor);
    }

    @Override
    public void updateActor(int id, Actor actor)
    {
        actor.setActorId(id);
        actorsDao.updateActor(actor);
    }

    @Override
    public void deleteActor(int id)
    {
        actorsDao.deleteActor(id);
    }
}
