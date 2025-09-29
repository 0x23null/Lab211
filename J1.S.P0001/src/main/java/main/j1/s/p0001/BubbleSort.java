package main.j1.s.p0001;

import java.util.Random;

public class BubbleSort {

    public void sort() {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private int n;
    private int[] arr;

    public BubbleSort(int n) {
        this.n = n;
        this.arr = new int[n];
    }

    public void displayArray() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void randomizeArray() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n + 1);
        }
    }
}
