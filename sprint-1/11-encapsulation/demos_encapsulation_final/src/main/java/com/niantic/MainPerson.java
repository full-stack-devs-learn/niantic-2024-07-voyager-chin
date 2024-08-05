package com.niantic;

public class MainPerson
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.setFullName("Charletta Harris");

        System.out.println(person.getFirstName() + " " + person.getLastName());
        System.out.println(person.getFullName());

    }
}
