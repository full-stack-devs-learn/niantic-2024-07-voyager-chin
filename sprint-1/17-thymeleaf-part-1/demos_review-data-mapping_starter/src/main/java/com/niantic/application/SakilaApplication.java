package com.niantic.application;

import com.niantic.models.Actor;
import com.niantic.services.ActorDao;

import java.util.Scanner;

public class SakilaApplication
{
    private static Scanner userInput = new Scanner(System.in);
    private static ActorDao dao = new ActorDao();

    public void run()
    {
        while (true)
        {
            int choice = getChoice();
            switch (choice)
            {
                case 1:
                    listAllActors();
                    break;
                case 2:
                    displayActorById();
                    break;
                case 3:
                    addActor();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    return;
            }
        }
    }

    public int getChoice()
    {
        System.out.println("Welcome to Sakila Application");
        System.out.println("-".repeat(50));
        System.out.println("1. List All Actors");
        System.out.println("2. Display Actor Details");
        System.out.println("3. Add Actor");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        return Integer.parseInt(userInput.nextLine());
    }

    public void listAllActors()
    {
        System.out.print("Enter an actor's last name: ");
        String lastName = userInput.nextLine();
        var actors = dao.getActorsByLastName(lastName);

        actors.forEach(actor -> System.out.println(actor));
    }

    public void displayActorById()
    {
        System.out.print("Enter an actor id: ");
        int actorId = userInput.nextInt();
        userInput.nextLine();

        var actor = dao.getActorById(actorId);

        System.out.println(actor);
    }

    public void addActor()
    {
        System.out.print("Enter first name: ");
        String firstName = userInput.nextLine()
                                    .strip();

        System.out.print("Enter last name: ");
        String lastName = userInput.nextLine()
                                   .strip();

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
        catch (Exception ex)
        {
            System.out.println(STR."\{firstName} \{lastName} could not be added to the database.");
        }
    }
}
