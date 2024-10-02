import { createSlice, PayloadAction, createAsyncThunk } from "@reduxjs/toolkit";
import { Product } from "../../models/product";
import productService from "../../services/products-service";

interface ProductsState {
    products: Product[]
    loading: boolean
    error: string | null
}

const initialState: ProductsState = {
    products: [],
    loading: false,
    error: null
}

export const loadProducts = createAsyncThunk('products/getProducts', async (productName: string | null) => {
    let products = await productService.getProducts();
    if(productName !== null)
    {
        products = products.filter(p => p.productName == productName);
    }
    return products;
})

export const addProduct = createAsyncThunk('products/addProduct', async (product: Product) => {
    const newProduct = await productService.add(product);
    return newProduct;
})

export const updateProduct = createAsyncThunk('products/updateProduct', async (product: Product) => {
    await productService.update(product.productId, product);
    return product;
})

export const deleteProduct = createAsyncThunk('products.deleteProduct', async (productId: number) => {
    await productService.delete(productId);
    return productId;
})

const productsSlice = createSlice({
    name: 'products',
    initialState,
    reducers: {

    },
    extraReducers: (builder) => {
        // fetch products
        builder.addCase(loadProducts.pending, (state) => {
            state.loading = true;
            state.error = null;
        });
        builder.addCase(loadProducts.fulfilled, (state, action: PayloadAction<Product[]>) => {
            state.loading= false;
            state.products = action.payload;
        });
        builder.addCase(loadProducts.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Failed to fetch products';
        });

        // add product
        builder.addCase(addProduct.pending, (state) => {
            state.loading = true;
            state.error = null;
        });
        builder.addCase(addProduct.fulfilled, (state, action: PayloadAction<Product>) => {
            state.loading = false;
            state.products.push(action.payload);
        });
        builder.addCase(addProduct.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Failed to add product';
        });

        // update product
        builder.addCase(updateProduct.pending, (state) => {
            state.loading = true;
            state.error = null;
        });
        builder.addCase(updateProduct.fulfilled, (state, action: PayloadAction<Product>) => {
            state.loading = false;
            const index = state.products.findIndex(p => p.productId === action.payload.productId);
            if(index !== -1) {
                state.products[index] = action.payload;
            }
        });
        builder.addCase(updateProduct.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Failed to update product';
        });

        // delete product
        builder.addCase(deleteProduct.pending, (state) => {
            state.loading = true;
            state.error = null;
        });
        builder.addCase(deleteProduct.fulfilled, (state, action: PayloadAction<number>) => {
            state.loading = false;
            state.products = state.products.filter(p => p.productId !== action.payload);
        });
        builder.addCase(deleteProduct.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Failed to delete product';
        });
    },
})

const productsReducer = productsSlice.reducer;
export default productsReducer;