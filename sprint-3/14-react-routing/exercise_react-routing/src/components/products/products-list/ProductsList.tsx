import { useSearchParams } from "react-router-dom"

export default function ProductsList()
{
    const [searchParams] = useSearchParams();

    const minPrice = searchParams.get('minPrice');
    const maxPrice = searchParams.get('maxPrice');
    const name = searchParams.get('name');
    const catId = searchParams.get('catId');

    return (
        <>
            <h1>Products List</h1>
        </>
    )
}