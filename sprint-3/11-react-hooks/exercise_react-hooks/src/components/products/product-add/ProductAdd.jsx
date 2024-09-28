import { useState } from "react";
import productService from "../../../services/product-service";

export default function ProductAdd({ onCancel, onProductAdded }) {
    const [productName, setProductName] = useState('');
    const [supplierId, setSupplierId] = useState('');
    const [categoryId, setCategoryId] = useState('');
    const [quantityPerUnit, setQuantityPerUnit] = useState('');
    const [unitPrice, setUnitPrice] = useState('');
    const [unitsInStock, setUnitsInStock] = useState('');
    const [unitsOnOrder, setUnitsOnOrder] = useState('');
    const [reorderLevel, setReorderLevel] = useState('');
    const [discontinued, setDiscontinued] = useState('true');

    async function addProductHandler(event) {
        event.preventDefault()

        const newProduct = {
            productName: productName,
            supplierId: supplierId,
            categoryId: categoryId,
            quantityPerUnit: quantityPerUnit,
            unitPrice: unitPrice,
            unitsInStock: unitsInStock,
            unitsOnOrder: unitsOnOrder,
            reorderLevel: reorderLevel,
            discontinued: discontinued
        }

        await productService.addProduct(newProduct)

        onProductAdded()
    }

    const checkboxChange = (event) => {
        setDiscontinued(event.target.checked);
    }

    return (
        <div className="container mt-5 mb-5">
            <h3>Add New Product</h3>
            <div className="container">
                <form onSubmit={addProductHandler}>
                    <div className="row">
                        <label htmlFor="product-name" className="form-label mt-4">Product Name:</label>
                        <input type="text" className="form-control" name="product-name" id="product-name"
                            onChange={(e) => setProductName(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="supplier-id" className="form-label mt-4">Supplier Id:</label>
                        <input type="text" className="form-control" name="supplier-Id" id="supplier-id"
                            onChange={(e) => setSupplierId(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="category-id" className="form-label mt-4">Category Id:</label>
                        <input type="text" className="form-control" name="category-id" id="category-id"
                            onChange={(e) => setCategoryId(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="quantity-per-unit" className="form-label mt-4">Quantity per Unit:</label>
                        <input type="text" className="form-control" name="quantity-per-unit" id="quantity-per-unit"
                            onChange={(e) => setQuantityPerUnit(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="unit-price" className="form-label mt-4">Unit Price:</label>
                        <input type="text" className="form-control" name="unit-price" id="unit-price"
                            onChange={(e) => setUnitPrice(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="units-in-stock" className="form-label mt-4">Units in Stock:</label>
                        <input type="text" className="form-control" name="units-in-stock" id="units-in-stock"
                            onChange={(e) => setUnitsInStock(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="units-on-order" className="form-label mt-4">Units on Order:</label>
                        <input type="text" className="form-control" name="units-on-order" id="units-on-order"
                            onChange={(e) => setUnitsOnOrder(e.target.value)} />
                    </div>
                    <div className="row">
                        <label htmlFor="reorder-level" className="form-label mt-4">Reorder Level:</label>
                        <input type="text" className="form-control" name="reorder-level" id="reorder-level"
                            onChange={(e) => setReorderLevel(e.target.value)} />
                    </div>
                    <div className="row">
                            <label htmlFor="discontinued" className="form-check-label mt-4">{discontinued ? "Discontinued" : "Product discontinued?"}</label>
                            <input type="checkbox" checked={discontinued} onChange={checkboxChange}
                                className="form-control form-check-input" name="discontinued" id="discontinued"/>
                                </div>
                    <span className="container">
                        <button className="btn btn-danger mt-3" type="submit">Add Product</button>
                    </span>
                    <button className="btn btn-dark mt-3" type="cancel" onClick={onCancel}>Cancel</button>
                </form>
            </div>
        </div>
    )
}