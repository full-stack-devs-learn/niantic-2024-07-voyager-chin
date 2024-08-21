package com.niantic.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.niantic.models.Country;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader
{
    public static List<Country> loadCountries()
    {
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.readValue(new File("data/countries.json"), new TypeReference<ArrayList<Country>>(){});
        }
        catch(Exception e)
        {
            return new ArrayList<>();
        }
    }
}
