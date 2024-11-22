package dev.lpa;

public record OrderItem(int quantity, ProductForSale product) {

//    @Override
//    public String toString() {
//        return String.format("[%d] %s\t\t $%5.2f",
//                quantity, product.type, product.getSalesPrice(quantity) );
//    }
}
