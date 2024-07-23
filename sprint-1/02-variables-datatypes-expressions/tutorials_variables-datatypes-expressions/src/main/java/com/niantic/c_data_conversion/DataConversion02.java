package com.niantic.c_data_conversion;

public class DataConversion02
{
    public static void main(String[] args)
    {
        String ageValue = "25";
        int age = Integer.parseInt(ageValue);
        age += 1;
        System.out.println(age); // prints 26;

        String priceValue = "15.50";
        double price = Double.parseDouble(priceValue);
        double discount = price * .1;
        System.out.println("The 10% discount is " + discount);
    }
}
