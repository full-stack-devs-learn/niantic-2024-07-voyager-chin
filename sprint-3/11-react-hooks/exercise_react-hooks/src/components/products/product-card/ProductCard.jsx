import { useState } from "react";
import productService from "../../../services/product-service";
import './ProductCard.css';
import { XCircle, XCircleFill } from 'react-bootstrap-icons'

export default function ProductCard({ id, productId, product, categoryId, unitPrice, onProductSelected, onProductDeleted }) {
    const productClicked = () => {
        onProductSelected(product)
    }

    async function deleteProduct(event) {
        event.stopPropagation();

        await productService.deleteProduct(productId);

        onProductDeleted(productId);
    }

    return (
        <tr className="table-light">
            <td className="id">{productId}</td>
            <td className="product">{product}</td>
            <td className="category">{categoryId}</td>
            <td className="price">$ {unitPrice}</td>
            <td><XCircleFill onClick={deleteProduct} color="red" /></td>
        </tr>
    )
}