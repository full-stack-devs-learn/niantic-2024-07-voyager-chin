import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { AppDispatch, RootState } from "../../../store/store";
import { useSelector } from "react-redux";
import { useEffect } from "react";
import { loadProducts } from "../../../store/features/products-slice";
import { Product } from "../../../models/product";

export default function ProductsList()
{
    // const [searchParams] = useSearchParams();

    // const minPrice = searchParams.get('minPrice');
    // const maxPrice = searchParams.get('maxPrice');
    // const name = searchParams.get('name');
    // const catId = searchParams.get('catId');

    const dispatch = useDispatch<AppDispatch>()
    const { products, loading, error } = useSelector((state: RootState) => state.products);

    useEffect(() => {
        if(products.length == 0)
        {
            dispatch(loadProducts(null))
        }
    }, [dispatch])

    if(loading) return <p>Loading products...</p>
    if(error) return <p>Error: {error}</p>

    return (
        <>
            <h1>Products List</h1>
            <Link className="btn btn-success" to="/products/add">Add</Link>

            <ul>
                {
                    products.map((p: Product) => (
                        <li key={p.productId}><Link to={`/products/${p.productId}`}>{p.productName}</Link></li>
                    ))
                }
            </ul>
        </>
    )
}