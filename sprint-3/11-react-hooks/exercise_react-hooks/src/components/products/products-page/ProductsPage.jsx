import { useState } from 'react'
import ProductCardContainer from '../product-card-container/ProductCardContainer'
import './ProductsPage.css'
import ProductAdd from '../product-add/ProductAdd';

export default function ProductsPage() {
    const [action, setAction] = useState("list");

    return (
        <div>
            <header className="container mt-4">
                <h1>Products</h1>
                <button className="btn btn-danger" onClick={() => setAction("add")}>Add</button>
            </header>

            {action === "list" && <ProductCardContainer></ProductCardContainer>}
            {action === "add" && <ProductAdd onCancel={() => setAction("list")}
                                              onProductAdded={() => setAction("list")}
                ></ProductAdd>}
        </div>
    )
}