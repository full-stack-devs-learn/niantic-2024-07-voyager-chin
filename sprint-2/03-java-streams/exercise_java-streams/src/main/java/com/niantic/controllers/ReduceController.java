package com.niantic.controllers;

import com.niantic.exercises.Filters;
import com.niantic.exercises.Maps;
import com.niantic.exercises.Reducers;
import com.niantic.models.LineItem;
import com.niantic.services.FileLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReduceController
{
    private Filters filters = new Filters();
    private Maps maps = new Maps();
    private Reducers reducer = new Reducers();

    @GetMapping("/reduce/search/company")
    public String getLineItemsByCompany(Model model, @RequestParam(required = false) String search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapCompanyNames(lineItems);

        String searchVal = search == null ? "All" : search;
        if (search != null && !search.isEmpty())
        {
            lineItems = filters.filterByCompanyName(lineItems, search);
        }

        try
        {
            var totalSales = reducer.totalSales(lineItems);
            var averageSalesPerLine = reducer.averageSalesPerLineItem(lineItems);
            var averageSalesPerItem = reducer.averageSalesPerItem(lineItems);
            var maxLineItem = reducer.maxLineItem(lineItems);
            var minLineItem = reducer.minLineItem(lineItems);
            var totalItems = reducer.totalItemCount(lineItems);
            var averageItemCountPerLine = reducer.averageItemCount(lineItems);

            model.addAttribute("totalSales", totalSales);
            model.addAttribute("totalLine", lineItems.size());
            model.addAttribute("averageSalesPerLine", averageSalesPerLine);
            model.addAttribute("averageSalesPerItem", averageSalesPerItem);
            model.addAttribute("maxLineItem", maxLineItem);
            model.addAttribute("minLineItem", minLineItem);
            model.addAttribute("totalItems", totalItems);
            model.addAttribute("averageItemCountPerLine", averageItemCountPerLine);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        model.addAttribute("options", options);
        model.addAttribute("filter", "Company Name");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);

        return "line-items/report";
    }

    @GetMapping("/reduce/search/category")
    public String getLineItemsByCategory(Model model, @RequestParam(required = false) String search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapCategories(lineItems);

        String searchVal = search == null ? "All" : search;
        if (search != null && !search.isEmpty())
        {
            lineItems = filters.filterByCategory(lineItems, search);
        }

        var totalSales = reducer.totalSales(lineItems);
        var averageSalesPerLine = reducer.averageSalesPerLineItem(lineItems);
        var averageSalesPerItem = reducer.averageSalesPerItem(lineItems);
        var maxLineItem = reducer.maxLineItem(lineItems);
        var minLineItem = reducer.minLineItem(lineItems);
        var totalItems = reducer.totalItemCount(lineItems);
        var averageItemCountPerLine = reducer.averageItemCount(lineItems);

        model.addAttribute("totalSales", totalSales);
        model.addAttribute("totalLine", lineItems.size());
        model.addAttribute("averageSalesPerLine", averageSalesPerLine);
        model.addAttribute("averageSalesPerItem", averageSalesPerItem);
        model.addAttribute("maxLineItem", maxLineItem);
        model.addAttribute("minLineItem", minLineItem);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("averageItemCountPerLine", averageItemCountPerLine);

        model.addAttribute("options", options);
        model.addAttribute("filter", "Category");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);

        return "line-items/report";
    }

    @GetMapping("/reduce/search/product")
    public String getLineItemsByProduct(Model model, @RequestParam(required = false) String search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapProducts(lineItems);

        String searchVal = search == null ? "All" : search;
        if (search != null && !search.isEmpty())
        {
            lineItems = filters.filterByProduct(lineItems, search);
        }

        var totalSales = reducer.totalSales(lineItems);
        model.addAttribute("totalLine", lineItems.size());
        var averageSalesPerLine = reducer.averageSalesPerLineItem(lineItems);
        var averageSalesPerItem = reducer.averageSalesPerItem(lineItems);
        var maxLineItem = reducer.maxLineItem(lineItems);
        var minLineItem = reducer.minLineItem(lineItems);
        var totalItems = reducer.totalItemCount(lineItems);
        var averageItemCountPerLine = reducer.averageItemCount(lineItems);

        model.addAttribute("totalSales", totalSales);
        model.addAttribute("averageSalesPerLine", averageSalesPerLine);
        model.addAttribute("averageSalesPerItem", averageSalesPerItem);
        model.addAttribute("maxLineItem", maxLineItem);
        model.addAttribute("minLineItem", minLineItem);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("averageItemCountPerLine", averageItemCountPerLine);

        model.addAttribute("options", options);
        model.addAttribute("filter", "Product");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);

        return "line-items/report";
    }

    @GetMapping("/reduce/search/year")
    public String getLineItemsByYear(Model model, @RequestParam(required = false) Integer search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapYears(lineItems);

        String searchVal = search == null ? "All" : search.toString();

        if (search != null)
        {
            lineItems = filters.filterByYear(lineItems, search);
        }

        var totalSales = reducer.totalSales(lineItems);
        var averageSalesPerLine = reducer.averageSalesPerLineItem(lineItems);
        var averageSalesPerItem = reducer.averageSalesPerItem(lineItems);
        var maxLineItem = reducer.maxLineItem(lineItems);
        var minLineItem = reducer.minLineItem(lineItems);
        var totalItems = reducer.totalItemCount(lineItems);
        var averageItemCountPerLine = reducer.averageItemCount(lineItems);

        model.addAttribute("totalSales", totalSales);
        model.addAttribute("totalLine", lineItems.size());
        model.addAttribute("averageSalesPerLine", averageSalesPerLine);
        model.addAttribute("averageSalesPerItem", averageSalesPerItem);
        model.addAttribute("maxLineItem", maxLineItem);
        model.addAttribute("minLineItem", minLineItem);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("averageItemCountPerLine", averageItemCountPerLine);

        model.addAttribute("options", options);
        model.addAttribute("filter", "Year");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);

        return "line-items/report";
    }

    @GetMapping("/reduce/search/order-id")
    public String getLineItemsByOrderId(Model model, @RequestParam(required = false) Integer search)
    {
        List<LineItem> lineItems = FileLoader.loadLineItems();

        var options = maps.mapOrderIds(lineItems);

        String searchVal = search == null ? "All" : search.toString();

        if (search != null)
        {
            lineItems = filters.filterByOrderId(lineItems, search);
        }

        var totalSales = reducer.totalSales(lineItems);
        var averageSalesPerLine = reducer.averageSalesPerLineItem(lineItems);
        var averageSalesPerItem = reducer.averageSalesPerItem(lineItems);
        var maxLineItem = reducer.maxLineItem(lineItems);
        var minLineItem = reducer.minLineItem(lineItems);
        var totalItems = reducer.totalItemCount(lineItems);
        var averageItemCountPerLine = reducer.averageItemCount(lineItems);

        model.addAttribute("totalSales", totalSales);
        model.addAttribute("totalLine", lineItems.size());
        model.addAttribute("averageSalesPerLine", averageSalesPerLine);
        model.addAttribute("averageSalesPerItem", averageSalesPerItem);
        model.addAttribute("maxLineItem", maxLineItem);
        model.addAttribute("minLineItem", minLineItem);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("averageItemCountPerLine", averageItemCountPerLine);

        model.addAttribute("options", options);
        model.addAttribute("filter", "Order Id");
        model.addAttribute("search", search);
        model.addAttribute("searchVal", searchVal);

        return "line-items/report";
    }
}
