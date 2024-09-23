class CategoryService
{
    baseUrl = `${config.baseUrl}/categories`;

    getAllCategories()
    {
        return axios.get(this.baseUrl)
            .then(response => {
                return response.data;
            });
    }

    getCategoryById(categoryId)
    {
        return axios.get(`${this.baseUrl}/${categoryId}`)
            .then(response => {
                return response.data;
            });
    }

    addCategory(category)
    {
        return axios.post(this.baseUrl, category)
            .then(response => {
                return response.data;
            });
    }

    updateCategory(categoryId, category)
    {
        return axios.put(`${this.baseUrl}/${categoryId}`, category);
    }

    deleteCategory(categoryId)
    {
        return axios.delete(`${this.baseUrl}/${categoryId}`);
    }
}