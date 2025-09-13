package main.j1.s.p0010;

public class J1SP0010 {

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch(Validator.getPositiveInt("Enter array size (n > 0): "));
        
        ls.randomizeArray();
        
        ls.displayArray();
        
        int searchValue = Validator.getPositiveInt("Enter search value: ");
        
        int foundIndex = ls.search(searchValue);
        
        if (foundIndex >= 0) {
            System.out.println("Found " + searchValue + " at index: " + foundIndex);
        } else {
            System.out.println("Not found value " + searchValue + " in the array.");
        }
    }
}
