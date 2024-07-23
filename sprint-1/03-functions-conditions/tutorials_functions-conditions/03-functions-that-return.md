# Functions that Return Data

In our first 2 examples we saw 
1) a function that did not accept any input
2) a function that accepted several values as input

Neither of these functions **returned** a value.  
We often use functions like these to do something, but
we do not expect any data back from them. Examples include:

* Displaying some information to a user
* Saving infomation to a database
* Saving a file to a folder

But at other times we call a function with the expectation
that it will give us an answer. For example:

* Look up a value from a database
* Perform a calculation and return the result
* Prompt the user for some information, and return the users response

## ALL Functions Specify A Return Type

Whenever you create a function, you define it by specifying the
function signature. A function signature contains 3 things

1) the **RETURN TYPE** of the function
2) the **NAME** of the function
3) any required **PARAMETERS** for the function (optional)

So even the 2 functions that we created before have a **RETURN TYPE**.

### Examples

Let's look at a couple of examples.

```java
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
```

## Calling Functions

We saw earlier that to call a simple DoWork function we just enter it's name as follows.

```csharp
DoWork();
```

Calling a function with a return type is similar, but
because it returns a value we need to have a place to 
store that returned value;

```java
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
```
