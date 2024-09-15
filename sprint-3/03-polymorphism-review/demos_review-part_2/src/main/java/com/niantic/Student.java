package com.niantic;

public class Student extends Person implements Academic, Musician, Athlete
{
    public Student(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    @Override
    public void study()
    {
        System.out.printf("%s is studying.\n", this.getFirstName());
    }

    @Override
    public void takeTest()
    {
        System.out.printf("%s is taking a test.\n", this.getFirstName());
    }

    @Override
    public void train()
    {
        System.out.printf("%s is training in volleyball.\n", this.getFirstName());
    }

    @Override
    public void compete()
    {
        System.out.printf("%s is playing in a volleyball match.\n", this.getFirstName());
    }

    @Override
    public void practice()
    {
        System.out.printf("%s is practicing voice scales.\n", this.getFirstName());
    }

    @Override
    public void perform()
    {
        System.out.printf("%s is singing in a musical.\n", this.getFirstName());
    }
}
