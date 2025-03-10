package dev.interview.algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        char[] letters = {'a','d','z','e','r','b'};
        Arrays.sort(letters);
//        System.out.println(Arrays.toString(letters));

        Integer[] unsortedNumbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.print("Original: ");
        System.out.println(Arrays.toString(unsortedNumbers));

//        System.out.println("Bubble Sort: " + Arrays.toString(myBubbleSort(unsortedNumbers)));
//        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(unsortedNumbers)));
//        System.out.println("Insertion Sort with LinkedList: " + Arrays.toString(insertionSort(unsortedNumbers)));

        mergeSort(unsortedNumbers);

    }

    public static Integer[] myBubbleSort(Integer[] unsortedArray){
        Integer[] sortedNumbers = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int maxIndex = sortedNumbers.length-2;
        for(int i = maxIndex; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                int num1 = sortedNumbers[j];
                int num2 = sortedNumbers[j+1];
                if(num1 > num2){
                    sortedNumbers[j+1] = num1;
                    sortedNumbers[j] = num2;
                }
            }
        }
        return sortedNumbers;
    }

    public static void videoBubbleSort(Integer[] arr){
        int length = arr.length;
        for(int i = 0; i < length-1; i++){
            for(int j = 0; j < length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * Selection Sort:
     * Sort an array by repeatedly selecting the smallest element
     * from the unsorted portion and swapping it with the first unsorted
     * element. Continue until the entire array is sorted.
     *
     * Big-O time complexity O(n^2)
     * Big-O space complexity O(1)
     * @param unsortedArray - an unsorted array of Integers
     * @return a sorted array of Integers
     */
    public static Integer[] selectionSort(Integer[] unsortedArray){
        Integer[] sortedNumbers = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int smallestNo;
        int smallestNoIndex;

        for(int i = 0; i < sortedNumbers.length; i++){ // O(n)
            // Capture the smallest number, which is assumed to be at the current index
            // and that index
            smallestNo = sortedNumbers[i];
            smallestNoIndex = i;
            /*
            * Loop through the remaining values of the array. If we come
            * across a value smaller than the currently recorded smallest number,
            * then record it as the new smallest number and that index.
            * Continue checking the remaining values in case we find another
            * value that is smaller.
            * */
            for(int j = i+1; j < sortedNumbers.length; j++){
                if(sortedNumbers[j] < smallestNo){
                    smallestNo = sortedNumbers[j];
                    smallestNoIndex = j;
                }
            }
            /*
            * Swap the smallest number found in the unsorted section of the array with the value
            * at index i. This effectively finds the smallest number in the unsorted section
            * and moves it to the correct spot in the sorted section.
            * */
            sortedNumbers[smallestNoIndex] = sortedNumbers[i];
            sortedNumbers[i] = smallestNo;
        }

        return sortedNumbers;
    }

    /**
     * Insertion sort using LinkedList. Also implements Merge sort kind of.
     * Converts and Integer[] array into a LinkedList of the same type.
     * Traverses the LinkedList and
     * adds the current value to the beginning if the current value is less than the smallest sorted
     * number. Otherwise, traverse either up or down the sorted section based on the value
     * at the median index.
     * ToDo: move the swapping mechanism to a separate method
     * Big-O time complexity is O(nlogn)
     * @param nums an unsorted Integer[] array
     * @return the sorted LinkedList as an Array
     */
    public static Integer[] insertionSort(Integer[] nums){
        /*
         * Convert the array to a LinkedList using Arrays.asList() and the LinkedList constructor.
         * Arrays.asList() creates a fixed-size list backed by the specified array,
         * and the LinkedList constructor then takes this list to initialize a new LinkedL ist.
         */
        var sortedNums = new LinkedList<>(Arrays.asList(nums));
        for(int i = 1; i < sortedNums.size(); i++){
            // If the current element is less than the first, move to the beginning
            if(sortedNums.get(i) <= sortedNums.getFirst()){
                sortedNums.addFirst(sortedNums.get(i));
                /* Everything shifts; need to remove
                * the item at i+1 because we now have
                * duplicates.
                */
                sortedNums.remove(i+1);
            }
            /* If the current element is greater than the first and less than
            * the mostly recently sorted element, need to find where it goes.
            * Traverse down the sorted elements until we find the right spot?
            */
            else if(sortedNums.get(i) > sortedNums.getFirst() &&
            sortedNums.get(i) <= sortedNums.get(i-1)){
                /* Get the median index.
                *  If sortedNums.get(i) < sortedNums.get(median)
                *  then traverse down the LinkedList from median to 1.
                *  Otherwise, traverse up the LinkedList from median to i-1.
                */
                int medianIndex = (1 + (i-1))/2;
                if(sortedNums.get(i) < sortedNums.get(medianIndex)){
                    for(int j = medianIndex; j >= 1; j--){
                        /* Check if current value is (sortedNums.get(i)) is greater than
                        * sortedNums.get(j), put the current value in sortedNums.get(j+1)
                        * */
                        if(sortedNums.get(i) >= sortedNums.get(j)){
                            sortedNums.add(j+1,sortedNums.get(i));
                            break;
                        }
                    }
                } else{
                    // Traverse up from the medianIndex to i-1
                    for(int j = medianIndex; j <= i-1; j++){
                        /* Check if the current value is less than sortedNums.get(j).
                        * If so, put the current value before sortedNums.get(j);
                        * sortedNums.get(j-1)
                        * */
                        if(sortedNums.get(i) <= sortedNums.get(j)){
                            sortedNums.add(j,sortedNums.get(i));
                            break;
                        }
                    }
                }
                sortedNums.remove(i+1);
            }
        }
        return sortedNums.toArray(new Integer[0]);
    }

    /**
     * Divide and conquer with recursion.
     * @param unsortedNums - Integer[]
     * @return - Integer[]
     */
    public static Integer[] mergeSort(Integer[] unsortedNums){
        // Exit case: if array only has 1 item in it, return
        // that array as it is already sorted.
        if(unsortedNums.length == 1){
            return unsortedNums;
        }
        /*
        * Need to find the median index so the array
        * can be divided into a left and right portion*/
        double lastIndex = unsortedNums.length-1;
        double medianIndex = lastIndex/2;

        return merge(
                mergeSort(Arrays.copyOfRange(unsortedNums, 0, (int)medianIndex)),
                mergeSort(Arrays.copyOfRange(unsortedNums,(int)medianIndex+1, (int)lastIndex))
        );
    }

    /**
     * Need to loop through the arrays and compare the numbers in them
     * Double pointers?
     * @param left - Integer[]
     * @param right - Integer[]
     * @return Integer[]
     */
    static Integer[] merge(Integer[] left, Integer[] right){
        Integer[] sortedNums = new Integer[(left.length + right.length)];
        System.out.println(left);
        System.out.println(right);
        return sortedNums;
    }
}
