package com.niantic.part_1_sakila_dtos;

public class Customer
{
    // Declare private variables for Customer data
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;

    // Parameterless constructor:
    public Customer()
    {

    }

    // Parameterized constructor:
    public Customer(int customerId, String firstName, String lastName, String email, String address, String city, String state, String zip, String country, String phone)
    {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
    }

    // Public 'getters' and 'setters':
    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFullName() { return firstName + " " + lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }

    public void setZip(String zip) { this.zip = zip; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }
}
