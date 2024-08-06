package com.niantic.part_3_challenge;

public class Refrigerator
{
    // Declare private variables for Refrigerator
    private int currentTemperature;
    private int maxCapacity = 100;
    private int available = 100;
    private boolean isDoorOpen = false;


    // Parameterized constructor:
    public Refrigerator(int currentTemperature, int maxCapacity)
    {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
    }


    // Public 'getters' and 'setters':
    public int getCurrentTemperature() { return currentTemperature; }

    public int getMaxCapacity() { return maxCapacity; }

    public int getAvailableCapacity() { return available; }

    public boolean isDoorOpen() { return isDoorOpen; }

    public void openDoor() { isDoorOpen = true; }

    public void closeDoor() { isDoorOpen = false; }

    public boolean addItem(int capacity)
    {
        if (isDoorOpen)
        {
            if (capacity <= available)
            {
                available -= capacity;
                return true;
            } else { return false;}
        }
        else
        { return false; }
    }

    public int removeItem(int capacity)
    {
        if (isDoorOpen)
        {
            if (available - capacity >= 0)
            {
                available += capacity;
                return getAvailableCapacity();
            }
        } return getAvailableCapacity();
    }

}
