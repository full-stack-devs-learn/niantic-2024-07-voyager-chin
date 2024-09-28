import { useState } from 'react'
import CategoryAdd from '../category-add/CategoryAdd'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import './CategoriesPage.css'

export default function CategoriesPage() {
    const [action, setAction] = useState("list");
    const [displayButton, setDisplayButton] = useState(true);

    const addButtonClick = () => {
        setDisplayButton(false);
        setAction("add");
    }

    const displayCategories = () => {
        setDisplayButton(true);
        setAction("list")
    }

    return (
        <div className='container'>

            <header className="container mt-4">
                <h1>Categories</h1>
                {displayButton && (
                    <button className="btn btn-danger" onClick={addButtonClick}>Add</button>
                )}
            </header>

            {action === "list" && <CategoryCardContainer></CategoryCardContainer>}
            {action === "add" && <CategoryAdd onCancel={displayCategories}
                onCategoryAdded={displayCategories}
            ></CategoryAdd>}

        </div>
    )
}