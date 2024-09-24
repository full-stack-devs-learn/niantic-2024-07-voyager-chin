import { useState } from 'react';
import CategoryCard from '../category-card/CategoryCard'
import './CategoryCardContainer.css'
import { categories } from '../../../data'

export default function CategoryCardContainer()
{
    const [selectedCategory, setSelectedCategory] = useState("None Selected");

    const categorySelected = (name) =>
    {
        setSelectedCategory(name);
        console.log(name)
    }

    return(
        <>
        <h5 className="container">Selected Category: {selectedCategory}</h5>
        <main className="container mt-4 categories-container" id="categories-container">
        {
            categories.map((category) => (
                <CategoryCard key={category.categoryId} 
                    category={category.categoryName} 
                    id={category.categoryId}
                    onCategorySelected={categorySelected}
                    ></CategoryCard>
            ))
        }
        </main>
        </>
    )
}