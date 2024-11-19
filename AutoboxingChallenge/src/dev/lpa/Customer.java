package dev.lpa;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    // positive transactions are credits
    // negative transactions are withdrawls

    protected Customer(String name, double initialDeposit) {
        this.name = name;
        this.transactions = new ArrayList<Double>(500);
        transactions.add(initialDeposit);
    }
    protected Customer(String name){
        this(name,0.00);
    }

    protected String getName() {
        return name;
    }

    protected ArrayList<Double> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return (name + ": " + transactions);
    }
}
