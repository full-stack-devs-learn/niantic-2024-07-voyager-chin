

document.addEventListener("DOMContentLoaded", () => {

    const addActor = document.getElementById("add-actor");
    const firstName = document.getElementById("firstName");
    const lastName = document.getElementById("lastName");

    firstName.addEventListener("input", () => {
        addActor.classList.remove("was-validated");
    });
    lastName.addEventListener("input", () => {
        addActor.classList.remove("was-validated");
    });

    addActor.addEventListener("submit", (event) => {


        if(!addActor.checkValidity())
        {
            event.preventDefault();
            addActor.classList.add("was-validated");
        }
    })
});