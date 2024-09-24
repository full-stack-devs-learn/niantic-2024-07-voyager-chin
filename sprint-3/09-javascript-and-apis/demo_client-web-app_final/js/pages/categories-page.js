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
    document.getElementById("update-button").addEventListener("click", updateCategory);

    loadCategories();


    // categoryService.getAllCategories()
    // .then(categories => {
    //     console.log(categories);
    // })
    // .catch(error => {
    //     console.log(error);
    // })

})

async function loadCategories()
{
    try{
        const categories = await categoryService.getAllCategories();

        const categoryContainer = document.getElementById('categories-container');
        categoryContainer.innerHTML = '';

        categories.forEach(category => {
            const clone = document.getElementById('category-template').content.cloneNode(true);
            clone.getElementById('category-header').innerText = category.categoryName;
            clone.getElementById('category-image').src = `images/${category.categoryId}.webp`;
            clone.getElementById('products-link').href = `products.html?catId=${category.categoryId}`;

            const editButton = clone.querySelector('.card-footer #edit-button');
            editButton.addEventListener('click', () => {
                document.getElementById("category-name").value = category.categoryName;
                document.getElementById("category-description").value = category.description;
                document.getElementById("save-button").classList.add("d-none");
                document.getElementById("update-button").classList.remove("d-none")
                addFormScreen.classList.remove("d-none");
            });

            const deleteButton = clone.querySelector('.card-footer #delete-button');
            deleteButton.addEventListener('click', () => {
                categoryService.deleteCategory(category.categoryId).then(() => {
                    loadCategories();
                })
            });

            categoryContainer.appendChild(clone);
        })
    }
    catch(error)
    {
        console.log(error);
        
    }
}

function showForm()
{
    document.getElementById("category-name").value = '';
    document.getElementById("category-description").value = '';
    document.getElementById("save-button").classList.remove("d-none");
    document.getElementById("update-button").classList.add("d-none")
    addFormScreen.classList.remove("d-none");
}

function cancelAdd(event)
{
    event.preventDefault();
    addFormScreen.classList.add("d-none");
}

async function addCategory(event)
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


        const newCategory = await categoryService.addCategory(category);
        
        loadCategories();
       

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}

async function updateCategory(event)
{

}