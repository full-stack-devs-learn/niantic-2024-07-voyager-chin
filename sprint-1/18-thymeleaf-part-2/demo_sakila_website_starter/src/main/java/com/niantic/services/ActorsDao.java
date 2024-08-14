package com.niantic.services;

import com.niantic.models.Actor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;

@Component
public class ActorsDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ActorsDao()
    {
        // 1. create a data source
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername("root");
        dataSource.setPassword("P@ssw0rd");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public ArrayList<Actor> getAllActors()
    {
        // 2. execute the query
        var actors = new ArrayList<Actor>();

        String sql = """
                SELECT actor_id
                	, first_name
                    , last_name
                FROM actor;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        // 3. loop through all rows
        //    and create a list of actors
        while(row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            var actor = new Actor(actorId, firstName, lastName);
            actors.add(actor);
        }

        return actors;
    }

    public ArrayList<Actor> getActorsByLastName(String searchName)
    {
        searchName = "%" + searchName + "%";
        // 2. execute the query
        var actors = new ArrayList<Actor>();

        String sql = """
                SELECT actor_id
                	, first_name
                    , last_name
                FROM actor
                WHERE last_name LIKE ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, searchName);

        // 3. loop through all rows
        //    and create a list of actors
        while(row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            var actor = new Actor(actorId, firstName, lastName);
            actors.add(actor);
        }

        return actors;
    }

    public Actor getActorById(int id)
    {
        String sql = """
                SELECT actor_id
                	, first_name
                    , last_name
                FROM actor
                WHERE actor_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, id);

        if(row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            return new Actor(actorId, firstName, lastName);
        }

        return null;
    }

    public void addActor(Actor actor)
    {
        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?,?);";

        jdbcTemplate.update(sql,
                            actor.getFirstName().toUpperCase(),
                            actor.getLastName().toUpperCase());

    }

    public void updateActor(Actor actor)
    {
        String sql = """
                UPDATE actor
                SET first_name = ?
                	, last_name = ?
                WHERE actor_id = ?;
                """;

        jdbcTemplate.update(sql,
                    actor.getFirstName(),
                    actor.getLastName(),
                    actor.getActorId()
                );
    }

    public void deleteActor(int id)
    {
        String sql = "DELETE FROM actor WHERE actor_id = ?;";

        jdbcTemplate.update(sql, id);
    }

}
