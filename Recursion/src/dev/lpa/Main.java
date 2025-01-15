package dev.lpa;

public class Main {
    public static void main(String[] args) {
        int factorialNumber = 5;
        System.out.printf("findFactorialRecursive(%d) = %d%n", factorialNumber,
                findFactorialRecursive(factorialNumber));

        System.out.printf("findFactorialIterative(%d) = %d", factorialNumber,
                findFactorialIterative(factorialNumber));
    }

    public static int findFactorialRecursive(int number){
        // Exit case, if number is 1, return 1
        if(number <= 1){
            return number;
        }
        // Recursive case, return the number * number-1
        return number * findFactorialRecursive(number-1);
    }

    public static int findFactorialIterative(int number){
        int result=number;

        for(int i = number-1; i > 0; i--){
            result *= i;
        }
        return result;
    }
}
