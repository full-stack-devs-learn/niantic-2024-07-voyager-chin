package com.niantic.shapes;

public class Rectangle extends Shape
{
    private double width;
    private double height;

    public Rectangle(int x, int y, double width, double height)
    {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea()
    {
        return width * height;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing Rectangle");
        System.out.println("X: " + getX());
        System.out.println("Y: " + getY());
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}
