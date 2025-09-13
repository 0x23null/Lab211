package main.j1.s.p0010;

import java.util.Random;

public class LinearSearch {

    private int[] array;
    private int n;

    public LinearSearch(int n) {
        this.n = n;
        this.array = new int[n];
    }

    public void randomizeArray() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n + 1);
        }
    }

    public void displayArray() {
        System.out.print("The array: [");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
            if (i < n - 1) { 
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int search(int x) {
        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
