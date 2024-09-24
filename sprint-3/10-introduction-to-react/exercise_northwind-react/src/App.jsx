function App() {

  return (
    <>
      <div id="navigation">
        <img src="images/logo.png" alt="Northwind Logo" />
        <h1>Northwind Traders</h1>
      </div>

      <header className="container mt-4">
        <h1>Employees</h1>
      </header>

      <main className="container mt-4 employees-container" id="employees-container">

        <div className="employee-row">
          <img id="employee-image" src="images/employees/1.webp" />
          <div className="employee-name">
            <h1>Nancy Davolio</h1>
            <h6>Sales Representative</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/2.webp" />
          <div className="employee-name">
            <h1>Andrew Fuller</h1>
            <h6>Vice President, Sales</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/3.webp" />
          <div className="employee-name">
            <h1>Janet Leverling</h1>
            <h6>Sales Representative</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/4.webp" />
          <div className="employee-name">
            <h1>Margaret Peacock</h1>
            <h6>Sales Representative</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/5.webp" />
          <div className="employee-name">
            <h1>Steven Buchanan</h1>
            <h6>Sales Manager</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/6.webp" />
          <div className="employee-name">
            <h1>Michael Suyama</h1>
            <h6>Sales Representative</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/7.webp" />
          <div className="employee-name">
            <h1>Robert King</h1>
            <h6>Sales Representative</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/8.webp" />
          <div className="employee-name">
            <h1>Laura Callahan</h1>
            <h6>Inside Sales Coordinator</h6>
          </div>
        </div>
        <div className="employee-row">
          <img id="employee-image" src="images/employees/9.webp" />
          <div className="employee-name">
            <h1>Anne Dodsworth</h1>
            <h6>Sales Representative</h6>
          </div>
        </div>

      </main>

    </>
  )
}

export default App
