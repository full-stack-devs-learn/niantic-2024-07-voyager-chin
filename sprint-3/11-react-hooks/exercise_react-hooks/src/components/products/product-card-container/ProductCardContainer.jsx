import { useEffect, useState } from "react";
import ProductCard from "../product-card/ProductCard";
import productService from "../../../services/product-service";

export default function ProductCardContainer()
{
    let [selectedProduct, setSelectedProduct] = useState("None Selected");
    let [selectedProductId, setSelectedProductId] = useState(0);
    let [products, setProducts] = useState([]);

    useEffect(() => {

        productService.getProducts().then(data => {
            setProducts(data);
        })
    }, []); // empty array means run only on first render

    const productSelected = (name) =>
    {
        setSelectedProduct(name);

        const productId = products.filter(p => p.productName === name)[0].productId;

        setSelectedProductId(productId);
    }

    const productDeleted = (productId) => {
        const newList = products.filter(p => p.productId !== productId);
        setProducts(newList);
    }

    return (
        <main className="container mt-4 products-container" id="products-container">
            {
                products.map((product) => (
                    <ProductCard key={product.productId}
                    product={product.productName}
                    unitPrice={product.unitPrice}
                    ></ProductCard>
                ))
            }
        </main>
    )

}