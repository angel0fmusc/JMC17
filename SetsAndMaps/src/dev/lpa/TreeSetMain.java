package dev.lpa;

import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        /*
        * NavigableSet is an interface; it defines a contract for what a
        * collection can do, but does not implement how it is done.
        * So when Tim Bulchaka says:
        * "If I want the additional functionality of the SortedSet or NavigableSet,
        * then I need to declare my Set as one of these two types."
        *
        * He's saying:
        * "I want to use the methods provided by those interfaces,
        * so I’ll declare my variable using the NavigableSet interface,
        * and assign it an actual class that implements that interface,
        * like TreeSet."
        * */
//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("-".repeat(30));
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("-".repeat(30));
        System.out.printf("min=%s, first=%s %n", min.getName(), first.getName());
        System.out.printf("max=%s, last-%s %n", max.getName(), last.getName());
        System.out.println("-".repeat(30));

        // poll methods remove the elements from the first and last
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First Element = " + copiedSet.pollFirst());
        System.out.println("Last Element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-".repeat(30));

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for(Contact c : List.of(daffy, daisy, last, snoopy)){
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
            System.out.println("-".repeat(10));
        }
        System.out.println("-".repeat(30));

        for(Contact c : List.of(daffy, daisy, first, archie)){
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
            System.out.println("-".repeat(10));
        }
        System.out.println("-".repeat(30));
    }
}
