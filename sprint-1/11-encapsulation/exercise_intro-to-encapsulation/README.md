# Encapsulation

In this exercise, you'll create the classes specified below. The unit tests you run verify that you defined the classes correctly.

## Learning objectives

After completing this exercise, you'll understand how to:

* Write code that's [highly cohesive][high-cohesion].
* Write code that appropriately hides the internal details of classes.
* [Limit access to variables][java-encapsulation] through the use of [access modifiers][java-access-modifiers].
* Write derived properties.

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* All unit tests pass.
* Variable names and data types must meet the requirements.
* Code must be clean and properly formatted (indentations and white space).
* Code is appropriately encapsulated.

## Getting started

1. Open the `Exercise06.sln` solution in Visual Studio.
2. Click on the **Test -> Run All Tests** menu option.
3. Click on the **Test Explorer** tab to see the results of your tests and which ones passed or failed.

## Tips and tricks

### Focus on one test at a time

As you work on creating the classes, be sure to run the tests, and then provide enough code to pass the test. For instance, if you're working on the `HomeworkAssignment` class, provide enough code to get one of the `HomeworkAssignment` tests passing.

Focusing on getting a single test to pass at a time saves time, as this forces you to only focus on what's important for the test you're currently working on. This is commonly called **[Test Driven Development][introduction-to-test-driven-development]**, or **TDD**.

### Be mindful of your access modifiers

Remember that [access modifiers][java-access-modifiers] are a key feature of encapsulation.

### Don't linger too long on one problem

If you find yourself stuck on a problem more than fifteen minutes, move on to the next, and try again later. You may figure out the solution after working through another problem or two.

## Notes for all classes

- An X in the set column indicates the variable must have a `setter`.
- NO X in the set column indicates the variable must NOT have a `set`.

## Exercises

### Step One: Create the `Actor` DAO class

Model the actor class to hold the same values as the `Actor` table in the `Sakila` database.

All variables should be `private` and all variables should have public `getters` and `setters`.

#### Constructors
Your class should have 2 constructors:

- A `parameterless` constructor that takes NO input parameters
- A `parameterized` constructor that accepts all variables as input parameters.

#### Methods

This class should have no additional methods.


### Step Two: Create the `Customer` DAO class

Model the customer class to hold the same values as the `Customer` table in the `Sakila` database.

All variables should be `private` and all variables should have public `getters` and `setters`.

#### Constructors
Your class should have 2 constructors:

- A `parameterless` constructor that takes NO input parameters
- A `parameterized` constructor that accepts all variables as input parameters.

#### Methods

This class should have no additional methods.


### Step Three: Create the `Film` DAO class

Model the film class to hold the same values as the `Film` table in the `Sakila` database.

All variables should be `private` and all variables should have public `getters` and `setters`.

#### Constructors
Your class should have 2 constructors:

- A `parameterless` constructor that takes NO input parameters
- A `parameterized` constructor that accepts all variables as input parameters.

#### Methods

This class should have no additional methods.


### Step Four: Create the `Rectangle` class

#### Properties

| variable / method | Data Type | Get | Set      | Description                            |
|-------------------| --------- | --- | -------- | ---------------------------------------|
| width             | int       | X   | X        | Get or set the width of the rectangle. |
| height            | int       | X   | X        | Get or set the height of the rectangle.|
| getArea           | int       | X   |          | Calculate the area of the rectangle.   |

**Notes**

- `getArea` is a derived property that's calculated using the `width` and `height`.

#### Constructor

Create two constructors for this class:
- The first accepts no input parameters.
- The other accepts two input parameters: `int width` and `int height`. Use these parameters to set the variables of the class.

### Step Five: Create the `Circle` class

#### Properties

| variable / method | Data Type | get | set | Description                                   |
|-------------------| --------- |-----|-----| ----------------------------------------------|
| radius            | int       | X   | X   | Gets or sets the width of the rectangle.      |
| getArea           | double    | X   |     | Calculates the area of the rectangle.         |
| getDiameter       | int       | X   |     | Calculates the diameter of the rectangle.     |
| getCircumference  | double    | X   |     | Calculates the circumference of the rectangle.|

**Notes**

##### `getArea` is a derived property that's calculated using the `radius`.
- `Math.PI` can be used as the constant for π
- `Math.pow(number,exponent)` can be used for exponent calculations
##### `getDiameter` is a derived property that's calculated using the `radius`.
##### `getCircumference` is a derived property that's calculated using the `radius`.

#### Constructor

Create two constructors for this class:
- The first accepts no input parameters.
- The other accepts ont input parameter: `int radius`.

### Step Six: Create the `MathTest` class

#### Properties

| variable / method | Data Type | get | set | Description                                                                             |
|-------------------| --------- |-----|-----| ----------------------------------------------------------------------------------------|
| score             | int       | X   | X   | Gets or sets the total number of correct points the student received on the assignment. |
| possiblePoints    | int       | X   |     | Gets the number of possible points on the assignment.                                   |
| studentName       | string    | X   |     | Gets the students's name for the assignment.                                            |
| getLetterGrade    | string    | X   |     | Calculates the letter grade for the assignment.                                         |
| getPercent        | int       | X   |     | Calculates the percent scored for the assignment.                                       |

**Notes**

- `getPercent` is a derived property that is calculated using `score` and `percent`.
- `getLetterGrade` is a derived property that's calculated using percent of the test score.
    - For 90% or greater, it returns "A"
    - For 80-89%, it returns "B"
    - For 70-79%, it returns "C"
    - For 60-69%, it returns "D"
    - Otherwise, it returns "F"
    - _hint_: PossibleMarks and EarnedMarks are `int`s. What happens when a smaller integer is divided by a larger integer?



#### Constructor

Create a constructor for this class that accepts two parameters: `int possiblePoints` and `string studentName`. Use these parameters to set the properties of the class.


## (Optional) Challenge Exercises

### Step Seven: Create the `Refrigerator` class

The `Refrigerator` class defines logic for an automated refrigerator. The temperature should be within a range of 0 to 35.
A refrigerator also has a maximum capacity, this should be set when a new refrigerator is created.

When items are added to or removed from the refrigerator the available capacity should change. You should not be able to add
items that are larger than the available capacity. Also, items can only be added when the door is open.

#### Properties

| variables / methods | Data Type | Get | Set | Description                                       |
|---------------------|-----------|-----|-----|---------------------------------------------------|
| currentTemperature  | int       | X   |     | Gets the current temperature of the refrigerator. |
| maxCapacity         | int       | X   |     | Gets the maximum possible capacity.               |
| available           | int       | X   |     | Gets the available capacity of the refrigerator.  |
| isDoorOpen          | boolean   | X   |     | Indicates whether the door is open or closed      |

#### Constructor

The `Refrigerator` class has a single constructor that accepts two parameters, `int currentTemperature` and `int maxCapacity`.



#### Methods

Create methods based on the following signatures:

```
    void openDoor()
    void closeDoor()
    void addItem(int capacity)
    void removeItem(int capacity)
```

#### Notes

- `openDoor()` opens the refrigerator door.
- `closeDoor()` closes the refrigerator door.
- `addItem(int capacity)` adjusts the available capacity as long as the door is open. The used capacity can never exceed the max capacity.
- `removeItem(int desiredFloor)` adjusts the available capacity as long as the door is open. The capacity can never go below 0.



### Step Eight: Create the `Hotel` class

#### Properties

| variables           | Data Type | Get | Set | Description                                           |
|---------------------|-----------| --- |-----|-------------------------------------------------------|
| numberOfRooms       | int       | X   |     | Gets the total number of regular rooms in the hotel.  |
| numberOfSuites      | int       | X   |     | Gets the total number of suites in the hotel.         |
| bookedRooms         | int       | X   |     | Gets the number of booked regular rooms.              |
| bookedSuites        | int       | X   |     | Gets the number of booked suites.                     |
| availableRooms      | int       | X   |     | Gets the number of available regular rooms. (derived) |
| BookedCoachSeats    | int       | X   |     | Gets the number of available suites. (derived)        |

**Notes**

- `getAvailableRooms` is a derived property calculated by subtracting `bookedRooms` from `numberOfRooms`.
- `getAvailableSuites` is a derived property calculated by subtracting `bookedSuites` from `numberOfSuites`.

#### Constructors

Create a constructor for this class that accepts two parameters: `int numberOfRooms`, and `int numberOfSuites`. Use these parameters to set the properties of the class:

- `numberOfRooms` is the number of total regular rooms.
- `numberOfSuites` is the number of total suites.

Create a second constructor for this class that accepts four parameters: `int numberOfRooms`, `int numberOfSuites`, `int bookedRoms`, and `int bookedSuites`. Use these parameters to set the properties of the class:

- `numberOfRooms` is the number of total regular rooms.
- `numberOfSuites` is the number of total suites.
- `bookedRooms` is the number of booked regular rooms.
- `bookedSuites` is the number of booked suites.

#### Methods

Create a method called `makeReservation` that accepts two parameters: an `int` called `numberOfRooms` and a `boolean` called `isSuite`.
This method should return `true` if a reservation can be made or `false` if it cannot.

- If the input `isSuite` is `true`, check if there are enough suites available, and update the `bookedSuites`.
- If the input `isSuite` is `false`, check if there are enough regular rooms available, and update the `bookedRooms`.
- The method should return `true` if there were enough seats to make the reservation, otherwise it returns `false`.


---

[java-encapsulation]: https://www.w3schools.com/java/java_encapsulation.asp
[java-access-modifiers]: https://www.baeldung.com/java-access-modifiers
[introduction-to-test-driven-development]: http://agiledata.org/essays/tdd.html
[high-cohesion]: https://www.baeldung.com/cs/cohesion-vs-coupling
