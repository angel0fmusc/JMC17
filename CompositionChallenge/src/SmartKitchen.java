public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private Refrigerator iceBox;
    private DishWasher dishWasher;

    public SmartKitchen() {

        this.brewMaster = new CoffeeMaker();
        this.iceBox = new Refrigerator();
        this.dishWasher = new DishWasher();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public void addWater(){
        brewMaster.hasWorkToDo = true;
        brewMaster.brewCoffee();
    }

    public void pourMilk(){
        iceBox.hasWorkToDo = true;
        iceBox.orderFood();
    }

    public void loadDishwasher(){
        dishWasher.hasWorkToDo = true;
        dishWasher.doDishes();
    }

    public void setKitchenState(boolean dishWasherWork, boolean iceBoxWork, boolean coffeeMakerWork){
        if(dishWasherWork){
            loadDishwasher();
        }
        if (iceBoxWork){
            pourMilk();
        }
        if(coffeeMakerWork){
            addWater();
        }
    }

    public void doKitchenWork(){
        addWater();
        loadDishwasher();
        pourMilk();
    }
}
