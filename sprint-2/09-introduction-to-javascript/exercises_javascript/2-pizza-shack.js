/*
1.	Pizza Shack sells the best pizza in town.

	When customers are ready to order, they should
	be able to see a list of toppings that are 
	included on each type of pizza.

	getToppings("Hawaiian") => ["Ham","Pineapple","Mushroom"]
	getToppings("Cowboy") => ["Pepperoni", "Sausage", "Beef"]
	getToppings("Supreme") => ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"]
	getToppings("Vegetarian") => ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"]
	getToppings("Cheese") => ["Cheese"]

*/

function getToppings(selection)
{
	const hawaiian = ["Ham","Pineapple","Mushroom"];
	const cowboy = ["Pepperoni", "Sausage", "Beef"];
	const supreme = ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"];
	const vegetarian = ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"];
	const cheese = ["Cheese"];

	const toppings =  selection.toLowerCase() == "hawaiian" ? hawaiian
		: selection.toLowerCase() == "cowboy" ? cowboy
		: selection.toLowerCase() == "supreme" ? supreme
		: selection.toLowerCase() == "vegetarian" ? vegetarian
		: selection.toLowerCase() == "cheese" ? cheese : [];

	return toppings;
}


/*
2.	Pizza Shack sells the best pizza in town.

	When a customer places an order we make the pizza.
	the makePizza function should return a 
	pizza object with a name, and the list of toppings.

	makePizza("Hawaiian") => {
								name: "Hawaiian",
								toppings: ["Ham","Pineapple","Mushroom"]
							}

*/

function makePizza(order)
{
	const toppings = getToppings(order);

	const pizza = {};
	
	if (toppings.length > 0)
	{
		pizza.name = order.charAt(0).toUpperCase() + order.slice(1).toLowerCase();
		pizza.toppings = toppings;
	}

	return pizza;
}


/*
3.	Pizza Shack sells the best custom pizza in town.

	If a customer wants to order a custom pizza they
	can order up to 3 toppings. The makeCustom function
	should create the new pizza as follows...

	makeCustom("chicken") => 
					{
						name: "Custom",
						toppings: ["chicken"]
					}

	makeCustom("chicken", "mushroom") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom"]
					}

	makeCustom("chicken", "mushroom", "artichokes") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom", "artichokes"]
					}

	// a custom order with no toppings is not allowed an should return
	// an empty object
	makeCustom() => {}

*/

function makeCustom(a = '', b = '', c = '')
{
	const pizza = {};
	const toppings = [];

	if (a != '')
	{
		toppings.push(a)
	}
	if (b != '')
	{
		toppings.push(b)
	}
	if (c != '')
	{
		toppings.push(c)
	}

	if(toppings.length > 0)
	{
		pizza.name = "Custom";
		pizza.toppings = toppings;
	}

	return pizza;
}


/*
4.	Customers may want to order multiple pizzas on a single order.

	When a customer places an order you should create an order object.
	This includes the customer name, and an array of all the pizzas
	that they have ordered.

	createOrder("Gary", true, false, false, false, false) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				}
			]
		}
	

	createOrder("Gary", true, false, false, false, true) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				},
				{
					name: "Cheese",
					toppings: [
						"Cheese"
					]
				}
			]
		}


*/

function createOrder(customer, hawaiian=false, cowboy=false, supreme=false, vegetarian=false, cheese=false)
{
	const order = {};

	if (hawaiian || cowboy || supreme || vegetarian || cheese)
	{
		order.customer = customer;
		order.pizzas = [];
	}

	if(hawaiian){
		order.pizzas.push(makePizza('hawaiian'));
	}
	if(cowboy){
		order.pizzas.push(makePizza('cowboy'));
	}
	if(supreme){
		order.pizzas.push(makePizza('supreme'));
	}
	if(vegetarian){
		order.pizzas.push(makePizza('vegetarian'));
	}
	if(cheese){
		order.pizzas.push(makePizza('cheese'));
	}

	return order;
	
}
