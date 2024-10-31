public class Main {
    public static void main(String[] args) {

//        Car car  = new Car();
//        car.setMake("Honda");
//        car.setModel("Model X");
//        car.setColor("Gray");
//        car.setDoors(2);
//        car.setConvertible(true);
//
//        car.describeCar();

//        BankAccount myAccount = new BankAccount(1523, 10000, "Victoria", "blah@gmail.com","555-555-5555");
//        BankAccount secondAccount = new BankAccount("Bob", "blah2@gmail.com","123-456-7890");
//        myAccount.setAccountBalance(10000);
//        myAccount.setAccountNumber(1523);
//        myAccount.setCustomerEmail("blah@gmail.com");
//        myAccount.setCustomerName("Victoria");
//        myAccount.setPhoneNumber("555-555-5555");

//        int depositAmount = 15;
//        myAccount.depositFunds(depositAmount);
//
//        myAccount.withdrawFunds(50000);
//        myAccount.withdrawFunds(1500);
//
//        System.out.println("Account number: " + secondAccount.getAccountNumber()+"; name: " + secondAccount.getCustomerName());

        Customer customer1 = new Customer();
        Customer customer2 = new Customer("Mary", "mary@email.com");
        Customer customer3 = new Customer("Randy", 18000.00, "randy@email.com");

        System.out.println(customer1.getName());
        System.out.println(customer1.getCreditLimit());
        System.out.println(customer1.getEmail());

        System.out.println(customer2.getName());
        System.out.println(customer2.getCreditLimit());
        System.out.println(customer2.getEmail());

        System.out.println(customer3.getName());
        System.out.println(customer3.getCreditLimit());
        System.out.println(customer3.getEmail());

    }
}
