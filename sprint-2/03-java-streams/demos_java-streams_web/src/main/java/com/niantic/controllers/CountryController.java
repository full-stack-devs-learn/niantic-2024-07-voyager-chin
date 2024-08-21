package com.niantic.controllers;

import com.niantic.exercises.Filters;
import com.niantic.models.Country;
import com.niantic.services.FileLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CountryController
{
    private Filters filters = new Filters();

    @GetMapping("/countries/search/region")
    public String getLineItemsByCompany(Model model, @RequestParam(required = false) String search)
    {
        List<Country> countries = FileLoader.loadCountries();
        String searchVal = search == null ? "All" : search;

//        if(search != null && !search.isEmpty())
//        {
//            countries = filters.filterByCompanyName(lineItems, search);
//        }

        model.addAttribute("filter", "Region");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("countries", countries);

        return "countries/index";
    }
}
