package com.niantic.shapes;

public class Circle extends Shape
{
    private final double radius;

    public Circle(int x, int y, double radius)
    {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing Circle");
        System.out.println(getPoint());
        System.out.println("Radius: " + radius);
    }
}
