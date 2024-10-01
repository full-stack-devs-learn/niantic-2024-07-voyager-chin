import { configureStore } from "@reduxjs/toolkit";
import actorsReducer from "./features/actors-slice";

const store = configureStore({
    reducer: {
        actors: actorsReducer
    }
})

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch

export default store;