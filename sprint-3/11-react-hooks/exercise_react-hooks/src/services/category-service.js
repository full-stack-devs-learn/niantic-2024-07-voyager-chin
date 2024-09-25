import axios from 'axios'

class CategoryService
{
    baseUrl = 'http://localhost:8080/categories'

    async getAllCategories()
    {
        const response = await axios.get(this.baseUrl);
        return response.data;
    }

    async add(category)
    {
        const response = await axios.post(this.baseUrl, category);
        return response.data;
    }

    async delete(categoryId)
    {
        await axios.delete(`${this.baseUrl}/${categoryId}`)
    }
}

const categoryService = new CategoryService()
export default categoryService;