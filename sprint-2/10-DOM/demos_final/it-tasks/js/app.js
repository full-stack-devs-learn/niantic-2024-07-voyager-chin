const service = new TaskService();

function displayTitle() {
    const listTitle = document.getElementById("task-header");
    listTitle.textContent = service.getListTitle();
   
}

// get the list of all tasks and
// create all rows
function displayTasks() {
    const tasks = service.getTasks()
                         .sort((left, right) =>  left.priority - right.priority)
                         .map(task => {
                            return {
                                ...task,
                                priorityText: task.priority == 1 
                                                    ? "high"
                                                    : task.priority == 2
                                                            ? "medium"
                                                            : "low"
                            }
                         });

    const taskListContainer = document.getElementById("todos");

    tasks.forEach(task => {
        createTaskDiv(task, taskListContainer);
    });    
}

// create a new row for one task
function createTaskDiv(task, parent){
    const taskDiv = document.createElement("div");

    taskDiv.classList.add("task");

    switch(task.priority)
    {
        case 1:
            taskDiv.classList.add("high");
            break;
        case 2:
            taskDiv.classList.add("medium");
            break;
    }

    parent.appendChild(taskDiv);

    // add all the inner divs
    buildTaskDate(task, taskDiv);
    buildTaskPriorityPill(task, taskDiv);
    buildTaskPriority(task, taskDiv);
    buildTaskTitle(task, taskDiv);
}

// builds the date column
function buildTaskDate(task, parent){

    const dateDiv = document.createElement("div");
    dateDiv.classList.add("date");
    const date = new Date(task.dueDate)
    dateDiv.textContent = `${date.getMonth() + 1}/${date.getDate() +1}`;

    parent.appendChild(dateDiv);
}

// builds the colored priority circle
function buildTaskPriorityPill(task, parent)
{
    const pillDiv = document.createElement("div");

    // priority-high, priority-medium, priority-low
    const priority = task.priority == 1
                        ? "priority-high"
                        : task.priority == 2 
                            ? "priority-medium"
                            : "priority-low"

    pillDiv.classList.add(priority);

    parent.appendChild(pillDiv);
}

// builds the priority text
function buildTaskPriority(task, parent){
    const priorityDiv = document.createElement("div");

    priorityDiv.classList.add("priority");
    priorityDiv.textContent = task.priorityText;

    parent.appendChild(priorityDiv);

}

// builds the title/text of the task
function buildTaskTitle(task, parent){
    const titleDiv = document.createElement("div");
    titleDiv.classList.add("title");
    titleDiv.textContent = task.title;

    parent.appendChild(titleDiv);

}

function completeHighPriority()
{
    const divs = document.querySelectorAll(".task.high");

    divs.forEach( div => div.remove())
}


document.addEventListener("DOMContentLoaded", () => {

    // this code will not run until the browser
    // had loaded all content
    displayTitle();
    displayTasks();
});
