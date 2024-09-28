import axios from 'axios'

class ProductService {
    baseUrl = 'http://localhost:8080/products'

    getProducts(categoryId = null) {
        if (categoryId == null) {
            return axios.get(this.baseUrl)
                .then(response => {
                    return response.data;
                })
        }
        else {
            return axios.get(`${this.baseUrl}?catId=${categoryId}`)
                .then(response => {
                    return response.data;
                })
        }
    }

    getProductByID(productId) {
        return axios.get(`${this.baseUrl}/${categoryId}`)
            .then(response => {
                return response.data;
            })
    }

    addProduct(product) {
        return axios.post(this.baseUrl, product)
            .then(response => {
                return response.data;
            })
    }

    updateProduct(productId, product) {
        return axios.put(`${this.baseUrl}/${productId}`, product);
    }

    deleteProduct(productId) {
        return axios.delete(`${this.baseUrl}/${productId}`);
    }
}

const productService = new ProductService();
export default productService;