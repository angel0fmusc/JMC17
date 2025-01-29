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

        System.out.println("Bubble Sort: " + Arrays.toString(myBubbleSort(unsortedNumbers)));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(unsortedNumbers)));
        System.out.println("Insertion Sort with LinkedList: " + Arrays.toString(insertionSort(unsortedNumbers)));

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

    public static Integer[] selectionSort(Integer[] unsortedArray){
        Integer[] sortedNumbers = Arrays.copyOf(unsortedArray, unsortedArray.length);
        int smallestNo;
        int smallestNoIndex;

        for(int i = 0; i < sortedNumbers.length; i++){
            smallestNo = sortedNumbers[i];
            smallestNoIndex = i;
            for(int j = i+1; j < sortedNumbers.length; j++){
                if(sortedNumbers[j] < smallestNo){
                    smallestNo = sortedNumbers[j];
                    smallestNoIndex = j;
                }
            }
            sortedNumbers[smallestNoIndex] = sortedNumbers[i];
            sortedNumbers[i] = smallestNo;
        }

        return sortedNumbers;
    }

    /**
     * Insertion sort using LinkedList. Converts and Integer[] array into
     * a LinkedList of the same type. Traverses the LinkedList and
     * adds the current value to the beginning if the current value is less than the smallest sorted
     * number. Otherwise, traverse either up or down the sorted section based on the value
     * at the median index. ToDo: move the swapping mechanism to a separate method
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
            else if(sortedNums.get(i) >= sortedNums.getFirst() &&
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
}
