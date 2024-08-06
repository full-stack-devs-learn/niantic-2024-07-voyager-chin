package com.niantic.part_2_objects;

public class Circle
{
    // Declare private variables for Circle
    private int radius;


    // Parameterless constructor:
    public Circle()
    {

    }


    // Parameterized constructor:
    public Circle(int radius) { this.radius = radius; }


    // Public 'getters' and 'setters':
    public int getRadius() { return radius; }

    public void setRadius(int radius) { this.radius = radius; }

    public double getArea() { return Math.PI * Math.pow(this.radius, 2); }

    public double calculateArea(int radius) { return Math.PI * Math.pow(radius, 2); }

    public int getDiameter() { return this.radius * 2; }

    public int calculateDiameter(int radius) { return radius * 2; }

    public double getCircumference() { return getDiameter() * Math.PI; }

    public double calculateCircumference(int radius) { return calculateDiameter(radius) * Math.PI; }
}
