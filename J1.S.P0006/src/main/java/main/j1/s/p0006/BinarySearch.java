package main.j1.s.p0006;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) { 
            array[i] = random.nextInt(size); 
        }
        return array;
    }

    
    public void sortArray(int[] array) {
        Arrays.sort(array);
    }

   
    public int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2; 

            if (array[mid] == value) {
                return mid; 
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; 
    }

    public void displayArray(int[] array) {
        System.out.println("Sorted array: " + Arrays.toString(array)); // Hiển thị mảng đã sắp xếp [cite: 21]
    }
}