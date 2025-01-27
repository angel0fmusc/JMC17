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

    }
}
