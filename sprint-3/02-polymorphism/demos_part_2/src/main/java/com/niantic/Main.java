package com.niantic;


import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
//        polymorphismDemos();
        listDemos();
    }

    public static void listDemos()
    {
        List<Athlete> athletes = new ArrayList<>();
        athletes.add(new Student("John", "Doe"));
        athletes.add(new HockeyPlayer("Jane", "Doe"));

        athletes.forEach(athlete -> {
            athlete.train();
            if(athlete instanceof Musician)
            {
                Musician musician = (Musician) athlete;
                musician.perform();
            }
        });
    }

    public static void polymorphismDemos()
    {
        long bigNumber = 500;
        int smallNumber = (int)bigNumber;

        Musician chloe = new Student("Chloe", "Rose");
        Athlete chloeAthlete = (Athlete)chloe;

        // this checks if the variable is of type Student
        // because we need to know if we
        // can type cast it to a Student to use the methods
        if(chloeAthlete instanceof Student)
        {
            Student chloeStudent = (Student) chloeAthlete;
            chloeStudent.setLastName("Rosy");
        }


        displayAthlete(chloeAthlete);

        HockeyPlayer hockeyPlayer = new HockeyPlayer("Hockey", "Rose");
        displayAthlete(hockeyPlayer);

        List<Athlete> team = new ArrayList<>();
        team.add(hockeyPlayer);
        team.add(chloeAthlete);

        team.forEach(player -> {
            player.train();
        });

        List<Musician> musicians = new ArrayList<>();
        musicians.add(chloe);
//        musicians.add(hockeyPlayer);

    }

    public static void displayAthlete(Athlete athlete)
    {
        athlete.train();
        athlete.compete();
    }
}