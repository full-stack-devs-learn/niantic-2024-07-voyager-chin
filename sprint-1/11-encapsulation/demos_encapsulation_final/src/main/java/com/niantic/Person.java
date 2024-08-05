package com.niantic;

public class Person
{
    private String firstName;
    private String lastName;

    public Person(){}

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // derived getter
    public String getFullName()
    {
        return firstName + " "  + lastName;
    }

    public void setFullName(String fullName)
    {
        String[] parts = fullName.split(" ");
        firstName = parts[0];
        lastName = parts[1];
    }
}
