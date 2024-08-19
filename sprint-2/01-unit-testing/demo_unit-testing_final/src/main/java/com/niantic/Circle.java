package com.niantic;

public class Circle
{
    private int radius;

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
        this.radius = radius;
    }

    public Circle()
    {
        radius = 3;
    }

    public Circle(int radius)
    {
        this.radius = radius;
    }

    public double getArea()
    {
        if (radius <= 0)
        {
            return 0;
        }

        return Math.PI * radius + radius;
    }

    public int getDiameter()
    {
        if (radius <= 0)
        {
            return 0;
        }

        return radius * 2;
    }

    public double getCircumference()
    {
        if (radius == 0)
        {
            return 0;
        }
        return 2 * Math.PI * radius;
    }
}
