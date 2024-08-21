package com.niantic.exercises;


import com.niantic.models.Country;

import java.util.List;

public class Filters
{

    public List<Country> filterByRegion(List<Country> countries, String search)
    {
        var filteredList = countries.stream()
                                    .filter(country -> country.getRegion().equalsIgnoreCase(search))
                                    .toList();

        return filteredList;
    }


}
