import { Category } from "../../../models/category";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { AppDispatch, RootState } from "../../../store/store";
import { useSelector } from "react-redux";
import { useEffect } from "react";
import { loadCategories } from "../../../store/features/categories-slice";

export default function CategoryAdd()
{
    // const dispatch = useDispatch<AppDispatch>()
    // const { categories, loading, error } = useSelector((state: RootState) => state.categories);

    return (
        <div className="container">
            <h1>Add Category</h1>

        </div>
    )
}