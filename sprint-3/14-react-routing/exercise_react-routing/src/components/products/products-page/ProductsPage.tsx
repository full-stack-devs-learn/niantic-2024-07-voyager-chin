import { Outlet } from "react-router-dom";

export default function ProductsPage()
{
    return (
        <>  
            <div className="container">
                <h1>Products</h1>
                <Outlet />
            </div>
        </>
    )
}