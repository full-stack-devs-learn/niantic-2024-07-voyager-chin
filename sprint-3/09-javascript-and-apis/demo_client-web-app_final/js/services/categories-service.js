class CategoryService
{
    baseUrl = `${config.baseUrl}/categories`;

    async getAllCategories()
    {
        const response = await axios.get(this.baseUrl);
        return response.data;
    }

    async getCategoryById(categoryId)
    {
        const response = await axios.get(`${this.baseUrl}/${categoryId}`);
        return response.data;
    }

    async addCategory(category)
    {
        // // example using async/await with fetch
        // const response =  await fetch(this.baseUrl, {
        //                             method: POST,
        //                             headers: {
        //                                 'Content-Type': 'application/json',
        //                             },
        //                             body: JSON.stringify(category)
        //                         });

        // if(!response.ok)
        // {
        //     throw new Error("Something went wrong")
        // }

        // const data = await response.json()
        
        // return data;


        // example using async/await with axios
        const response = await axios.post(this.baseUrl, category);
        return response.data;
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