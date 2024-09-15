package com.niantic;

public class HockeyPlayer extends Person implements Athlete
{
    public HockeyPlayer(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    @Override
    public void train()
    {
        System.out.printf("%s is practicing Hockey.\n", this.getFirstName());
    }

    @Override
    public void compete()
    {
        System.out.printf("%s is playing in a hockey game.\n", this.getFirstName());
    }
}
