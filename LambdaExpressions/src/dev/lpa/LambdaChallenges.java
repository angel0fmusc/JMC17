package dev.lpa;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaChallenges {
    public static void main(String[] args) {

        String myString = "This is my String and I am not sure what to do with it";

        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for(String part : parts){
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for(String part : parts){
                System.out.println(part);
            }
        };

        printWords.accept(myString);
        printWordsLambda.accept(myString);

        Consumer<String> printWordsForEachLambda = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        printWordsForEachLambda.accept(myString);

        Consumer<String> printWordsConcise = sentence ->
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));

        printWordsConcise.accept(myString);

        System.out.println("-".repeat(10));
        System.out.println("Mini Challenge 2\n");
        myString = "Now let's split this String up and return a String";

        UnaryOperator<String> everySecondChar = new UnaryOperator<String>() {
            @Override
            public String apply(String source) {
                StringBuilder returnVal = new StringBuilder();
                for(int i = 0; i < source.length(); i++){
                    if(i % 2 == 1){
                        returnVal.append(source.charAt(i));
                    }
                }
                return returnVal.toString();
            }
        };

        String resultString = everySecondChar.apply(myString);
        System.out.println("Initial Result: " + resultString);

        UnaryOperator<String> everySecondCharLambda = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String resultStringLambda = everySecondCharLambda.apply(myString);
        System.out.println("Lambda result: " + resultStringLambda);

        System.out.println("-".repeat(10));
        System.out.println("Mini Challenge 3\n");

        String numberString = "1234567890";
        System.out.println("Numbered String result: " + everySecondCharLambda.apply(numberString));

        System.out.println("-".repeat(10));
        System.out.println("Mini Challenge 4 and 5\n");
        System.out.println(everySecondCharacter(everySecondCharLambda, numberString));

        System.out.println("-".repeat(10));
        System.out.println("Mini Challenge 6\n");

//        Supplier<String> setString = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "I love Java";
//            }
//        };
//        String iLoveJava = setString.get();

        Supplier<String> iLoveJava = () -> "I love Java";
        System.out.println(iLoveJava.get());

        System.out.println("-".repeat(10));
        System.out.println("Mini Challenge 6\n");
        Supplier<String> supplierResult = () -> "I love Java";
        System.out.println("supplierResult = " + supplierResult.get());

    }

    public static String everySecondCharacter(UnaryOperator<String> function, String myString){
        return function.apply(myString);
    }
}
