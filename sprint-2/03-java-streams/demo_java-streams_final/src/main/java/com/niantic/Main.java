package com.niantic;

import com.mysql.cj.conf.IntegerProperty;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        stringsDemo();
        numbersDemo();

    }

    public static void stringsDemo()
    {
        // source
        List<String> names = Arrays.asList("Emily", "Lucas", "Sophia", "Edward", "Mason", "Olivia", "Ethan", "Isabella", "Liam", "Charlotte", "Benjamin");

        var sortedNames = names.stream() // Extract
                               .filter(name -> name.toLowerCase().startsWith("e")) // Transform removes unwanted rows
                               .sorted((first, second) -> -first.compareTo(second)) // Transform changes the order of remaining items
//                               .map(name -> name.length()) // Transform - changes from String to int
//                               .reduce(0, (tempSum, currentNumber) -> tempSum + currentNumber); // collects the data
                               .toList(); //Destination - collects items back into a List

        sortedNames.forEach(name -> System.out.println(name));
    }

    public static void numbersDemo()
    {
        List<Integer> numbers = Arrays.asList(new Integer[]{15, 3, 9 ,56 ,21 ,7 ,58 ,13});

        var sum = numbers.stream()
                         .reduce(0, (temp, number) -> temp + number);

        var max = numbers.stream()
                         .reduce(numbers.get(0), (temp, number) -> temp > number ? temp : number);

        var min = numbers.stream()
                         .reduce(numbers.get(0), (temp, number) -> temp < number ? temp : number);

        System.out.println("sum: " + sum);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}