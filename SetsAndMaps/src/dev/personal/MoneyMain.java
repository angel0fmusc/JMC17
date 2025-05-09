package dev.personal;

public class MoneyMain {

    public static void main(String[] args) {

        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");

        boolean balanced = income.equals(expenses);
        if(balanced){
            System.out.println("income equals expenses");
        } else{
            System.out.println("income does not equal expenses");
        }
    }
}
