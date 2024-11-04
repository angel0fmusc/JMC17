public class Main {
    public static void main(String[] args) {

//        Item coke = new Item("drink", "coke", 1.50);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();
//
//        Item avocado = new Item("topping", "avocado", 1.50);
//        avocado.printItem();

//        Burger burger = new Burger("regular", 4.00);
//        burger.addToppings("Bacon", "Cheese", "mayo");
//        burger.printItem();

//        Meal regularMeal = new Meal();
//        regularMeal.printItemizedList();
//
//        regularMeal.addBurgerToppings("BACON","CHEESE", "MAYO");
//        regularMeal.printItemizedList();

        Meal secondOrder = new Meal("turkey", "7-up", "chili");
        secondOrder.addBurgerToppings("LETTUCE","CHEESE","MAYO");
        secondOrder.setDrinkSize("SMALL");
        secondOrder.printItemizedList();

    }
}
