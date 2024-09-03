
document.addEventListener('DOMContentLoaded', () =>
{
    logInfo('Content Loaded')
    init()

})

function init()
{
    
}

function logInfo(message)
{
    const eventLog = document.getElementById("event-log");
    eventLog.innerHTML = message;
}






