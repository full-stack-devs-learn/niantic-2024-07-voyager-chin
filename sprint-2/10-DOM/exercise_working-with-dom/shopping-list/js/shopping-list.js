const service = new ShoppingService();

// add pageTitle

// add groceries

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function displayListTitle() {
    const title = document.getElementById("title");
    title.textContent = service.getListName();
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
    const groceries = service.getShoppingList();
    // const 
    const shoppingListDiv = document.getElementById("shopping-list");

    groceries.forEach(item => {
        createListDiv(item, shoppingListDiv);
    })
}

function createListDiv(item, parent){
    const listDiv = document.createElement("div");
    listDiv.classList.add("list-item");

    const textDiv = document.createElement("div");
    textDiv.textContent = item.title;
    listDiv.appendChild(textDiv);

    const quantityDiv = document.createElement("div");
    quantityDiv.classList.add("quantity-container");
    quantityDiv.textContent = item.quantity;
    listDiv.appendChild(quantityDiv);

    const span = document.createElement("span");
    span.classList.add("super");
    span.innerText = "quantity";
    quantityDiv.prepend(span);

    if (item.isComplete) {
        listDiv.classList.add("complete");
    }

    parent.appendChild(listDiv);
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
    const listDiv = document.getElementsByClassName("list-item");

    const groceries = service.getShoppingList();
    groceries.forEach((item, index) => {
        if (!item.isComplete){
            item.isComplete = true;
        }
    });

    for (let i= 0; i < listDiv.length; i++) {
        const list = listDiv[i];
        list.classList.add("complete");
    }
}

document.addEventListener("DOMContentLoaded", () => {
    displayListTitle();
    displayGroceries();
})

