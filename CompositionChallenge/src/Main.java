public class Main {

    public static void main(String[] args) {

//        CoffeeMaker keurig = new CoffeeMaker();
//        Refrigerator fridge = new Refrigerator();
//        DishWasher bosch = new DishWasher();

        SmartKitchen myKitchen = new SmartKitchen();

        myKitchen.getDishWasher().doDishes();
        myKitchen.getIceBox().orderFood();
        myKitchen.getBrewMaster().brewCoffee();

        myKitchen.doKitchenWork();

    }
}
