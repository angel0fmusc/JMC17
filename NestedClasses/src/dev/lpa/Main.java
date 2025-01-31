package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)
        ));

        // type can be inferred when assigning a new
        // EmployeeComparator instance to it
//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee e : employees){
            System.out.println(e);
        }

        System.out.println("Store Members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019,"Walmart"),
                new StoreEmployee(10515, "Joe", 2021, "Target"),
                new StoreEmployee(10105, "Tom", 2020, "Macy's"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")
        ));

        /**
         * Complains because the inner class (StoreComparator) requires an instance of the
         * enclosing class (StoreEmployee) to be used in order to instantiate the inner class.
         * Here, we are calling the class StoreEmployee, and not an actual instance of the StoreEmployee
         * class
         */
//        var comparator = new StoreEmployee.StoreComparator<>();
        var genericEmployee = new StoreEmployee();
        var comparator = genericEmployee.new StoreComparator<>(); //creates an instance of an inner class
        storeEmployees.sort(comparator);

        for(StoreEmployee e : storeEmployees){
            System.out.println(e);
        }

        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);

    }

    /**
     * Enclosing code block can access local inner class's private fields even after the class declaration's closing
     * bracket
     * @param list
     */
    public static void addPigLatinName(List<? extends StoreEmployee> list){

        String lastName = "Piggy";

        // No modifiers. Will cause a compiler error if any are added
        // Can also extend other classes
        class DecoratedEmployee extends StoreEmployee
                implements Comparable<DecoratedEmployee>{

            private String pigLatinName;
            private Employee originalInstance;

            /*
            * When generating constructor, need to select the no-args constructor of StoreEmployee
            * in order to see the fields for this local inner class
            * */
            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for(var employee : list){
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }
        /*
        * Passing null to sort method on a list will use the Comparable's
        * compareTo method*/
        newList.sort(null);
        for(var dEmployee : newList){
            System.out.println(dEmployee.originalInstance.getName() + " " +
                    dEmployee.pigLatinName);
        }
    }
}
