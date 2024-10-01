import { Outlet } from "react-router-dom";

export default function CategoriesPage()
{
    return (
        <>
            <div className="container">
                <h1>Categories</h1>
                <Outlet />
            </div>
        </>
    )
}