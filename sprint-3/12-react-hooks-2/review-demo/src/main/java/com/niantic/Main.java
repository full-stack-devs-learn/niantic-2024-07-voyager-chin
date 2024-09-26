package com.niantic;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        // financial calculations using double or float are imprecise
        double price = 2.33;
        price *=13;
        price -= .10;
        System.out.println("Arithmetic using double: ");
        System.out.println(price);
        System.out.println();

        // calculations with integers are precise
        // so we can process dollars and cents separately
        int dollars = 2;
        int cents = 33;

        dollars *= 13;
        cents *= 13;
        cents -= 10;

        // we need to ensure that cents are never more than 99
        int extraDollars = cents / 100;
        dollars += extraDollars;

        cents = cents % 100;

        System.out.println("Arithmetic using integers: ");
        System.out.println(dollars + "." + cents);
        System.out.println();


        // BigDecimal allows us to do precise financial arithmetic
        // without splitting to dollars and cents
        BigDecimal money = new BigDecimal("2.33");
        money = money.multiply(new BigDecimal("13"));
        money = money.subtract(new BigDecimal(".10"));

        System.out.println("Arithmetic using BigDecimal: ");
        System.out.println(money);

    }
}