package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String[] names = {"Eve", "Jeffrey", "Liam", "Violet", "Xaden", "Sloane", "Kelley", "Hannah"};
        System.out.println("Current list of names: " + Arrays.toString(names));



        // Using lambda expressions and the Arrays.setAll() method
        // Transform all names to uppercase
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("All uppercase lambda result: " + Arrays.toString(names));

        // Add a randomly generated middle initial and include a period
        Arrays.setAll(names,
                i -> names[i] + " " + randomMiddleInitial() + "."
        );
        Arrays.asList(names).forEach(s -> System.out.println(s));

        System.out.println("-".repeat(10));
        System.out.println("Add last name that is reverse of the first name\n");
        // Add a last name that is the reverse of the first name
        /*
        * Grab each element in the array, consisting of first name, space, and middle initial
        * Split the string based on spaces; will separate first name and middle initial
        * Reverse the string using StringBuilder.reverse()
        * Join the 3 Strings into 1 string and replace the element at the current index
        * with the newly joined String*/
        Arrays.setAll(names,
                i -> String.join(" ",
                        names[i],
                        new StringBuilder((names[i].split(" ")[0])).reverse().toString()));
        Arrays.asList(names).forEach(s -> System.out.println(s));

        System.out.println("-".repeat(10));
        System.out.println("Remove names where last name == first name\n");

        /*
        * Create a new modifiable ArrayList from the names array, removing any names where
        * the last name equals the first name. Use removeIf with a lambda expression
        * to perform this last operation.
        * - Need to split the String based on space delimiter
        * - Compare first name to last name*/
        ArrayList<String> namesArrayList = new ArrayList<>(List.of(names));
//        namesArrayList.forEach(s -> System.out.println(s));
        namesArrayList.removeIf(s -> (s.split(" "))[0].equals(s.split(" ")[2]));
        namesArrayList.forEach(name -> System.out.println(name));

    }

    /**
     * Using the Random class, generate a random integer and cast it to a
     * char. The bounds 65-90 are capital letters in ASCII. Type casting the integer
     * to a char will return the char of the integer. Then we return the char as a string
     * using the Character.toString() method.
     * @return a String of the character generated
     */
    public static String randomMiddleInitial(){
        Random rand = new Random();
        return Character.toString((char)(rand.nextInt(65,90)));
    }
}
