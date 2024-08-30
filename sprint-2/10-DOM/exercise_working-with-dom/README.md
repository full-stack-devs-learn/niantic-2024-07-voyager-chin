# DOM exercise

In this exercise, you'll build a shopping list from data. You can find all of the code you need to get started in the folder `shopping-list`.

## Exercise

First, open `js/shopping-wervice.js`:

- add code to the `getListName()` function and return the name of the shopping list.
- add logic to the `getShoppingList()` function and return an {Array} of at least 10 shopping list items that follow this pattern:
```javascript
        return [
            {
                id: 1,
                title: '5 lb sack of potatoes',
                quantity: 1,
                isComplete: false
            },
            {
                id: 2,
                title: 'Frozen Pizza',
                quantity: 4,
                isComplete: true
            }
        ];
```

### Page title

When the application loads, it calls the `displayPageTitle()` function. It's your job to fill in that function and make it work. Take the contents of the `pageTitle` variable and update the DOM. Create an instance of the `ShoppingService` class and call the `getListName()` method.

### Groceries

When the application loads, it calls the `displayGroceries()` function. It's your job to fill in that function and make it work. Take the array of groceries, create a new list item element, and append it to the unordered list on the page. Create an instance of the `ShoppingService` class and call the `getShoppingList()` method - use the data in the array to create the list.

## Optional / Challenge

### Mark Complete

Add code to the `markCompleted()` method to find all list items and mark them as completed. Hint - add the `completed` class to each item. It's your job to make that method work. Get **all** of the list items on the page and add the class `completed` to each one.

## Definition of Done

To consider this exercise complete, your shopping list application must do the following:

* When the application loads, it calls the `displayPageTitle()` function
    * This must get a reference to target the id `title` and set it to 'Shopping List'
* When the application loads, it calls the `displayGroceries()` function
    * You must get the list of groceries from the `shopping-service` 
    * your list must have at least 10 items in it
    * You must loop over this array and create a list item element for each and add it to the DOM


