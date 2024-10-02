import { configureStore } from "@reduxjs/toolkit";
import categoriesReducer from './features/categories-slice';
import productsReducer from "./features/products-slice";

const store = configureStore({
    reducer: {
        categories: categoriesReducer,
        products: productsReducer
    }
})

export type RootState = ReturnType <typeof store.getState>;
export type AppDispatch = typeof store.dispatch;

export default store;

