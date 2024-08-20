# Inheritance

In this exercise, you'll create the classes specified in the [Exercises](#Exercises) section of this document. The unit tests you run verify that you defined the classes correctly.

## Learning objectives

After completing this exercise, you'll understand how to:

* Re-use code through the use of inheritance
* Override the logic of a function in an inherited class

## Evaluation criteria and functional requirements

* The project must compile (it cannot have any build errors).
* All unit tests pass.
* Variable names and data types must meet the requirements.
* Code must be clean and properly formatted (indentations and white space).
* All classes must make proper use of inheritance to solve the problem.

## Getting started

1. Open the `exercise_inheritance` project in IntelliJ.
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

## Class: Create a `Wizard` class

The `Wizard` class should extend (or inherit from) the `Character` class.

### Properties

| Property | Data Type | Get | Set | Description                |
|----------|-----------| --- |-----|----------------------------|
| mana     | int       | X   |     | Gets the amount of `mana`. |

### Constructor

The constructor accepts 5 parameters:
- `String: name` that sets the wizards name.
- `int: health` sets the health of the wizard.
- `int: level` sets the level of wizard.
- `int: experience` sets the experience of wizard.
- `int: mana` sets the mana of wizard.

Call the constructor of the extended `Character` class and pass all
required parameters

### Methods

The `Wizard` add the following additional methods.

```java
public int getMana();
public void castSpell(Character target);
public void regenerateMana(int amount);
@Override public void levelUp();
@Override public String specialAbility();
```

* `getMana()` returns the amount of `mana` of the wizard
* `castSpell()` is a powerful attack that causes 2 times the damage of a normal attack
  * A wizard can only use a spell if they have at least `10` mana points
  * Each time the wizard casts a spell their `mana` is decreased by `10` points
  * A wizard that has been defeated cannot cast spells
* `regenerateMana()` increases the `mana` points of the wizard
  * A wizard's mana can only increase if they have not been defeated
* `@Override levelUp()` should perform all of the `levelUp` functions of a character
  * `levelUp()` should also increase the `mana` by `10` points
* `@Override specialAbility()` for the wizard should return `Cast Spells`


# Optional / Challenge Exercises

## Class: Create a `Knight` class

The `Wizard` class should extend (or inherit from) the `Character` class.

### Properties

| Property | Data Type | Get | Set | Description                            |
|----------|-----------| --- |-----|----------------------------------------|
| armor    | int       | X   |     | Gets the amount of `armor` protection. |

### Constructor

The constructor accepts 5 parameters:
- `String: name` that sets the knight name.
- `int: health` sets the health of the knight.
- `int: level` sets the level of knight.
- `int: experience` sets the experience of knight.
- `int: armor` sets the armor of knight.

Call the constructor of the extended `Character` class and pass all
required parameters

### Methods

The `Knight` add the following additional methods.

```java
public int getArmor();
@Override public void levelUp();
@Override public void takeDamage(int damage);
@Override public String specialAbility();
```

* `getArmor()` returns the amount of `mana` of the wizard
* `@Override takeDamage()` is overriden to add logic to allow the armor to deflect a blow
    * The armor / shield should deflect the amount of damage that the armor can handle
    * Any additional damage should be removed from the health of the knight.
    * The armor's level does not decrease, but can be re-used
    * If the armor is more powerful than the attack, then no damage is sustained by the knight
* `@Override levelUp()` should perform all of the `levelUp` functions of a character
    * `levelUp()` should also increase the `armor` by `5` points
* `@Override specialAbility()` for the wizard should return `Armor Shield`

