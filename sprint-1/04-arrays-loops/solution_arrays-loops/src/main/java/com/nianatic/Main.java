package com.nianatic;

public class Main
{
    public static void main(String[] args)
    {
        // sandbox
        testExercises();
        testExercisesChallenge();
    }

    public static void testExercises()
    {
        Exercises exercises = new Exercises();

        // 1 get days of the week
        String[] days = exercises.daysOfTheWeek();
        System.out.println(days.length + " should be 7");
    }

    public static void testExercisesChallenge()
    {
        ExercisesChallenge exercises = new ExercisesChallenge();

        int sum2 = exercises.sumFirst2Numbers(new int[]{1,1,2,3,5,8});
        System.out.println(sum2 + " should be 2");
    }
}