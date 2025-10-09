package main.j1.s.p0006;

public class J1SP0006 {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println("----BinarySearch----");

        int arraySize = Validator.getPositiveInt("Enter number of array: ");
        int arr[] = bs.generateRandomArray(arraySize);
        bs.sortArray(arr);
        bs.displayArray(arr);
        
        int searchValue = Validator.getPositiveInt("Enter search value: ");

        int index = bs.binarySearch(arr, searchValue);

        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println("Value not found");
        }
    }
}
