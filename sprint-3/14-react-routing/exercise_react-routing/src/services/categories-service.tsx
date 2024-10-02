import axios from "axios";
import { Category } from "../models/category";

class CategoryService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/categories`

    async getAllCategories(): Promise<Category[]>
    {
        const response = await axios.get<Category[]>(this.baseUrl);
        return response.data;
    }

    async add(category: Category): Promise<Category>
    {
        const response = await axios.post(this.baseUrl, category);
        return response.data;
    }

    async update(category: Category): Promise<void>
    {
        const url = `${this.baseUrl}/${category.categoryId}`;
        await axios.put<void>(url, category);
    }

    async delete(categoryId: number): Promise<void>
    {
        await axios.delete<void>(`${this.baseUrl}/${categoryId}`)
    }
}

const categoryService = new CategoryService();
export default categoryService;