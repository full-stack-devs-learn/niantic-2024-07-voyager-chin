import { useState } from "react"
import Header from "./components/header/Header"
import CategoriesPage from "./components/categories/categories-page/CategoriesPage"
import ProductsPage from "./components/products/products-page/ProductsPage"

function App() {
  const [pageName, setPageName] = useState("categories")

  const pageChangeHandler = (newPage) =>
  {
    setPageName(newPage);
    console.log("changing page to: " + pageName); 
  }

  console.log("page render: " + pageName)
  

  return (
    <>
      <Header onPageChanged={pageChangeHandler}></Header>

      { (pageName=="categories") ? <CategoriesPage></CategoriesPage> : null}
      { (pageName=="products") && <ProductsPage></ProductsPage> }
    </>
  )
}

export default App
