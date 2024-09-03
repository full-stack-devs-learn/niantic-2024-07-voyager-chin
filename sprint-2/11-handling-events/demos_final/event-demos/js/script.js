let counter = 0;

function logInfo(message)
{
    const eventLog = document.getElementById("event-log");
    eventLog.innerHTML = message;
}


function buttonClick(event)
{
    counter ++;
    const position = `${event.clientX}:${event.clientY}`
    const screenPosition = `${event.screenX}:${event.screenY}`
    logInfo(`The button was clicked ${counter} times<br>${position}<br>${screenPosition}`)
}

function buttonMove(event)
{

    const position = `${event.clientX}:${event.clientY}`
    const screenPosition = `${event.screenX}:${event.screenY}`
    logInfo(`The mouse moved over the button<br>${position}<br>${screenPosition}`)

    // make sure that the <main> mousemove event doesn't overwrite this one
    event.stopPropagation();
}

document.addEventListener("DOMContentLoaded", () => {

    const button = document.getElementById("submitButton");
    const main = document.querySelector("main");

    button.addEventListener("click", buttonClick)
    button.addEventListener("mousemove", buttonMove);

    main.addEventListener("mousemove", (event) => {
        logInfo(`Moved over page at <strong>${event.x}:${event.y}</strong>`)
    })

});




