import { Link } from "react-router-dom";
import { Category } from "../../../models/category";
import { useDispatch } from "react-redux";
import { AppDispatch, RootState } from "../../../store/store";
import { useSelector } from "react-redux";
import { useEffect } from "react";
import { loadCategories } from "../../../store/features/categories-slice";

export default function CategoriesList()
{
    const dispatch = useDispatch<AppDispatch>()
    const { categories, loading, error } = useSelector((state: RootState) => state.categories);

    useEffect(() => {
        if(categories.length == 0)
        {
            dispatch(loadCategories(null))
        }
    }, [dispatch])

    if (loading) return <p>Loading categories...</p>
    if (error) return <p>Error: {error}</p>

    return (
        <>
            <h1>Categories List</h1>
            <Link className="btn btn-success" to="/categories/add">Add</Link>

            <ul>
                {
                    categories.map((c: Category) => (
                        <li key={c.categoryId}><Link to={`/categories/${c.categoryId}`}>{c.categoryName}</Link></li>
                    ))
                }
            </ul>
        </>
    )
}