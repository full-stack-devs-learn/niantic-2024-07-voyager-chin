package com.niantic.shapes;

public abstract class Shape
{
    private int x;
    private int y;

    public Shape(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    public abstract void draw();

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public String getPoint()
    {
        return "(" + x + "," + y + ")";
    }
}
