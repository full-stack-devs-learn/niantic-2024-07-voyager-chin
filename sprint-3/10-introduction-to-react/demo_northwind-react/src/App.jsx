function App() {

  return (
    <>
      <div id="navigation">
        <img src="images/logo.png" alt="Northwind Logo" />
        <h1>Northwind Traders</h1>
      </div>

      <header className="container mt-4">
        <h1>Categories:</h1>
      </header>

      <main className="container mt-4 categories-container" id="categories-container">
        <div className="card category-card">
          <div id="category-header" className="card-header">Beverages</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/1.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Condiments</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/2.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Confections</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/3.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Dairy Products</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/4.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Grains/Cereals</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/5.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Meat/Poultry</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/6.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Produce</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/7.webp" />
          </div>
        </div>

        <div className="card category-card">
          <div id="category-header" className="card-header">Seafood</div>
          <div id="category-body" className="card-body">
              <img id="category-image" src="images/categories/8.webp" />
          </div>
        </div>
      </main>

    </>
  )
}

export default App
