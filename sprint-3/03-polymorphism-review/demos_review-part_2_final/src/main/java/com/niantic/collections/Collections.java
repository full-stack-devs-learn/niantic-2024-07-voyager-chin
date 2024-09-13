package com.niantic.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Collections
{
    public static void main(String[] args)
    {
        //List<String> team = new ArrayList<>();
        List<String> team = new GregorsMeebers(14);

        addName(team,"Charletta");
        addName(team,"Charletta");
        addName(team,"Chin");
        addName(team,"Chin");
        addName(team,"Dureti");
        addName(team,"Dureti");
        addName(team,"Elena");
        addName(team,"Elena");
        addName(team,"Eri");
        addName(team,"Eri");
        addName(team,"Hannah");
        addName(team,"Hannah");
        addName(team,"Jane");
        addName(team,"Jane");
        addName(team,"Jessy");
        addName(team,"Jessy");
        addName(team,"Jordan");
        addName(team,"Jordan");
        addName(team,"Karen");
        addName(team,"Karen");
        addName(team,"Robin");
        addName(team,"Robin");
        addName(team,"Roxy");
        addName(team,"Roxy");
        addName(team,"Tabatha");
        addName(team,"Tabatha");
        addName(team,"Valerie");
        addName(team,"Valerie");

        addName(team,"John");
        addName(team,"Bob");
        addName(team,"Jack");

        System.out.println();
        team.forEach(System.out::println);
    }

    public static void addName(List<String> names, String name)
    {
        try
        {
            names.add(name);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
