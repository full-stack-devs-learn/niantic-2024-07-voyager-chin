package com.niantic.controllers;

import com.niantic.exercises.Filters;
import com.niantic.exercises.Maps;
import com.niantic.models.LineItem;
import com.niantic.services.FileLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MapsController
{
    private Filters filters = new Filters();
    private Maps maps = new Maps();

    @GetMapping("/maps/search/company")
    public String getLineItemsByCompany(Model model, @RequestParam(required = false) String search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapCompanyNames(lineItems);

        String searchVal = search == null ? "All" : search;
        if (search != null && !search.isEmpty())
        {
            lineItems = filters.filterByCompanyName(lineItems, search);
        }

        model.addAttribute("options", options);
        model.addAttribute("filter", "Company Name");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("lineItems", lineItems);

        return "line-items/dropdowns";
    }

    @GetMapping("/maps/search/category")
    public String getLineItemsByCategory(Model model, @RequestParam(required = false) String search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapCategories(lineItems);

        String searchVal = search == null ? "All" : search;
        if (search != null && !search.isEmpty())
        {
            lineItems = filters.filterByCategory(lineItems, search);
        }

        model.addAttribute("options", options);
        model.addAttribute("filter", "Category");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("lineItems", lineItems);

        return "line-items/dropdowns";
    }

    @GetMapping("/maps/search/product")
    public String getLineItemsByProduct(Model model, @RequestParam(required = false) String search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapProducts(lineItems);

        String searchVal = search == null ? "All" : search;
        if (search != null && !search.isEmpty())
        {
            lineItems = filters.filterByProduct(lineItems, search);
        }

        model.addAttribute("options", options);
        model.addAttribute("filter", "Product");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("lineItems", lineItems);

        return "line-items/dropdowns";
    }

    @GetMapping("/maps/search/year")
    public String getLineItemsByYear(Model model, @RequestParam(required = false) Integer search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapYears(lineItems);

        String searchVal = search == null ? "All" : search.toString();

        if (search != null)
        {
            lineItems = filters.filterByYear(lineItems, search);
        }

        model.addAttribute("options", options);
        model.addAttribute("filter", "Year");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("lineItems", lineItems);

        return "line-items/dropdowns";
    }

    @GetMapping("/maps/search/order-id")
    public String getLineItemsByOrderId(Model model, @RequestParam(required = false) Integer search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapOrderIds(lineItems);

        String searchVal = search == null ? "All" : search.toString();

        if (search != null)
        {
            lineItems = filters.filterByOrderId(lineItems, search);
        }

        model.addAttribute("options", options);
        model.addAttribute("filter", "Order Id");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);
        model.addAttribute("lineItems", lineItems);

        return "line-items/dropdowns";
    }
}
