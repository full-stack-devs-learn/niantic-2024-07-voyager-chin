package com.niantic;

import java.util.*;

public class CollectionDemos
{
    public static void main(String[] args)
    {
        mapDemo();
//        System.out.println();
//        setDemo();
//        System.out.println();
//        queueDemo();
//        System.out.println();
//        stackDemo();
//        System.out.println();
    }

    public static void mapDemo()
    {
        Map<String, Integer> weekdays = new HashMap<>();

        weekdays.put("Sunday", 1);
        weekdays.put("Monday", 2);
        weekdays.put("Tuesday", 3);
        weekdays.put("Wednesday", 4);
        weekdays.put("Thursday", 5);
        weekdays.put("Friday", 6);
        weekdays.put("Saturday", 7);

        weekdays.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void setDemo()
    {
        Set<String> days = new HashSet<>();

        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");

        days.forEach(day -> System.out.println(day));

        System.out.println();
    }

    public static void queueDemo()
    {
        Queue<String> players = new LinkedList<>();

        players.offer("Emily");
        players.offer("Lucas");
        players.offer("Sophia");
        players.offer("Mason");

        while(!players.isEmpty())
        {
            String player = players.poll();
            System.out.println(player);
        }
    }

    public static void stackDemo()
    {
        Stack<String> players = new Stack<>();

        players.push("Emily");
        players.push("Lucas");
        players.push("Sophia");
        players.push("Mason");

        while(!players.isEmpty())
        {
            String player = players.pop();
            System.out.println(player);
        }
    }
}