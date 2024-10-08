let categoryService;
let addFormScreen;
let addForm;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();
    addFormScreen = document.getElementById("add-form-screen");
    addForm = document.getElementById("add-form");

    document.getElementById("add-button").addEventListener("click", showForm);
    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addCategory);

    loadCategories();
})

function loadCategories()
{
    categoryService.getAllCategories()
        .then(categories => {
            const categoryContainer = document.getElementById('categories-container');
            categoryContainer.innerHTML = '';

            categories.forEach(category => {
                const template = document.getElementById('category-template').content.cloneNode(true);
                template.getElementById('category-header').innerText = category.categoryName;
                // template.getElementById('category-image').src = `images/${category.categoryId}.webp`;
                if(category.categoryId > 8)
                {
                    template.getElementById('category-image').src = `images/category-placeholder.png`;
                }
                else
                {
                    template.getElementById('category-image').src = `images/${category.categoryId}.webp`;
                };

                const deleteButton = template.querySelector('.card-footer #delete-button');
                deleteButton.addEventListener('click', () => {
                    categoryService.deleteCategory(category.categoryId).then(() => {
                        loadCategories();
                    })
                });

                categoryContainer.appendChild(template);
            })
        });
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

function addCategory(event)
{
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if(addForm.checkValidity()){
        const name = document.getElementById("category-name").value;
        const description = document.getElementById("category-description").value;

        const category = {
            categoryName: name,
            description: description,
        }

        categoryService.addCategory(category).then(response => {
            loadCategories();
        })

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}