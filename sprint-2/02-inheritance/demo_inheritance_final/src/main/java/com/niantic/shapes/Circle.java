package com.niantic.shapes;


public class Circle extends Square
{
    public double getRadius()
    {
        return super.getHeight() / 2;
    }

    public double getDiameter()
    {
        return getHeight();
    }

    public Circle(double radius)
    {
        super(radius * 2);
    }

    @Override
    public double getArea()
    {
        //return super.getArea() * Math.PI / 4;
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * getRadius();
    }
}
