import { useEffect, useState } from "react";
import ProductCard from "../product-card/ProductCard";
import './ProductCardContainer.css'
import productService from "../../../services/product-service";

export default function ProductCardContainer() {
    const [selectedProduct, setSelectedProduct] = useState("None Selected");
    const [selectedProductId, setSelectedProductId] = useState(0);
    const [products, setProducts] = useState([]);

    useEffect(() => {
        productService.getProducts().then(data => {
            setProducts(data);
        })
    }, []); // empty array means run only on first render

    const productSelected = (name) => {
        setSelectedProduct(name);

        const productId = products.filter(p => p.productName === name)[0].productId;

        setSelectedProductId(productId);
    }

    const productDeleted = (productId) => {
        const newList = products.filter(p => p.productId !== productId);
        setProducts(newList);
    }

    return (
        <main className="container mt-4 mb-5 products-container" id="products-container">
            <table className="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Product Name</th>
                        <th>Category Id</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map((product) => (
                            <ProductCard key={product.productId}
                                productId={product.productId}
                                product={product.productName}
                                categoryId={product.categoryId}
                                unitPrice={product.unitPrice}
                                onProductSelected={productSelected}
                                onProductDeleted={productDeleted}
                            ></ProductCard>
                        ))
                    }
                </tbody>
            </table>
        </main>
    )
}