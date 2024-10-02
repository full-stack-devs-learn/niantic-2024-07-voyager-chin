import axios from "axios";
import { Product } from "../models/product";

class ProductService
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/products`;

    async getProducts(categoryId = null): Promise<Product[]>
    {
        if (categoryId == null) {
            return axios.get<Product[]>(this.baseUrl)
                .then(response => {
                    return response.data;
                })
        }
        else {
            return axios.get<Product[]>(`${this.baseUrl}?catId=${categoryId}`)
                .then(response => {
                    return response.data;
                })
        }
    }

    getProductByID(productId: number): Promise<Product>
    {
        return axios.get<Product>(`${this.baseUrl}/${productId}`)
            .then(response => {
                return response.data;
            })
    }

    add(product: Product) {
        return axios.post(this.baseUrl, product)
            .then(response => {
                return response.data;
            })
    }

    update(productId: number, product: Product) {
        return axios.put<void>(`${this.baseUrl}/${productId}`, product);
    }

    delete(productId: number) {
        return axios.delete<void>(`${this.baseUrl}/${productId}`);
    }
}

const productService = new ProductService();
export default productService;