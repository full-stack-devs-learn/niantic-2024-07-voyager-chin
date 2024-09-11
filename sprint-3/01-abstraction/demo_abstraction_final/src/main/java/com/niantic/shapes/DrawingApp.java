package com.niantic.shapes;

import java.util.ArrayList;

public class DrawingApp
{
    public static void main(String[] args)
    {
//        Shape shape = new Shape(2,2);
//        System.out.println(shape.getPoint());
//        System.out.println(shape.getArea());
//        shape.draw();
//        System.out.println();


        Rectangle rectangle = new Rectangle(3,3,5,10);
        Circle circle = new Circle(13,5,5);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(circle);

        shapes.forEach(shape ->  {
            shape.draw();
            System.out.println(shape.getArea());
            System.out.println();
        });
    }
}
