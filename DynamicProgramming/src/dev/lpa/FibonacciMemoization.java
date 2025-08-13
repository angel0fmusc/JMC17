package dev.lpa;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    private static Map<Integer, Integer> memo = new HashMap<>();
    private static int count = 0;

    public static int fibonacci(int n){
        if(n < 2){
            return n;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }
        // Store the result of calling fibonacci int the cache
        int result = fibonacci(n-1) + fibonacci(n-2);
        count++;
        memo.put(n, result);
        return result;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n) + " count = " + count);

    }
}
