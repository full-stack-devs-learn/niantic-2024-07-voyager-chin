let categoryService;
let productService;
let addFormScreen;
let addForm;
let categoryId;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();
    productService = new ProductsService();

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    categoryId = urlParams.get('catId'); 

    addFormScreen = document.getElementById("add-form-screen");
    addForm = document.getElementById("add-form");

    document.getElementById("add-button").addEventListener("click", showForm);
    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addProduct);

    loadProducts();
})

function loadProducts()
{
    // load all products
}

function showForm()
{
    addFormScreen.classList.remove("d-none");
}

function cancelAdd(event)
{
    event.preventDefault();
    addFormScreen.classList.add("d-none");
}

function addProduct(event)
{
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if(addForm.checkValidity()){

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}