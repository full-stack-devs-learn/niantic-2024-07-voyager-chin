package com.niantic.repositories;

import com.niantic.models.Actor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

@Component
public class MySqlActorsDao implements ActorsDao
{
    private final JdbcTemplate jdbcTemplate;

    public MySqlActorsDao()
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
        var actors = new ArrayList<Actor>();

        String sql = """
                SELECT actor_id
                	, first_name
                    , last_name
                FROM actor
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while (row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            var actor = new Actor(actorId, firstName, lastName);
            actors.add(actor);
        }

        return actors;
    }


    public ArrayList<Actor> getActors(String searchName, Integer page)
    {
        searchName = "%" + searchName + "%";
        int pageSize = 10;
        int skip = (page - 1) * pageSize;

        var actors = new ArrayList<Actor>();

        String sql = """
                SELECT actor_id
                	, first_name
                    , last_name
                FROM actor
                WHERE last_name LIKE ?
                LIMIT ?, ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, searchName, skip, pageSize);

        while (row.next())
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

        if (row.next())
        {
            int actorId = row.getInt("actor_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            return new Actor(actorId, firstName, lastName);
        }

        return null;
    }

    public Actor addActor(Actor actor)
    {
        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?,?);";


        // insert a new record and retrieve the generated id
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, actor.getFirstName()
                                        .toUpperCase());
            statement.setString(2, actor.getLastName()
                                        .toUpperCase());

            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey()
                             .intValue();

        return getActorById(newId);

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
