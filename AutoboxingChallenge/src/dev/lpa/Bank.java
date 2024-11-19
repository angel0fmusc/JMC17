package dev.lpa;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    /**
     * Searches the ArrayList of bank customers for the given customer.
     * Assume customers will have different names
     * @param customerName: String
     * @return true if customer is in list, otherwise returns false
     */
    private Customer findCustomer(String customerName){
        // If customers list is empty, return false/ customer not in list
        if(customers.isEmpty()){
            return null;
        }

        // Loop through customers, return true
        // if the customer name matches
        for(Customer individual : customers){
            if(individual.getName().equalsIgnoreCase(customerName)){
                return individual;
            }
        }

        System.out.printf("Customer (%s) was not found%n", customerName);
        return null;
    }

    /**
     * See if customer exists in the bank's list of customers.
     * If not, add the customer to the list. Otherwise, print
     * a statement stating the customer is already registered
     * with this bank
     * @param customerName: Name
     */
    public void addCustomer(String customerName, double initialDeposit){
        if(findCustomer(customerName) == null){
            Customer newCustomer = new Customer(customerName, initialDeposit);
            customers.add(newCustomer);
            System.out.println("New Customer added: " + newCustomer);
            return;
        }
        System.out.println(customerName + " is already registered with " + bankName);
    }

    public void addTransaction(String customerName, double transaction){
        // If customer is not in bank list
        // Cannot add transaction
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer == null){
            System.out.println(customerName + " is not a customer of " + bankName);
            return;
        }
        // Get customer's transactions list and add this transaction
        existingCustomer.getTransactions().add(transaction);
    }

    public void printCustomerInfo(String customerName){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer == null){
            System.out.println(customerName + " is not a customer of " + bankName);
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + existingCustomer.getName());
        System.out.println("Transactions:");
        for(double d : existingCustomer.getTransactions()){
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + bankName + '\'' +
                ", customers = " + customers +
                '}';
    }

    //    public String printCustomers(){
//        String tempCustomerList = "";
//        for(Customer customer : customers){
//            tempCustomerList += customer.getName() + ", ";
//        }
//        return tempCustomerList;
//    }
//
//    @Override
//    public String toString() {
//        if(customers.isEmpty()){
//            return String.format("%s currently has no customers", bankName);
//        }
//        return (bankName + " has the following customers: " + printCustomers());
//    }
}
