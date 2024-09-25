import './ProductsList.css'

export default function ProductsList({categoryId})
{
    // call the products api - getProductsByCategoryId
    return (
        <>
        {(categoryId == 0) 
        ? <div>No Category Selected</div>
        : <h3>
                Products for category: {categoryId}
          </h3>
        }
        </>
    )
}