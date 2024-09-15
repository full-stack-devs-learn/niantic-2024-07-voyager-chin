package com.niantic;

public abstract class Car implements Drivable
{
    private String make;
    private String model;

    public Car(String make, String model)
    {
        this.make = make;
        this.model = model;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    @Override
    public void turnOn()
    {
        System.out.println(make + " " + model + " is now on");
    }
}
