package com.niantic.part_2_objects;

public class Rectangle
{
    // Declare private variables for Rectangle:
    private int width;
    private int height;
    private int area;

    // Parameterless constructor:
    public Rectangle()
    {

    }

    // Parameterized constructor:
    public Rectangle(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    // Public 'getters' and 'setters':
    public int getWidth() { return width; }

    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public int getArea() { return this.width * this.height; }

    public int calculateArea(int width, int height) { return width * height; }
}
