# Unit Testing

In this exercise, you'll create the unit tests for the classes the solution. The unit tests should determine
that the classes were built correctly.

## Learning objectives

After completing this exercise, you'll understand how to:

* Write unit tests that focus on the functionality of a class.
* Use requirements to determine what kind of unit tests to write and what scenarios to test.

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* Unit Tests must find logic errors in the existing code.
  * Use the `bug_tracker.txt` file to log the bugs and logic errors in the classes
* Unit test naming convention must be consistent and follow a common naming standard.
* You must have multiple quality tests for each class (the more complex classes will require 
  more tests for adequate coverage.)
  1. Test the **happy path** first
  2. Test the edges of input values
  3. Test values that you expected to fail

## Getting started

1. Open the `exercise_unit-testing` project in IntelliJ.
2. Open the `src/test/java` folder.
3. Write your unit tests in the appropriate classes
4. Right-click the **src/test/java** and select the **Run 'All Tests'** menu option.
5. View the test explorer tab to see the results of your tests and which ones passed or failed.
   * If a test fails, determine if there is a bug in the code, or if the test is incorrect
   * If there is a bug - log it in the bug tracker

## Tips and tricks

### Focus on one test at a time

As you work on creating the unit tests, be sure to plan the tests with a test scenario document.
You should determine which tests to write based on the requirements in the [Exercises](#Exercises) section
of this file.

Focusing on getting a single test to pass at a time saves time, as this forces you to only focus on what's 
important for the test you're currently working on. 
This is known as **Test Driven Development**, or **TDD**.

### Don't linger too long on one problem

If you find yourself stuck on a problem more than fifteen minutes, move on to the next, 
and try again later. You may figure out the solution after working through another problem or two.

# Exercises

# Class: The `Rectangle` class

## Properties

| Property | Data Type | Get | Set      | Description                               |
|----------| --------- | --- | -------- | ------------------------------------------|
| width    | int       | X   | X        | Gets or sets the width of the rectangle.  |
| height   | int       | X   | X        | Gets or sets the height of the rectangle. |

**Notes**

The following derived properties can be calculated using the `width` and `height` properties.

- `getArea()`
- `getPerimeter()` 

## Constructors

This class has two constructors:
- The first accepts no input parameters - a default rectangle with have a width and height of 5 x 5.
- The other accepts two input parameters: `int width` and `int height`. Use these parameters to set the properties of the class.

## Tests

When testing classes we often do not test the getters and setters with backing variables. 
Derived properties, however, are methods which could introduce logic errors, and should be tested.

Your tests should focus on the `getArea()` and `getPerimeter()` methods to ensure correct logic. 
Be sure to write enough tests to verify the code.

## Test Requirements:

- The parameterless constructor should create a rectangle of size (5 x 5).
- The area of the rectangle should be calculated correctly (width x height).
- The perimeter of the rectangle should be calculated correctly ((2 x width) + (2 x height)).
- `width` and `height` must be `positive`
  - If either the `width` or `height` are `zero` or less when the area is calculated a runtime exception should be thrown
  - If either the `width` or `height` are `zero` or less when the perimeter is calculated a runtime exception should be thrown


# Class: The `Quiz` class

## Properties

| Property       | Data Type | Get | Set | Description                                                                             |
|----------------|-----------| --- |-----| ----------------------------------------------------------------------------------------|
| score          | int       | X   | X   | Gets or sets the total number of correct points the student received on the assignment. |
| possiblePoints | int       | X   |     | Gets the number of possible points on the assignment.                                   |
| studentName    | String    | X   |     | Gets the students's name for the assignment.                                            |

**Notes**

Following are the derived properties that are calculated from the class variables:

- `getPercent()`
- `getLetterGrade()`

## Constructor

This class has one constructor that accepts two parameters:

- `int possiblePoints` and `String studentName`. 
 
When creating an instance of `Quiz` you specify the name of the student, and the total points possible for the quiz.
For this class, you must set the actual score that the student earned before you can determine the percent and grade.

#### Tests / Requirements:

- Ensure that `getPercentage()` calculates the correct integer value using `score` and `possiblePoints`.
- Ensure that `getLetterGrade()` returns the correct grade based on the quiz `percent`.
  - For 90% or greater, should return "A"
  - For 80-89%, should return "B"
  - For 70-79%, should return "C"
  - For 60-69%, should return "D"
  - Otherwise, should return "F"
- `possiblePoints` must be `positive`.
- `score` must be `positive`.

# Optional - Challenge Exercises

The remaining classes to be tested are challenge exercises if time allows.

# Class: The `GameCharacter` class

## Properties

| Property       | Data Type | Get | Set | Description                                            |
|----------------|-----------| --- |-----|--------------------------------------------------------|
| name           | String    | X   |     | The name of the character.                             |
| maxEnergyLevel | int       | X   |     | This is the maximum energy level a character can have. |
| energyLevel    | int       | X   |     | This is the current energy level of the character.     |

## Constructor

The `Character` class has a single constructor that accepts two parameters, `int maxEnergyLevel` and `String name`.

## Methods

Methods with the following signatures exist in the class:

```
    void takeHit(int damage)
    void heal(int amount)
    boolean isKnockedOut()
```

## Tests / Requirements

- `takeHit(int damage)` should reduce the energy level by the amount of damage specified.
  - The `energyLevel` should never fall below `0`
- `heal(int amount)` should increase the energy level by the amount of energy specified.
  - The `energyLevel` should never increase above the maximum level
  - If the `energyLevel` reaches `0` the character is knocked out and cannot heal anymore.
- `isKnockedOut()` should return true if the `energyLevel` is `0`, and false if the value is greater.

# Class: The `Printer` class

## Properties

| Property | Data Type | Get | Set | Description                              |
|----------| --------- | --- |-----|------------------------------------------|
| sheets   | int       | X   |     | The amount of paper left in the tray.    |
| toner    | int       | X   |     | The amount of toner left in the printer. |

## Constructor

This class has one constructor that accepts two parameters: `int sheets` and `int toner`. 
Use these parameters to set the properties of the class.

The maximum amount of toner that the printer can hold is for 1000 prints, and the maximum sheets is 500.

## Tests / Requirements

The `print()` method accepts one input parameter, an `int` called `pages`. The function returns an `int` - the number of pages
that were actually printed based on available toner and sheets of paper:
- Verify that the `print()` method correctly updates the toner and sheets of paper in the printer.
- The `print()` method should also return the number of pages that were printed.
- `sheets` and `toner` should never fall below `zero`
- The printer should only print as many sheets of paper, or toner that is available, even if the request is for more.
- It should not be possible to print a negative amount of copies. If a negative number is requested 0 copies should be printed.

The `replaceToner()` method does not accept any input parameters. No value is returned.
- The `toner` should be reset to it's maximum capacity.

The `addPaper()` method accepts one input parameter, an `int` called `paper`. No value is returned.
- Update the amount of `paper` that is in the printer.
- The amount of `paper` should never exceed the maximum sheets.
- You should not be able to add negative `paper`.
