public class SmartAppliance {
    protected boolean hasWorkToDo;
    public SmartAppliance(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}

class Refrigerator extends SmartAppliance {

    public Refrigerator() {
        super(false);
    }

    public void orderFood(){
        if(super.hasWorkToDo){
            System.out.println("Ordering food...");
            super.hasWorkToDo = false;
        } else {
            System.out.println("You have food. Don't order");
        }

    }
}

class CoffeeMaker extends SmartAppliance {

    public CoffeeMaker() {
        super(false);
    }

    public void brewCoffee(){
        if(super.hasWorkToDo){
            System.out.println("Brewing coffee...");
            super.hasWorkToDo = false;
        } else {
            System.out.println("Please add water");
        }

    }
}

class DishWasher extends SmartAppliance {

    public DishWasher() {
        super(false);
    }

    public void doDishes(){
        if(super.hasWorkToDo){
            System.out.println("Dishwasher started!");
            super.hasWorkToDo = false;
        } else{
            System.out.println("Add more dishes!");
        }

    }
}
