package dev.lpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, int hireDate) {
    @Override
    public String toString() {
        return "%s %s %8d".formatted(firstName, lastName,hireDate);
    }
}

public class Main {
    public static void main(String[] args) {

        class EmployeeWrapper{
            private Employee employee;

            public EmployeeWrapper(Employee employee) {
                this.employee = employee;
            }

            public void getInformation(){
                System.out.println(employeeData(employee));
            }
        }

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Mark", "Clark", 1983),
                new Employee("Gerry", "Berry", 1991),
                new Employee("Felicia", "Day", 1995),
                new Employee("Ronald", "Seki", 1992)
        ));

//        var fullEmployeeList = createFullEmployeList(employees);
//        for(var employee : fullEmployeeList){
//            System.out.println(employee);
//        }

        var c1 = new Comparator<Employee>(){

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

        var c2 = new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.hireDate()-o2.hireDate();
            }
        };

        employees.sort(c1);
        for(var employee : employees){
            System.out.println(employee);
        }
        employees.sort(c2);
        System.out.println();
        for(var employee : employees){
            System.out.println(employee);
        }
    }

    public static String employeeData(Employee employee){
        return "Employee:\t %s %s %nYear started: %s%nYears worked: %d%n".formatted(
                employee.firstName(),
                employee.lastName(),
                employee.hireDate(),
                LocalDate.now().getYear() - employee.hireDate()
        );
    }

    public static List createFullEmployeList(List<Employee> list){

        class fullEmployee{
            private final String fullName;
            private final int yearsWorked;

            public fullEmployee(String firstName, String lastName, int hireDate) {
                this.fullName = firstName + " " + lastName;
                this.yearsWorked = LocalDate.now().getYear() - hireDate;
            }

            @Override
            public String toString() {
                return "%s has worked %d years in this company".formatted(fullName, yearsWorked);
            }
        }

        List<fullEmployee> newList = new ArrayList<>(list.size());

        for(var employee : list){
            newList.add(new fullEmployee(
                    employee.firstName(),
                    employee.lastName(),
                    employee.hireDate()));
        }

        return newList;
    }
}
