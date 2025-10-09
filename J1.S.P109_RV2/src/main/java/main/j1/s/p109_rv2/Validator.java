package main.j1.s.p109_rv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getStringInput(String msg) {
        System.out.print(msg);
        String input = "";
        try {
            input = SCANNER.nextLine().trim();
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
            input = "";
        }
        return input;
    }

    public static int getIntInput() {
        int result = 0;
        while (true) {
            try {
                result = SCANNER.nextInt();
                SCANNER.nextLine();
                return result;
            } catch (InputMismatchException e) {
                System.out.print("Input is invalid. Please enter a valid integer: ");
                SCANNER.next();
            }
        }
    }

    public static double getDoubleInput() {
        double result = 0.0;
        while (true) {
            try {
                result = SCANNER.nextDouble();
                SCANNER.nextLine();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Data input is invalid. Please enter a valid number (e.g., 4.0).");
                SCANNER.nextLine();
            }
        }
    }
}

