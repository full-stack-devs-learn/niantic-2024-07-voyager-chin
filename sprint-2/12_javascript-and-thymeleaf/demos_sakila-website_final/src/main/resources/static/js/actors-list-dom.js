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
    const url = `/api/actors/page/${pageNumber}`;
    fetch(url).then(response => {
        return response.json();
    })
        .then(data => {
            const tbody = document.getElementById("actor-container");
            tbody.innerHTML = "";

            data.forEach(actor => {
                displayActor(actor, tbody)
            })
        })
        .catch(error => {
            console.log(error);
        })
}

function displayActor(actor, table)
{
    const row = document.createElement("tr");
    const idCell = document.createElement("td");
    const firstNameCell = document.createElement("td");
    const lastNameCell = document.createElement("td");
    const buttonsCell = document.createElement("td");

    idCell.textContent = actor.actorId;
    firstNameCell.textContent = actor.firstName;
    lastNameCell.textContent = actor.lastName;

    const editLink = document.createElement("a");
    editLink.classList.add("btn")
    editLink.classList.add("btn-outline-warning")
    editLink.classList.add("me-1")
    editLink.textContent = "Edit";
    editLink.href = `/actors/${actor.actorId}/edit`

    const deleteLink = document.createElement("a");
    deleteLink.classList.add("btn")
    deleteLink.classList.add("btn-outline-danger")
    deleteLink.textContent = "Delete";
    deleteLink.href = `/actors/${actor.actorId}/delete`

    buttonsCell.appendChild(editLink);
    buttonsCell.appendChild(deleteLink);

    row.appendChild(idCell);
    row.appendChild(firstNameCell);
    row.appendChild(lastNameCell);
    row.appendChild(buttonsCell);

    table.appendChild(row);
}