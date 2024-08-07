package com.niantic;

import com.niantic.models.Actor;
import com.niantic.services.ActorDao;

import java.util.Scanner;

public class ActorsApplication
{
    private static Scanner userInput = new Scanner(System.in);
    private static ActorDao dao = new ActorDao();

    public static void main(String[] args)
    {
//       listAllActors();
        addActor();
    }

    public static void listAllActors()
    {
        System.out.print("Enter an actor's last name: ");
        String  lastName = userInput.nextLine();
        var actors = dao.getActorsByLastName(lastName);

        actors.forEach(actor -> System.out.println(actor));
    }

    public static void displayActorById()
    {
        System.out.print("Enter an actor id: ");
        int actorId = userInput.nextInt();
        userInput.nextLine();

        var actor = dao.getActorById(actorId);

        System.out.println(actor);
    }

    public static void addActor()
    {
        System.out.print("Enter first name: ");
        String firstName = userInput.nextLine().strip();

        System.out.print("Enter last name: ");
        String lastName = userInput.nextLine().strip();

//        // option 1
//        Actor actor = new Actor(0, firstName, lastName);

//        // option 2
//        Actor actor = new Actor();
//        actor.setFirstName(firstName);
//        actor.setLastName(lastName);

        Actor actor = new Actor()
        {{
            setFirstName(firstName);
            setLastName(lastName);
        }};

        try
        {
            dao.addActor(actor);

            System.out.println(STR."\{firstName} has been created.");
        }
        catch(Exception ex)
        {
            System.out.println(STR."\{firstName} \{lastName} could not be added to the database.");
        }
    }
}
