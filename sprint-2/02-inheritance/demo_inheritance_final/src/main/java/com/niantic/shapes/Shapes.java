package com.niantic.shapes;

public class Shapes
{
    public static void main(String[] args)
    {
        System.out.println("Rectangle: ");
        System.out.println("-".repeat(15));
        Rectangle rectangle = new Rectangle(15,30);
        System.out.println(rectangle.getWidth() + " x " + rectangle.getHeight());

        System.out.println();
        System.out.println("Square: ");
        System.out.println("-".repeat(15));
        Square square = new Square(13);
        System.out.println(square.getWidth() + " x " + square.getHeight());
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());

        System.out.println();
        System.out.println("Circle: ");
        System.out.println("-".repeat(15));
        Circle circle = new Circle(6.5);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
    }
}
