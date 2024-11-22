package dev.lpa;

import java.util.ArrayList;

public class Store {

    private static ArrayList<ProductForSale> productsForSale;

    public static void main(String[] args) {
        stockStore();

        for(ProductForSale product : productsForSale){
            product.showDetails();
            System.out.println();
        }

        ArrayList<OrderItem> myOrder = new ArrayList<>();
        addItemToOrder(myOrder,"Markers",2);
        addItemToOrder(myOrder,"brush",2);
        addItemToOrder(myOrder, "tumbler", 4);
        addItemToOrder(myOrder, "controller",2);
        printedOrder(myOrder);


    }

    private static void addItemToOrder(ArrayList<OrderItem> myOrder, String itemName, int quantity){

        // Check if the item is already in the order
        // if so, increase the quantity by OrderItem.quantity
        for(ProductForSale product : productsForSale){
            if(product.type.equalsIgnoreCase(itemName)){
                OrderItem newOrderItem = new OrderItem(quantity, product);
                myOrder.add(newOrderItem);
                System.out.printf("[%d] %s added to your order%n%n", quantity, itemName);
                return;
            }
        }
        // If we get to the end of the productsForSale and item not found
        // Print message stating this item is not at this store
        System.out.println("Sorry, we do not carry this item: " + itemName);
    }

    private static void printedOrder(ArrayList<OrderItem> order){
        if(order.isEmpty()){
            System.out.println("You have nothing in your cart");
            return;
        } else{
            for(OrderItem item : order){
                item.product().printPricedItem(item.quantity());
            }
        }

    }

    private static void stockStore(){
        productsForSale = new ArrayList<>();
        Hairbrush brush = new Hairbrush("Brush", 3.00, "A boar bristle hairbrush");
        Tumbler tumbler = new Tumbler("Tumbler", 15.00, "40 oz tumbler for hot and cold" +
                " drinks");
        GameController xboxController = new GameController("Controller",
                70.00, "White XBOX controller");

        productsForSale.add(brush);
        productsForSale.add(xboxController);
        productsForSale.add(tumbler);
    }
}
