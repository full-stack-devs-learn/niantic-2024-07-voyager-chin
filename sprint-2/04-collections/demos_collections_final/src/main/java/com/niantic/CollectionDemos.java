package com.niantic;

import com.niantic.models.Card;

import java.util.*;

public class CollectionDemos
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
//        cardDemo();
//        mapDemo();
//        System.out.println();
//        setDemo();
//        System.out.println();
        queueDemo();
//        System.out.println();
//        stackDemo();
//        System.out.println();
    }

    public static void cardDemo()
    {
        Card aceSpades = new Card("Spades","Q");
        System.out.println(aceSpades.getPointValue());
    }

    public static void mapDemo()
    {
        Map<String, Integer> weekdays = new LinkedHashMap<>() ;

        weekdays.put("Sunday", 1);
        weekdays.put("Monday", 2);
        weekdays.put("Tuesday", 3);
        weekdays.put("Wednesday", 4);
        weekdays.put("Thursday", 5);
        weekdays.put("Friday", 6);
        weekdays.put("Saturday", 7);

        System.out.println("Please enter the day of the week");
        System.out.println("---------------------------------");

        var keySet = weekdays.keySet();
        keySet.forEach(key -> System.out.println(key));

        //weekdays.forEach((key, value) -> System.out.println(key));

        System.out.print("Enter your selection: ");
        String selection = input.nextLine().strip();


        int dayOfWeek = weekdays.get(selection);
        System.out.println("You selected " + selection + " which is day " + dayOfWeek);
    }

    public static void setDemo()
    {
        List<String> days = new ArrayList<>();

        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Saturday");
        days.add("Saturday");
        days.add("Saturday");
        days.add("Saturday");
        days.add("Saturday");

        Set<String> distinctDays = new LinkedHashSet<>(days);

        var uniqueDays = days.stream()
                             .distinct()
                             .toList();

        uniqueDays.forEach(day -> System.out.println(day));

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
            System.out.println("Do you want another turn? (y/n/r for reverse) ");
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase("y"))
            {
                players.offer(player);
            }

            if(answer.equalsIgnoreCase("r"))
            {
                reverse(players);
                players.offer(player);
            }
        }
        System.out.println("Game over... finally");
    }

    public static void reverse(Queue<String> players)
    {
        Stack<String> tempStack = new Stack<>();

        // move all player from the queue to the stack
        while (!players.isEmpty())
        {
            tempStack.push(players.poll());
        }

        // move all players from the stack back to the queue
        while (!tempStack.isEmpty())
        {
            players.offer(tempStack.pop());
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