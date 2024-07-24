package com.niantic;

public class Functions03
{
    public static void main(String[] args)
    {    
        doWork();

        // this line of code calls the Add function
        // but it ignores the returned value
        // so it appears as though it did not do anything
        add(12.5, 52.1);
        System.out.println("I have no way of knowing what was returend.");
    
        double answer;
        // we need a variable to store the returned value
        answer = add(12.5, 52.1);
        System.out.println("Answer: " + answer);
    
        // you can call the function again with different values
        answer = add(10, 5);
        System.out.println("Answer: " + answer);
    }
        
    // Signature:
    // RETURN TYPE: void - this means it will NOT return anything
    // NAME: doWork
    // PARAMETERS: none
    public static void doWork()
    {
        System.out.println("This code is INSIDE a function");
        // NO return statement because this function is VOID
    }

    // Signature:
    // RETURN TYPE: double - this is a contract - and the function MUST return a double
    // NAME: add
    // PARAMETERS: first, second
    public static double add(double first, double second)
    {
        double answer = first + second;
        // the RETURN statement is REQUIRED
        return answer;
    }
}
