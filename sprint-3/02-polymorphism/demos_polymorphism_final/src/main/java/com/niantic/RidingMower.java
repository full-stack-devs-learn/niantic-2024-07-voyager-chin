package com.niantic;

public class RidingMower extends Car implements BladeController
{
    private int bladeSpeed;

    public RidingMower(String make, String model, int bladeSpeed)
    {
        super(make, model);
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
        super.turnOn();
        System.out.println("Riding Mower is on");
    }
}
