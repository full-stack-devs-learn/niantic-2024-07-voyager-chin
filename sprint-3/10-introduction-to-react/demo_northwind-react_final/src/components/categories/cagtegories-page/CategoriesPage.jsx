import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import './CategoriesPage.css'

export default function CategoriesPage()
{
    return (
        <>
            <header className="container mt-4">
                <h1>Categories</h1>
            </header>

            <CategoryCardContainer></CategoryCardContainer>
        </>
    )
}