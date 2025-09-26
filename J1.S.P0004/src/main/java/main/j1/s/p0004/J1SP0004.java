package main.j1.s.p0004;

public class J1SP0004 {

    public static void main(String[] args) {
        QuickSort qs = new QuickSort(Validator.getPositiveInt("Enter array length: "));
        qs.randomizeArray();
        
        qs.display("Unsorted array: ");
        
        qs.quickSort();
        qs.display("Sorted: ");
    }
}
