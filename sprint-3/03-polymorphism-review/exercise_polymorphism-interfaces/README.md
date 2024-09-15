# Polymorphism

In this exercise, you will use the existing black jack card game and add java interfaces in order to control code logic

## Learning objectives

After completing this exercise, you'll understand how to:

* Implement interfaces with custom logic in your own classes.

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* Unit tests must pass.

## Getting started

1. Open the `exercise_polymorphism-interfaces` project in IntelliJ.
2. Right-click on the `src/test/java` folder and select `Run 'All Tests'` menu option.
3. View the **Test Explorer** tab to see the results of your tests and which ones passed or failed.

## Tips and tricks

### Focus on one test at a time

As you work on creating the classes, be sure to run the tests, and then provide enough code to pass the test. For instance, if you're working on the `Order` class, provide enough code to get one of the `Order` tests passing.

Focusing on getting a single test to pass at a time saves time, as this forces you to only focus on what's important for the test you're currently working on. This is commonly called **[Test Driven Development][introduction-to-test-driven-development]**, or **TDD**.

### Don't linger too long on one problem

If you find yourself stuck on a problem more than fifteen minutes, move on to the next, and try again later. You may figure out the solution after working through another problem or two.

## Notes for all classes

- An X in the set column indicates the property must have a `setter`.
- If there's nothing in the set column, that means the property is a **derived property**.

# Exercises

## 1: Implement the `Comparable<>` interface in the `Card` class

The `Card` class must implement `Comparable<Card>`.

This will allow collections of cards to be sorted.

### Sorting Rules

Compare cards first by suit in this order.
* Spades (♠) (first)
* Hearts (♥)
* Diamonds (♦)
* Clubs (♣) (last)

If the suit is the same - compare the value in this order
* 2
* 3
* 4
* 5
* 6
* 7
* 8
* 9
* 10
* J
* Q
* K
* A


## 2: Sort the cards in the `Hand` class

Every time a new card is dealt to a `Hand` the cards should be sorted in the correct order (suit, value).


# Optional / Challenge Exercises

## 3: Implement the `Clonable` interface in the `Card` class

The `clone()` method should create a deep copy of the `Card` class.

This should create a new card which has the same suit and value
of the original card.


## 4: Implement the `Clonable` interface in the `Hand` class

The `clone()` method should create a deep copy of the `Hand` class.

This means that if I clone a hand, I should be able to shuffle the cards, add,
or remove cards and it should not affect the cards in the original `Hand`
from which the new one was cloned.


