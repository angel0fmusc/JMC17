package dev.lpa;

public class GameController extends ProductForSale{
    public GameController(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("%s\t\t$%.2f%n",type, price);
        System.out.println("-".repeat(30));
        System.out.println(description);
    }
}
