package com.niantic;

import com.niantic.services.FileLoader;

public class ContriesApp
{
    public static void main(String[] args)
    {
        countriesByRegion();
    }

    public static void countriesByRegion()
    {
        var countries = FileLoader.loadCountries();


        var caribbeanCountries = countries.stream()
                                          .filter(country -> country.getRegion().equalsIgnoreCase("Caribbean"))
                                          .toList();

        caribbeanCountries.forEach(country -> {
            System.out.println(country.getName() + " (" + country.getPopulation() + ")");
        });

        long start = 0;

        var totalPopulation = caribbeanCountries.stream()
                                       .map(country -> country.getPopulation())
                                       .reduce(start, (temp, current) -> temp + current);

        var sumAge = caribbeanCountries.stream()
                                       .map(country -> country.getLifeExpectancy())
                                       .reduce(0.0, (sum, age) -> sum + age);

        var averageAge = sumAge / caribbeanCountries.size();


        System.out.println();
        System.out.println("Total population in the Caribbean: " + totalPopulation);
        System.out.println("Average life expectancy in the Caribbean: " + averageAge);
    }
}
