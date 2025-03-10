package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha","bravo", "charlie","delta"
        ));

        for(String s : list){
            System.out.println(s);
        }

        System.out.println("-------");
        list.forEach(myString -> System.out.println(myString));

        System.out.println("-------");
        String prefix = "nato";
        list.forEach(s -> {
             char first = s.charAt(0);
             System.out.println(prefix + " " + s + " means " + first);
        });

        int result = calculator((a,b) -> a+b, 5, 2);
        var result2 = calculator((a,b) -> a/b, 10.0, 2.5);
        var result3 = calculator(
                (a,b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph", "Kramden"
        );
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
