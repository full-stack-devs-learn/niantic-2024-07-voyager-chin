# Writing a function

After seeing the copy and paste method of writing code, we want to reduce the amount code that is repeated.

We are now going to make our code more **DRY** (Don't Repeat Yourself).

The code below is a basic structure of a function. Execute the block of code to create the function.

```java
// Header -> this is the function signature and defines the name of the function
//           we will discuss function signatures in greater detail later
// Body -> the function body is surrounded by {}
//         this is the code that executes when the function is called
public static void DoWork()
{
    System.out.println("This code is INSIDE a function");
}

// Note that when you execute this code there will be NO OUTPUT.
// This block ONLY creates the function, it does not execute it
```

## Calling a Function

To call a function you must simply enter/type it's name followed by parenthesis '()'

```java
DoWork();
```

You can call a function as many times as you want, and each call will execute the function. This is the major benefit of using functions, the fact that you can re-use them with very little code.

```java
DoWork();
DoWork();
// Make another call (or several) to the DoWork function
// and execute this block
```

## Team Information

Let's use a function to make displaying team information a bit easier to manage.

The example above was a very simple function. The function that we are about to write is more complex. We need data about each team in order to display the correct information. This is done by adding parameters.

The code below takes the lines of code that were repeated and we will turn them into a function. The function WILL NOT include the specific text and numbers for each team. Instead, we will just create parameters (variables) which will allow us to change the values for each team.

### Instructions

Look over the function definition below. Open `Functions02.java` and **execute** this block of code.

Notice that when you execute this code, that there is NO OUTPUT to the screen. This is because this code only **creates** the function, it does not actually run the code inside the function.

```java
// notice that the variable declarations have been moved into parenthesis
// these are called input parameters
// Anyone who wants to execute this function MUST provide values for all of these parameters
public static void displayTeamScores(int rank, String teamName, int q1, int q2, int q3, int q4)
{
    int finalScore = q1 + q2 + q3 + q4;

    System.out.printf("(%d) %s \n", rank, teamName);
    System.out.println("-------------------------------");
    System.out.println(" Q1  Q2  Q3  Q4  Final");
    System.out.println(" --- --- --- --- -----");
    System.out.printf(" %-2d  %-2d  %-2d  %-2d  %d \n",q1, q2,q3,q4,finalScore);
    System.out.println();
}
```

Notice how this function does not have any information about the specific teams. The only thing that you focus on in your code in this function is the logic to calculate and display the information that you have been given.

## Executing a Function

Now that the function has been created, we want to run (execute) the code within that function.

To execute this function you need to specify the function name, followed by parenthesis '()', and include the team information. (You must pass parameters in the correct order).

```java
// the parameter order MUST BE rank, teamName, q1, q2, q3, q4
displayTeamScores(1, "Georgia", 12, 14, 6, 7);
```

### Instructions
Currently this code executes the `DisplayTeamScores(...)`  function for the top 3 teams.

Open `Functions02.java` and add the code to the `main` method to display the team scores for each of the teams.

```java
public static void main(String[] args)
{
    // add your code here
    displayTeamScores(1, "Georgia", 12, 14, 6, 7);
}

```

Add the code to display teams 4 and 5.

|Rank|Team|Q1|Q2|Q3|Q4|
|----|----|--|--|--|--|
|1|Georgia|12|14|6|7|
|2|Alabama|14|17|10|14|
|3|Ohio State|21|10|14|7|
|4|Michigan|10|7|0|17|
|5|Clemson|14|6|8|10|

### What is different?

What benefits do you see from creating a function?
