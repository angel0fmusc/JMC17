package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class PlainOld{

    private static int last_id = 1;
    private int id;

    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "Anna","Bob","Chuck","Dave"
        ));
        list.forEach(System.out::println);

        calculator(Integer::sum, 10, 25);

        Supplier<PlainOld> reference1 = PlainOld::new;

        /*Complex Method References video*/
        // Looks like a simple addition operation, but it is not because of the operation
        // on Strings
//        calculator((s1, s2) -> s1+s2, "Hello ", "World");

        /*
        * Using the concat method
        *
        * Method has 2 parameters: s1 and s2
        * The concat method is invoked on the first argument, s1, and the second
        * argument,s2, is passed to the concat method
        * */
        calculator((s1, s2) -> s1.concat(s2),"Hello ", "World");

        /*
        * Using the IntelliJ method reference
        * The method reference does the same as above implicity because it is
        * declared in the context of a two-parameter function method
        * */
        calculator(String::concat,"Hello ", "World");

        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        BiFunction<String,String,String> b2 = (s1, s2) -> s1.concat(s2); // need to declare 3 types for BiFunction
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello"));

        String result = "Hello".transform(u1);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){

        T result = function.apply(value1, value2);
        System.out.println("Result of the operation: " + result);
    }
}
