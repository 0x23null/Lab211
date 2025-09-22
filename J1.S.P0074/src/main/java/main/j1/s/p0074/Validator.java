package main.j1.s.p0074;

import java.util.Scanner;

public class Validator {

    static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg) {
        int num;
        while (true) {
            System.out.print(msg);
            try {
                num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please enter again.");
            }
        }
    }
    
    public static double getNum(String msg) {
        double num;
        while (true) {
            System.out.print(msg);
            try {
                num = Double.parseDouble(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Please enter again.");
            }
        }
    }
    
    
}
