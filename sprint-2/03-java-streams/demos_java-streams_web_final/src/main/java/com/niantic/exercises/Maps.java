package com.niantic.exercises;

import com.niantic.models.Country;

import java.util.List;

public class Maps
{
    public List<String> getRegions(List<Country> countries)
    {
        var regions = countries.stream()
                .map(country -> country.getRegion())
                .distinct()
                .sorted()
                .toList();

        return regions;
    }
}
