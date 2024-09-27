import productService from "../../../services/product-service";
import './ProductCard.css';

export default function ProductCard({ id, productId, product, unitPrice }) {
    const imageUrl = 'https://cdn-icons-png.flaticon.com/128/3731/3731085.png';

    return (
        <table className="table table-hover">
            <tbody>
                <tr className="table-light">
                    <td className="id">{productId}</td>
                    <td className="product">{product}</td>
                    <td className="price">${unitPrice}</td>
                </tr>
            </tbody>
        </table>
    )
}