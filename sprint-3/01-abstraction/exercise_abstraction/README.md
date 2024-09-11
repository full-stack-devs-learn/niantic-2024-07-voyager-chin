# Inheritance

In this exercise, you'll create the classes specified in the [Exercises](#Exercises) section of this document. The unit tests you run verify that you defined the classes correctly.

## Learning objectives

After completing this exercise, you'll understand how to:

* Control the use of inheritance through using abstract classes
* Override the logic of a function in an inherited abstract class

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* Existing unit tests for the `Weapon` class pass.
* You created new unit tests for the child classes and their requirements.
* Variable names and data types must meet the requirements.
* Code must be clean and properly formatted (indentations and white space).
* Classes must implement abstract methods.

## Getting started

1. Open the `exercise_abstraction` project in IntelliJ.
2. Right-click on the `src/test/java` folder and select `Run 'All Tests'` menu option.
3. View the **Test Explorer** tab to see the results of your tests and which ones passed or failed.

## Tips and tricks

### Focus on one test at a time

As you work on creating the classes, be sure to run the tests, and then provide enough code to pass the test. For instance, if you're working on the `Order` class, provide enough code to get one of the `Order` tests passing.

Focusing on getting a single test to pass at a time saves time, as this forces you to only focus on what's important for the test you're currently working on. This is commonly called **[Test Driven Development][introduction-to-test-driven-development]**, or **TDD**.

### Be mindful of your access modifiers

Remember that **access modifiers** are a key feature of encapsulation and inheritance.

`Private` members are only visible within the class. They are hidden even from child classes. If you want to make a variable available
to a child class use the `protected` modifier instead.

### Don't linger too long on one problem

If you find yourself stuck on a problem more than fifteen minutes, move on to the next, and try again later. You may figure out the solution after working through another problem or two.

## Notes for all classes

- An X in the set column indicates the property must have a `setter`.
- If there's nothing in the set column, that means the property is a **derived property**.

# Exercises

## 1: Create a `Weapon` class

The `Weapon` class must be an abstract class.

Every weapon has the ability to attack and will inflict a certain amount of damage on the character
that is being attacked. Weapons can also be charged to use a power attack - each weapon should
define its own logic charge differently and

### Properties

Add the following variables and getters/setters to the `Weapon` class. Note that the setPercentCharged should 
be a protected method.

| Property       | Data Type | Get | Set         | Description                                           |
|----------------|-----------|-----|-------------|-------------------------------------------------------|
| name           | String    | X   |             | Gets the  `name` of the weapon.                       |
| damage         | int       | X   |             | Gets the amount of damage inflicted by an attack.     |
| percentCharged | int       | X   | protected X | Gets the percent level that the weapon is charged.    |


### Constructor

The constructor accepts 2 parameters:
- `String: name` that sets the weapons name.
- `int: damage` sets the damage a weapon can inflict.

The percentCharged of any weapon should be 0 by default.

### Methods

Define the following abstract methods to the `Weapon` class.

```java
public abstract int attack();
public abstract int powerAttack();
public abstract int getRange();
```

* `attack()` guarantees that all weapons will have the ability to attack
* `powerAttack()` ensures that each weapon will have a powerAttack method
* `getRange()` ensures that we can determine the range of a weapon



## 2: Create a `Sword` class

The `Sword` class must extend the `Weapon` class.

Override the inherited abstract methods.

### Properties

The `Sword` class does not have any additional properties.

### Constructor

The constructor accepts 2 parameters:
- `String: name` that sets the weapons name.
- `int: damage` sets the damage a weapon can inflict.
- `int: daggerCount` sets the number of daggers

Call the constructor of the extended `Weapon` class and pass all
required parameters


### Methods

Implement the following abstract methods. Write unit tests to ensure that these
requirements are met.

```java
public abstract int attack();
public abstract int powerAttack();
public abstract int getRange();
```

* `attack()` each attack delivers the default damage to the other character
  * Each attack adds 10% to the `percentCharged`
  * the Percent charged cannot exceed 100%
* `powerAttack()` a power attack can only be used if the sword has a charge
  * < 50% just performs a regular attack
  * 50% - 90% delivers a double blow to the other character and reduces the charge by 50%
  * 100% delivers a 4x blow to the other character and reduces the charge to 0
* `getRange()` returns 1


# Optional / Challenge Exercise 1

## 3: Create a `Dagger` class

The `Dagger` class must extend the `Weapon` class.

Override the inherited abstract methods.

### Properties

The `Dagger` class has an additional property.

| Property       | Data Type | Get | Set         | Description                                        |
|----------------|-----------|-----|-------------|----------------------------------------------------|
| daggerCount    | int       | X   |             | Gets the number of daggers.                        |


### Constructor

The constructor accepts 2 parameters:
- `String: name` that sets the weapons name.
- `int: damage` sets the damage a weapon can inflict.

Call the constructor of the extended `Weapon` class and pass all
required parameters

### Methods

Implement the following inherited abstract methods. Write unit tests to ensure that these
requirements are met.

```java
public abstract int attack();
public abstract int powerAttack();
public abstract int getRange();
```

* `attack()`
  * If there are daggers in the bag the attack delivers the default damage to the other character
  * With a regular attack, daggers are always retrieved - so the count does not go down
  * Each throw charges the percentCharged by 20%
* `powerAttack()` a power attack can only be used if the dagger is charged 100%
  * If a powerAttack is used the damage of the dagger is 3x the default
  * A dagger cannot be retrieved from a power attack, so the daggerCount is reduced by 1
* `getRange()` returns 10

Add another method.

```java
public void addDagger();
```

* `addDagger()` should add another dagger to the daggerCount.


# Optional / Challenge Exercise 2

## 3: Create a `Bow` class

The `Bow` class must extend the `Weapon` class.

Override the inherited abstract methods.

### Properties

The `Dagger` class has an additional property.

| Property     | Data Type | Get | Set | Description                   |
|--------------|-----------|-----|-----|-------------------------------|
| arrowType    | String    | X   |     | Gets the type of arrows.      |
| quiverSize   | int       | X   |     | Gets the size of the quiver.  |
| arrowCount   | int       | x   |     | Gets the current arrow count. |


### Constructor

The constructor accepts 2 parameters:
- `String: name` that sets the weapons name.
  - possible options are, standard, poison, explosive
- `int: damage` sets the damage a weapon can inflict.
- `String: arrowType` sets the type of arrow
- `int: quiverSize` set the size of the quiver - it is full by default

Call the constructor of the extended `Weapon` class and pass all
required parameters

### Methods

Implement the following abstract methods. Write unit tests to ensure that these
requirements are met.

```java
public abstract int attack();
public abstract int powerAttack();
public abstract int getRange();
```

* `attack()`
  * Each attack shoots one arrow
  * Arrows are replenished 1 at a time in 5 second intervals
    * Look at the `java.util.Timer` object to see how to schedule timed method calls
  * Arrow power:
    * standard: default damage
    * poison arrows: 2x damage
    * explosive arrows: 3x damage
* `powerAttack()` 
  * percentCharge increases by 20% every 2 seconds
  * When the bow is fully charged, you have 5 seconds of unlimited arrows (no arrows are lost)
    * And each arrow delivers double attack power
* `getRange()` returns 20

