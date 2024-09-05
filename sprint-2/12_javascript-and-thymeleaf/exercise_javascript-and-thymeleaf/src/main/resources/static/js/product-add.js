document.addEventListener("DOMContentLoaded", () => {
    const addProduct = document.getElementById("add-product");
    const productName = document.getElementById("productName");
    const categoryId = document.getElementById("categoryId");
    const quantityPerUnit = document.getElementById("quantityPerUnit");
    const unitPrice = document.getElementById("unitPrice");
    const unitsInStock = document.getElementById("unitsInStock");
    const unitsOnOrder = document.getElementById("unitsOnOrder");
    const reorderLevel = document.getElementById("reorderLevel");

    productName.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });
    categoryId.addEventListener("change", () => {
        addProduct.classList.remove("was-validated");
    });
    quantityPerUnit.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });
    unitPrice.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });
    unitsInStock.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });
    unitsOnOrder.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });
    reorderLevel.addEventListener("input", () => {
        addProduct.classList.remove("was-validated");
    });

    addProduct.addEventListener("submit", (event) => {

        if(!addProduct.checkValidity())
        {
            event.preventDefault();
            addProduct.classList.add("was-validated");
        }

    })




})