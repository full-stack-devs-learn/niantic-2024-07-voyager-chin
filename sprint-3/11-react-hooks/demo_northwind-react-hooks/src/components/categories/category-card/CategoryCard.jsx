import './CategoryCard.css'

export default function CategoryCard({id, category, onCategorySelected})
{
    const imageUrl = `images/categories/${id}.webp`
    
    const categoryClicked = () => {
        // console.log(id)
        // console.log(category); 
        onCategorySelected(category)       
    }

    return(
        <div className="card category-card" onClick={categoryClicked}>
            <div id="category-header" className="card-header">{category}</div>
            <div id="category-body" className="card-body">
                <img id="category-image" src={imageUrl} />
            </div>
        </div>
    )
}