let should = chai.should();


describe("Lab - Programming with JavaScript", () =>
{
  describe("Problem  1 - Claire's Cookies", () => 
  {
    describe("1. Calculate Order SubTotal", () => 
    {
      it("Should return 12.95 for 1 dozen cookies", () =>
      {
        const quantity = 1;
        const expected = 12.95;

        const actual = calculateOrderSubtotal(quantity);
        
        actual.should.equal(expected);
      });
      it("Should return 25.90 for 2 dozen cookies", () =>
      {
        const quantity = 2;
        const expected = 25.90;
        
        const actual = calculateOrderSubtotal(quantity);
        
        actual.should.equal(expected);
      });
      it("Should return 64.75 for 5 dozen cookies", () =>
      {
        const quantity = 5;
        const expected = 64.75;
        
        const actual = calculateOrderSubtotal(quantity);
        
        actual.should.equal(expected);
      });
    })

    describe("2. Calculate Tax", () => 
    {
      it("Should return .74 for 1 dozen cookies", () =>
      {
        const quantity = 1;
        const expected = .74;
        
        const actual = calculateTax(quantity);
        
        actual.should.equal(expected);
      });
      it("Should return 1.49 for 2 dozen cookies", () =>
      {
        const quantity = 2;
        const expected = 1.49;
        
        const actual = calculateTax(quantity);
        
        actual.should.equal(expected);
      });
      it("Should return 3.72 for 5 dozen cookies", () =>
      {
        const quantity = 5;
        const expected = 3.72;
        
        const actual = calculateTax(quantity);
        
        actual.should.equal(expected);
      });
    })

    describe("3. Calculate Order Total", () => 
    {
      it("Should return 13.69 for 1 dozen cookies", () =>
      {
        const quantity = 1;
        const expected = 13.69;
        
        const actual = calculateOrderTotal(quantity);
        
        actual.should.equal(expected);
      });
      it("Should return 27.39 for 2 dozen cookies", () =>
      {
        const quantity = 2;
        const expected = 27.39;
        
        const actual = calculateOrderTotal(quantity);
        
        actual.should.equal(expected);
      });
      it("Should return 68.47 for 5 dozen cookies", () =>
      {
        const quantity = 5;
        const expected = 68.47;
        
        const actual = calculateOrderTotal(quantity);
        
        actual.should.equal(expected);
      });
    })


    describe("4. Place Order", () => 
    {
      it("Should return receipt for Sean's order of 1 dozen cookies", () =>
      {
        const customer = "Sean";
        const quantity = 1;
        const expected = {
          customer: customer,
          quantity: quantity,
          subtotal: 12.95,
          tax: .74,
          total: 13.69
        }
        const actual = placeOrder(customer, quantity);
        actual.should.eql(expected);
      });
      it("Should return receipt for Sean's order of 5 dozen cookies", () =>
      {
        const customer = "Sean";
        const quantity = 5;
        const expected = {
          customer: customer,
          quantity: quantity,
          subtotal: 64.75,
          tax: 3.72,
          total: 68.47
        }
        const actual = placeOrder(customer, 5);

        actual.should.eql(expected);
      });
    })

    describe("5. Calculate Cookies Needed", () =>
    {
      it("Should return 3 dozen for (2, 4, 8) because Sean would need 36 cookies", () =>
      {
        const aStudents = 2;
        const bStudents = 4;
        const other = 8;
        const expected = 3;

        const actual = calculateCookiesNeeded(aStudents, bStudents, other);
        
        actual.should.equal(expected);
      });
      it("Should return 4 dozen for (1, 5, 12) because Sean would need 43 cookies", () =>
      {
        const aStudents = 1;
        const bStudents = 5;
        const other = 12;
        const expected = 4;

        const actual = calculateCookiesNeeded(aStudents, bStudents, other);
        
        actual.should.equal(expected);
      });
    });
  });

  describe("Problem 2 - Pizza Shack", () =>
  {
    
    const ham = "Ham";
    const pineapple = "Pineapple";
    const mushroom = "Mushroom";
    const pepperoni = "Pepperoni";
    const sausage = "Sausage";
    const beef = "Beef";
    const chicken = "Chicken";
    const pepper = "Pepper";
    const onion = "Onion";
    const artichoke = "Artichoke";
    const blackOlive = "Black Olives";
    const spinach = "Spinach";
    const zucchini = "Zucchini";
    const tomato = "Tomato";
    const cheese = "Cheese";

    const hawaiianName = "Hawaiian";
    const cowboyName = "Cowboy";
    const supremeName = "Supreme";
    const vegetarianName = "Vegetarian";
    const cheeseName = "Cheese";

    const hawaiianToppings = [ham, pineapple, mushroom];
    const cowboyToppings = [pepperoni, sausage, beef];
    const supremeToppings = [pepperoni, sausage, pepper, onion, blackOlive];
    const vegetarianToppings = [spinach, zucchini, mushroom, artichoke, tomato, onion];
    const cheeseToppings = [cheese];

    const hawaiianPizza = { name: hawaiianName, toppings: hawaiianToppings};
    const cowboyPizza = { name: cowboyName, toppings: cowboyToppings};
    const supremePizza = { name: supremeName, toppings: supremeToppings};
    const vegetarianPizza = { name: vegetarianName, toppings: vegetarianToppings};
    const cheesePizza = { name: cheeseName, toppings: cheeseToppings};

    

    describe("1. Get Toppings", () =>
    {

      it("Should include correct toppings for 'Hawaiian'", () =>
      {
        const actual = getToppings(hawaiianName);        
        actual.should.eql(hawaiianToppings)
      });
      
      it("Should include correct toppings for 'Cowboy'", () =>
      {
        const actual = getToppings(cowboyName);
        
        actual.should.eql(cowboyToppings)
      });
      
      it("Should include correct toppings for 'Supreme'", () =>
      {
        const actual = getToppings(supremeName);
        
        actual.should.eql(supremeToppings)
      });
      
      it("Should include correct toppings for 'Vegetarian'", () =>
      {
        const actual = getToppings(vegetarianName);
        
        actual.should.eql(vegetarianToppings)
      });
      
      it("Should include correct toppings for 'Cheese'", () =>
      {
        const actual = getToppings(cheeseName);
        
        actual.should.eql(cheeseToppings)
      });
      
      it("Should return an empty array for an incorrect pizza type", () =>
      {
        const actual = getToppings("Meat Lover");
        
        actual.should.eql([])
      });

      it("Should include correct toppings for 'HAWAIIAN'", () =>
      {
        const actual = getToppings("HAWAIIAN");        
        actual.should.eql(hawaiianToppings)
      });

      it("Should include correct toppings for 'HaWaIiAn'", () =>
      {
        const actual = getToppings("HaWaIiAn");        
        actual.should.eql(hawaiianToppings)
      });
    });

    describe("2. Make Pizza", () =>
    {
      it("Should return a Hawaiian Pizza", () =>
      {
        const actual = makePizza(hawaiianName);
        actual.should.eql(hawaiianPizza);
      });
      
      it("Should return a Cowboy Pizza", () =>
      {
        const actual = makePizza(cowboyName);
        actual.should.eql(cowboyPizza);
      });
      
      it("Should return a Supreme Pizza", () =>
      {
        const actual = makePizza(supremeName);
        actual.should.eql(supremePizza);
      });
      
      it("Should return a Vegetarian Pizza", () =>
      {
        const actual = makePizza(vegetarianName);
        actual.should.eql(vegetarianPizza);
      });
      
      it("Should return a Cheese Pizza", () =>
      {
        const actual = makePizza(cheeseName);
        actual.should.eql(cheesePizza);
      });
      
      it("Should return no pizza for an invalid name '{}'", () =>
      {
        const actual = makePizza("Meat Lover");
        console.log(actual);
        actual.should.eql({});
      });
    })

    describe("3. Make Custom Pizza", () =>
    {
      it("Should return a Custom 1 topping", () =>
      {
        const expected = {name: "Custom", toppings: [chicken]}
        
        const actual = makeCustom(chicken)

        actual.should.eql(expected);
      });

      it("Should return a Custom 2 topping", () =>
      {
        const expected = {name: "Custom", toppings: [chicken, mushroom]}
        
        const actual = makeCustom(chicken, mushroom)

        actual.should.eql(expected);
      });

      it("Should return a Custom 3 topping", () =>
      {
        const expected = {name: "Custom", toppings: [chicken, mushroom, artichoke]}
        
        const actual = makeCustom(chicken, mushroom, artichoke)

        actual.should.eql(expected);
      });
      
      it("Should return no pizza for custom 0 topping pizza '{}'", () =>
      {
        const actual = makeCustom();

        actual.should.eql({});
      });
    })    

    describe("4. Create Order", () =>
    {
      it("Should return an order with 1 Hawaiian pizza", () =>
      {
        const customer = "Gary";
        const hawaiian = true;
        const cowboy = false;
        const supreme = false;
        const vegetarian = false;
        const cheese = false;
        
        const expected = {customer: "Gary", pizzas: [hawaiianPizza]}
        
        const actual = createOrder(customer, hawaiian, cowboy, supreme, vegetarian, cheese);

        actual.should.eql(expected);
      });
      
      it("Should return an order with Hawaiian and Supreme pizza", () =>
      {
        const customer = "Gary";
        const hawaiian = true;
        const cowboy = false;
        const supreme = true;
        const vegetarian = false;
        const cheese = false;
        
        const expected = {customer: "Gary", pizzas: [hawaiianPizza, supremePizza]}
        
        const actual = createOrder(customer, hawaiian, cowboy, supreme, vegetarian, cheese);

        actual.should.eql(expected);
      });
      
      it("Should return an order with Cowboy, Vegerarian and Cheese pizza", () =>
      {
        const customer = "Gary";
        const hawaiian = false;
        const cowboy = true;
        const supreme = false;
        const vegetarian = true;
        const cheese = true;
        
        const expected = {customer: "Gary", pizzas: [cowboyPizza, vegetarianPizza, cheesePizza]}
        
        const actual = createOrder(customer, hawaiian, cowboy, supreme, vegetarian, cheese);

        actual.should.eql(expected);
      });
      
      it("Should not create an order if there are no pizzas selected '{}'", () =>
      {
        const customer = "Gary";
        const hawaiian = false;
        const cowboy = false;
        const supreme = false;
        const vegetarian = false;
        const cheese = false;
        
        const expected = {}
        
        const actual = createOrder(customer, hawaiian, cowboy, supreme, vegetarian, cheese);

        actual.should.eql(expected);
      });
    })
  });

});
