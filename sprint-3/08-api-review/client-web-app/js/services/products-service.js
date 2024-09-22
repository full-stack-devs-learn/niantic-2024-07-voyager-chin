class ProductsService {

    baseUrl = `${config.baseUrl}/products`;

    getProducts(categoryId = null) 
    {
        if (categoryId == null)
        {
            return axios.get(this.baseUrl)
                .then(response => {
                    return response.data;
                })
        }
        else
        {
            return axios.get(`${this.baseUrl}?catId=${categoryId}`)
                .then(response => {
                    return response.json();
                })
        }

        // if (categoryId == null)
        // {
        //     return fetch(this.baseUrl)
        //         .then(response => {
        //             return response.json();
        //         })
        // }
        // else
        // {
        //     return fetch(`${this.baseUrl}?catId=${categoryId}`)
        //         .then(response => {
        //             return response.json();
        //         })
        // }
    }

    getProductByID(productId)
    {
        return axios.get(`${this.baseUrl}/${categoryId}`)
            .then(response => {
                return response.data;
            })

        // return fetch(`${this.baseUrl}/${productId}`)
        //     .then(response => {
        //         return response.json();
        //     })
    }

    addProduct(product)
    {
        return axios.post(this.baseUrl, product)
            .then(response => {
                return response.data;
            })
        
        // return fetch(this.baseUrl,
        //     {
        //         method: "POST",
        //         "Content-Type": "application/json",
        //         body: JSON.stringify(product)
        //     }
        // ).then(response => {
        //     return response.json();
        // })
    }

    updateProduct(productId, product)
    {
        return axios.put(`${this.baseUrl}/${productId}`, product);

        // return fetch(`${this.baseUrl}/${productId}`,
        //     {
        //         method: "PUT",
        //         "Content-Type": "application/json",
        //         body: JSON.stringify(product)
        //     }
        // ).then(response => {
        //     return response.json();
        // })
    }

    deleteProduct(productId)
    {
        return axios.delete(`${this.baseUrl}/${productId}`);

        // return fetch(`${this.baseUrl}/${productId}`,
        //     {
        //         method: "DELETE",
        //         "Content-Type": "application/json",
        //         body: JSON.stringify(product)
        //     }
        // ).then(response => {
        //     return response.json();
        // })
    }
}