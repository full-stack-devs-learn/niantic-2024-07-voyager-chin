let categoryId = 0;

document.addEventListener("DOMContentLoaded", () => {

    const option = document.getElementById("category");

    option.addEventListener("change", (event) => {
        categoryId = +event.target.value;
        loadProducts();
    })


});

function loadProducts()
{
    const container = document.getElementById("product-container");
    container.innerHTML = "";

    const url = `/products/category/${categoryId}`;

    //async
    fetch(url).then(response => {
        if(response.status == 200)
        {
        return response.text();
        }
        throw new Error(response);
    }).then(data => {
        container.innerHTML = data;
    }).catch(error => {
        console.log(error)
    });
}