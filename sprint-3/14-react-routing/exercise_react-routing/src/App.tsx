import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from "./components/header/Header"
import Home from "./components/home/Home"
import CategoriesList from "./components/categories/categories-list/CategoriesList"
import ProductsList from "./components/products/products-list/ProductsList"
import CategoriesPage from "./components/categories/categories-page/CategoriesPage"
import CategoryDetails from "./components/categories/category-details/CategoryDetails"
import CategoryAdd from "./components/categories/category-add/CategoryAdd"
import CategoryEdit from "./components/categories/category-edit/CategoryEdit"
import ProductsPage from "./components/products/products-page/ProductsPage"
import ProductDetails from "./components/products/product-details/ProductDetails"
import ProductAdd from "./components/products/product-add/ProductAdd"
import ProductEdit from "./components/products/product-edit/ProductEdit"

function App() {

    return (
        <>
            <Router>
                <Header />
                <Routes>
                    <Route path='/' element={<Home />}/>
                    <Route path='/categories' element={<CategoriesPage />}>
                        <Route path='' element={<CategoriesList />} />
                        <Route path=':categoryId' element={<CategoryDetails />} />
                        <Route path='add' element={<CategoryAdd />} />
                        <Route path='edit' element={<CategoryEdit />} />
                    </Route>
                    <Route path='/products' element={<ProductsPage />}>
                        <Route path='' element={<ProductsList />} />
                        <Route path=':productId' element={<ProductDetails />} />
                        <Route path='add' element={<ProductAdd />} />
                        <Route path='edit' element={<ProductEdit />} />
                    </Route>
                </Routes>
            </Router>
        </>
    )
}

export default App