import { useEffect, useState } from 'react'
import './ProductsList.css'
import productService from '../../../services/product-service'

export default function ProductsList({ categoryId }) {
    const [products, setProducts] = useState([]);

    // call the products api - getProductsByCategoryId
    useEffect(() => {
        if (categoryId > 0) {
            productService.getProducts(categoryId).then(data => {
                setProducts(data);
            })
        }
    }, [categoryId])

    return (
        <>
            {(categoryId == 0)
                ? <div className='container mt-3'>No Category Selected</div>
                : <div className='container mt-3 mb-5'>
                    <table className='table table-hover'>
                        <thead>

                            <th>
                                Products for category: {categoryId}
                            </th>
                        </thead>
                        <tbody>
                            {
                                products.map((product) => (
                                    <tr>
                                        <td>{product.productName}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                </div>
            }
        </>
    )
}