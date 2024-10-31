public class Main {

    public static void main(String[] args) {

        SalariedEmployee bob = new SalariedEmployee("Bob", "11/30/1959", "01/31/2017", 127800);
        Employee tim = new Employee("Tim", "11/11/1985", "01/01/2020");

        System.out.println("Bob is " + bob.getAge());
        System.out.println("Bob's paycheck = $" + bob.collectPay());

        bob.retire();
        System.out.println("Bob's pension paycheck = $" + bob.collectPay());

    }
}
