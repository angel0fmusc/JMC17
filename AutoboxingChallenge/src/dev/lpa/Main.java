package dev.lpa;

public class Main {
    public static void main(String[] args) {
        Bank truist = new Bank("Truist");

        Customer jenny = new Customer("Jenny", 500.00);
        System.out.println(jenny);

        truist.addCustomer("Bob",10.00);
        truist.addCustomer("Bob",30.00);
        truist.addCustomer("Gerry",25.00);
        truist.addCustomer("Tom",150.00);
        System.out.println(truist);

        truist.addTransaction("Bob", 15.00);
        truist.addTransaction("Gerry", 15.00);
        truist.addTransaction("Bob", -5.00);
        truist.addTransaction("Marty", -10.00);
        truist.printCustomerInfo("Marty");
        truist.printCustomerInfo("Bob");
        truist.printCustomerInfo("Gerry");
        truist.printCustomerInfo("Tom");
    }
}
