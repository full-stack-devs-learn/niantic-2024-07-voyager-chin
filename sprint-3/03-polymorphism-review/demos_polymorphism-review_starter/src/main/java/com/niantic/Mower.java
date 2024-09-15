package com.niantic;

public class Mower implements BladeController
{
    private int bladeSpeed;

    public Mower(int bladeSpeed)
    {
        this.bladeSpeed = bladeSpeed;
    }

    @Override
    public int getBladeSpeed()
    {
        return bladeSpeed;
    }

    @Override
    public void setBladeSpeed(int bladeSpeed)
    {
        this.bladeSpeed = bladeSpeed;
    }

    @Override
    public void turnOn()
    {
        System.out.println("Mower is on at blade speed: " + bladeSpeed);
    }
}
