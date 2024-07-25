package com.niantic;

public class Main
{
    public static void main(String[] args)
    {
        createArray1();
        String[] heroes = {"Thor","Iron Man","Black Panther", "Black Widow"};
        heroes[0] = "Hulk";
        printArrayInfo(heroes);
        String[] team = {};
        printArrayInfo(team);
    }

    public static void createArray1()
    {
        String chin = "Chin";
        String roxy = "Roxy";

        String[] students;
        students = new String[14];
        students[0] = "Chin";
        students[1] = "Roxy";
        students[2] = "Jessy";
        students[3] = "Karen";
        students[4] = "Valerie";
        students[5] = "Hannah";
        students[6] = "Dureti";
        students[7] = "Tabatha";
        students[8] = "Charletta";
        students[9] = "Eri";
        students[10] = "Robin";
        students[11] = "Jane";
        students[12] = "Jordan";
        students[13] = "Elena";

//        System.out.println(students);
//        System.out.println(students[9]);
//        System.out.println(students.length);
        printArrayInfo(students);
    }

    public static void createArray2()
    {
        // short hand notation to create an array with values
        int[] numbers = new int[]{15, 12, 98, 16};

        // this is what is happening in the background
        int[] nums = new int[4];
        nums[0] = 15;
        nums[1] = 12;
        nums[2] = 9;
        nums[3] = 16;
    }

    public static void printArrayInfo(String[] names)
    {
        if(names.length == 0)
        {
            System.out.println("Array is empty");
            return;
        }

        System.out.println("First Student: " + names[0]);
        System.out.println("Last Student: " + names[names.length - 1]);
        int middleIndex = names.length / 2;
        System.out.println("Middle Student: " + names[middleIndex]);


    }
}