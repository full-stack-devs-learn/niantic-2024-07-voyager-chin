class CategoryService
{
   baseUrl = `${config.baseUrl}/categories`;

   getAllCategories()
   {
        return axios.get(this.baseUrl).then(response => response.data);

        // return fetch(this.baseUrl).then(response => {
        //             return response.json();
        //         });
   }

   addCategory(category)
   {
        return axios.post(this.baseUrl, category);

        // return fetch( this.baseUrl,
        //     {
        //         method: "POST",
        //         "Content-Type": "application/json",
        //         body: JSON.stringify(category)
        //     }
        // ).then(response => {
        //     return response.json();
        // });
   }
}