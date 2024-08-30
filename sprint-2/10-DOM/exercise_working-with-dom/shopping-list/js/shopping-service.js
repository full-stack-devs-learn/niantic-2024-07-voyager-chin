class ShoppingService {

    getListName() {
        return "Grocery List";
    }

    getShoppingList() {
        return [
            {
                id: 1,
                title: '5 lb sack of potatoes',
                quantity: 1,
                isComplete: false
            },
            {
                id: 2,
                title: 'Frozen Pizza',
                quantity: 4,
                isComplete: true
            },
            {
                id: 3,
                title: '1 lb ground beef',
                quantity: 2,
                isComplete: false
            },
            {
                id: 4,
                title: '1 can tomato sauce',
                quantity: 5,
                isComplete: false
            },
            {
                id: 5,
                title: '1 dz eggs',
                quantity: 2,
                isComplete: false
            },
            {
                id: 6,
                title: '1 lb flour',
                quantity: 3,
                isComplete: false
            },
            {
                id: 7,
                title: '1 gal milk',
                quantity: 1,
                isComplete: false
            },
            {
                id: 8,
                title: '1 pt ice cream',
                quantity: 1,
                isComplete: false
            },
            {
                id: 9,
                title: '16 oz whole wheat bread',
                quantity: 2,
                isComplete: false
            },
            {
                id: 10,
                title: '1 lb carrots',
                quantity: 5,
                isComplete: true
            }
        ];
    }
}