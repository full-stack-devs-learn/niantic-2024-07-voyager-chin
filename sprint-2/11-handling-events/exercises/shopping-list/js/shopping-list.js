let service;
let list = []

let allItemsIncomplete = true;

let itemInput;
let itemError;
let quantityInput;
let quantityError;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div);
    addItemId(item, div); // 

    parent.appendChild(div)

    // add event listener to div
    div.addEventListener("click", () => markItemComplete(item.id));
    div.addEventListener("dblclick", () => markItemIncomplete(item.id));

}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}

// create function to mark all complete
function markCompleted() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        if (!item.isComplete){
            item.isComplete = true;
            item.classList.add("complete");
        }
    })
    
    changeButtonToIncomplete();
}

// create function to mark all incomplete
function markAllIncomplete() {
    const listItems = document.querySelectorAll(".list-item");

    listItems.forEach(item => {
        if (item.isComplete){
            item.isComplete = false;
            item.classList.remove("complete");
        }
    })

    changeButtonToCompleted()
}

// change button text to "Mark All Incomplete"
function changeButtonToIncomplete() {
    const button = document.getElementById("allCompleteButton");
    button.textContent = "Mark All Incomplete";
    button.onclick = markAllIncomplete;
}

// change button text to "Mark All Completed"
function changeButtonToCompleted() {
    const button = document.getElementById("allCompleteButton");
    button.textContent = "Mark All Completed";
    button.onclick = markCompleted;
}

function markItemComplete(id)
{
    // get item using id
    const shoppingItem = list.filter((item) => item.id == id);
    
    // check if !isComplete
    if (!shoppingItem.isComplete) {
        shoppingItem.isComplete = true;
    }
    
    const item = document.getElementById(`${id}`);
    item.classList.add("complete")
}

function markItemIncomplete(id)
{
    // get item using id
    const shoppingItem = list.filter((item) => item.id == id);
    
    // check if isComplete
    if (shoppingItem.isComplete) {
        shoppingItem.isComplete = false;
    }

    const item = document.getElementById(`${id}`);
    item.classList.remove("complete")
}

function addItemId(item, div) {
    div.id = item.id;
}

// ADD ITEM TO SHOPPING LIST
function addItem(event){
    event.preventDefault();

    showErrors();

    // create a new item object with item name and quantity
    if(itemInput.validity.valid && quantityInput.validity.valid) {
        const itemName = document.getElementById("itemInput").value;
        const quantity = document.getElementById("quantityInput").value;

        const newItem = {
            id: list.length + 1,
            title: itemName,
            quantity: quantity,
            isComplete: false
        }

        list.push(newItem);

        const parent = document.getElementById("shopping-list");
        addListItem(newItem, parent);
        
        clearForm();
    }
}

function clearForm(){
    document.getElementById("itemInput").value = "";
    document.getElementById("quantityInput").value = "";
}

function setupValidation(){
    itemInput = document.getElementById("itemInput");
    itemError = document.getElementById("itemError");

    quantityInput = document.getElementById("quantityInput");
    quantityError = document.getElementById("quantityError");
}

function showErrors(){
    if(!itemInput.validity.valid)
        {
          itemError.textContent = "Item name is required";
          itemInput.classList.add("error")
        }
        else
        {
          itemError.textContent = "";
          itemInput.classList.remove("error")
        }
      
        if(!quantityInput.validity.valid)
        {
          quantityError.textContent = "Quantity is required";
          quantityInput.classList.add("error")
        }
        else
        {
          quantityError.textContent = "";
          quantityInput.classList.remove("error")
        }
}

// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();
    setupValidation();

});

document.addEventListener("click", () => {
    const form = document.getElementById("add-item");
    form.addEventListener("submit", addItem);
})