package main.j1.s.p0004;
import java.util.Random;

public class QuickSort {
    
    private int array[];
    private int n;
    
    public QuickSort(int n) {
        this.n = n;
        array = new int[n];
    }
    
    public void randomizeArray() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n + 1);
        }
    }
    
    public int partition(int arr[], int low, int high) {
        int i = low; 
        int j = high;
        int pivot = arr[(low + high) / 2];
        
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j--;
            }
        }
        return i;
    }
    
    public void sort(int arr[], int low, int high) {
        int index = partition(arr, low, high);
        
        if (low < index - 1) {
            sort(arr, low, index - 1);
        }
        if (index < high) {
            sort(arr, index, high);
        }
    }
    
    public void quickSort() {
        sort(this.array, 0, n - 1);
    }
    
    public void display(String message) {
        System.out.print(message);
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
            if (i < n - 1) { 
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}