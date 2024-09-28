import { useState } from 'react'
import ProductCardContainer from '../product-card-container/ProductCardContainer'
import './ProductsPage.css'
import ProductAdd from '../product-add/ProductAdd';

export default function ProductsPage() {
    const [action, setAction] = useState("list");
    const [displayButton, setDisplayButton] = useState(true);

    const addButtonClick = () => {
        setDisplayButton(false);
        setAction("add")
    }

    const displayProducts = () => {
        setDisplayButton(true);
        setAction("list")
    }

    return (
        <div className='container'>

            <header className="container mt-4">

                <h1>Products</h1>
                {displayButton && (
                    <button className="btn btn-danger" onClick={addButtonClick}>Add</button>
                )}
            </header>

            {action === "list" && <ProductCardContainer></ProductCardContainer>}
            {action === "add" && <ProductAdd onCancel={displayProducts}
                                             onProductAdded={displayProducts}
            ></ProductAdd>}

        </div>
    )
}