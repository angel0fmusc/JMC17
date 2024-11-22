package dev.lpa;

public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public abstract void showDetails();

    /**
     * Takes a quantity and returns the quantity multiplied
     * by the price.
     * @param quantity: int
     * @return double
     */
    public double getSalesPrice(int quantity){
        return (quantity * price);
    }

    /**
     * Takes a quantity and prints an itemized line item
     * for an order, with quantity and line-tem price
     * @param quantity: int
     */
    public void printPricedItem(int quantity){
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n",
                quantity, price, type, description);
    }

}
