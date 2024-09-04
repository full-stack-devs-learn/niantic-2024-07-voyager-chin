let pageNumber = 1;
let totalPages = 1;

document.addEventListener("DOMContentLoaded", () => {
    const previous = document.getElementById("previous");
    const next = document.getElementById("next");
    const first = document.getElementById("first");
    const last = document.getElementById("last");

    previous.addEventListener("click", () => {
        if(pageNumber > 1){
            pageNumber--;
            loadPage();
        }
    })
    next.addEventListener("click", () => {
        if(pageNumber < totalPages)
        {
            pageNumber++;
            loadPage();
        }
    })
    first.addEventListener("click", () => {
        if(pageNumber > 1)
        {
            pageNumber = 1;
            loadPage();
        }
    })
    last.addEventListener("click", () => {
        if(pageNumber < totalPages)
        {
            pageNumber = totalPages;
            loadPage();
        }
    })

    loadPage()

    fetch(`/api/actors/pages`).then(response => response.text()).then(data => {
        totalPages = +data;
    })
});

function loadPage()
{
    const container = document.getElementById("actor-container");
    container.innerHTML = "";

    const url = `/actors/page/${pageNumber}`;

// asynchronous
    fetch(url).then(response => {
        if(response.status === 200)
        {
            return response.text();
        }
        throw new Error(response);
    }).then(data => {
        container.innerHTML = data;
    }).catch(error => {
        console.log(error)
    })
    ;
}