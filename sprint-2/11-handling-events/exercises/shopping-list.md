# Event Handlers Exercise

In this exercise, you'll build on the shopping list exercise that you've been working on. The starting code for this exercise and the automated tests are located in `shopping-list`.

## Exercise

If you open `js/shopping-list.js`, there is one variable declared for you:

* **allItemsIncomplete:** You'll use this later.

The application methods load and display all shopping list items from the 
ShoppingService class. You need to enhance the application to mark items 
complete or incomplete by responding to click events


### Mark individual item complete

When a user clicks on an item in the shopping list, it should be marked complete. To do so, add the `.complete` class to the list item and the icon. You should check the item to make sure it doesn't already have the complete class. There is no sense in performing your logic on an item that is already complete.

### Mark item incomplete

When a user double clicks on an item in the shopping list, it should be marked incomplete. To do so, remove the `.complete` class to the list item and the icon. You should check the item to make sure it has the complete class. There is no sense in performing your logic on an item that isn't completed.

### Toggle all

When your application loads, all of the items are incomplete, and the button on the page says `Mark All Complete`. When you click on this button, all of the items in the list should be marked completed. The button's text should also switch to say `Mark All Incomplete`. If you were to click on the button again, it would mark all of the items in the list incomplete.

> HINT: You can use the variable `allItemsIncomplete` to track the current state of the button. Whenever you mark all items complete or incomplete, make sure to toggle this variable to keep track of your last action.

### Add New Items

Allow the user to add a new item to the shopping list using the form that is provided.

When a new item is added, it should NOT be marked as complete. Additionally, the form should be cleared after the item has been added to the list.
