package main.j1.s.p0001;

public class J1SP0001 {

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort(Validator.getPositiveInt("Enter n: "));
        
        System.out.println("Before: ");
        bs.randomizeArray();
        bs.displayArray();

        System.out.println("Sorted: ");
        bs.sort();
        bs.displayArray();
    }
}
