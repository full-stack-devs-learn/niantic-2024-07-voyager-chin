package com.niantic;

import com.niantic.models.LineItem;
import com.niantic.services.FileLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        List<LineItem> lineItems = FileLoader.loadProducts();

    }
}