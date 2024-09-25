import { useState } from "react"
import Header from "./components/header/Header"
import CategoriesPage from "./components/categories/cagtegories-page/CategoriesPage"
import ProductsPage from "./components/products/products-page/ProductsPage"

function App() {
  const [pageName, setPageName] = useState("products")

  const pageChangeHanlder = (pageName) =>
  {
    setPageName(pageName)
  }
  

  return (
    <>
      <Header onPageChanged={pageChangeHanlder}></Header>

      { (pageName=="categories") ? <CategoriesPage></CategoriesPage> : null}
      { (pageName=="products") && <ProductsPage></ProductsPage> }
    </>
  )
}

export default App
