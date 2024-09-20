let categoryService;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();
    document.getElementById("load").addEventListener("click", loadCategories);
    document.getElementById("add").addEventListener("click", addCategory);
    
})

function loadCategories()
{
   categoryService.getAllCategories()
                  .then(categories => {
        const categoryNames = document.getElementById("category-names");
        categoryNames.innerHTML = '';

        categories.forEach(category => {
            const li = document.createElement("li")
            li.textContent = category.categoryName;
            categoryNames.appendChild(li);
        });
   })
}

function addCategory()
{
    const category = {
        categoryName: 'Test',
        description: 'description'
    };

    categoryService.addCategory(category).then(() => {
        loadCategories()
    });
}
