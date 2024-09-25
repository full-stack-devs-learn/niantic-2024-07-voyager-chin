import { useState } from "react"
import Header from "./components/header/Header"
import CategoriesPage from "./components/categories/cagtegories-page/CategoriesPage"
import ProductsPage from "./components/products/products-page/ProductsPage"

function App() {
  const [pageName, setPageName] = useState("categories")

  const pageChangeHanlder = (newPage) =>
  {
    setPageName(newPage);
    console.log("changing page to: " + pageName); 
  }

  console.log("page render: " + pageName)
  

  return (
    <>
      <Header onPageChanged={pageChangeHanlder}></Header>

      { (pageName=="categories") ? <CategoriesPage></CategoriesPage> : null}
      { (pageName=="products") && <ProductsPage></ProductsPage> }
    </>
  )
}

export default App
