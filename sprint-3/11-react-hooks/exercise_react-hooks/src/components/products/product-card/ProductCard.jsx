import productService from "../../../services/product-service";
import './ProductCard.css';

export default function ProductCard({ id, product, unitPrice }) {
    const imageUrl = 'https://cdn-icons-png.flaticon.com/128/3731/3731085.png';

    return (
        <>
            <div className="card product-card">
                <div id="product-header" className="card-header">{product}</div>
                <div id="product-body" className="card-body">
                    <img id="product-image" src={imageUrl} />
                </div>
            </div>
            <div className="card-footer">{unitPrice}</div>
        </>
    )
}