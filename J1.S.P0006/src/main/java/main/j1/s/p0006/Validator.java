package main.j1.s.p0006;

import java.util.Scanner;

public class Validator {

    static Scanner sc = new Scanner(System.in);
    
    public static int getPositiveInt(String msg) {
        System.out.print(msg);
        while(true)
            try {
                int size = Integer.parseInt(sc.nextLine());
                if (size < 1) {
                    System.out.print("Input must be a positive integer. Please enter again: ");
                    continue;
                }
                return size;
            } catch (NumberFormatException e) {
                System.out.print("Not a number. Please enter again: ");
            }
    }
}
