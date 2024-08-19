package com.niantic.part_1;

public class Rectangle
{
    public int width;
    public int height;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Rectangle()
    {
        width = 5;
        height = 5;
    }

    public Rectangle(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getArea()
    {
        return width * height;
    }

    public int getPerimeter()
    {
        if(width <= 0 || height <= 0)
        {
            return 0;
        }

        return width + height;
    }

}
