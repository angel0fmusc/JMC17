package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    /*
    * Implicitly static when used as an inner class, same for enums and interfaces.
    * Can access directly using the Main's class name if we want to create instances of it
    * from outside this class. */
    record Person(String firstName, String lastName){

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")
        ));

        // Using anonymous class
//        var comparatorLastName = new Comparator<Person>(){
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.lastName().compareTo(o2.lastName());
//            }
//        };

//        people.sort(comparatorLastName);

        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));
        System.out.println(people);

        /*
        * Not a functional interface because extending Comparator
        * causes the EnhancedComparator interface to inherit another abstract method.
        * Functional interfaces only have 1 abstract method.
        * */
        interface EnhancedComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);

    }
}
