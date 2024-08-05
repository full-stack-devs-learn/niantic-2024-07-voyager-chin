package com.niantic.part_1_sakila_dtos;

public class Actor
{
    // Declare private variables:
    private int id;
    private String firstName;
    private String lastName;

    // Parameterless constructor
    public Actor()
    {

    }

    // Parameterized constructor
    public Actor(int id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Public 'getters' and 'setters':
    public int getActorId() { return id; }

    public void setActorId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFullName() { return firstName + " " + lastName; }
}
