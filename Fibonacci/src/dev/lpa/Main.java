package dev.lpa;

public class Main {
    public static void main(String[] args) {
        int fibonacciIndex = 0;
        System.out.printf("fibonacciRecursive(%d) = %d%n",
                fibonacciIndex,
                fibonacciRecursive(fibonacciIndex));

        System.out.printf("fibonacciIterative(%d) = %d%n",
                fibonacciIndex,
                fibonacciIterative(fibonacciIndex));

    }

    /**
     * Given a number, N, return the index value of the Fibonacci sequence,
     * where the sequence is:
     *
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
     *
     * the pattern of the sequence is that each value is the sum of the 2 previous values,
     * that means that for N=5 → 2+3
     *
     * For example: fibonacciRecursive(6) should return 8
     * @param n: int
     */
    static int fibonacciIterative(int n){ // O(n)
        // Try counting up from index 1
        int maxArraySize = n+2;
        int[] arr = new int[maxArraySize];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i < n+1; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }

    static int fibonacciRecursive(int n){ // 0(2^n)
//        // Exit case: n <= 0, always will be 0
//        if(n <= 0){
//            return 0;
//        }
//
//        // Exit case: n > 0, but n <= 2, will always be 1
//        if(n <= 2){
//            return 1;
//        }

        if(n < 2){
            return n;
        }
        return fibonacciRecursive(n-2) + fibonacciRecursive(n-1);
    }
}
