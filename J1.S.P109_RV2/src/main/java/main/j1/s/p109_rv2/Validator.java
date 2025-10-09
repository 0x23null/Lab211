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
            System.out.println("Data input is invalid");
        }
        return input;
    }

    public static int getIntInput() {
        while (true) {
            try {
                int v = SCANNER.nextInt();
                SCANNER.nextLine();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Data input is  invalid");
                SCANNER.nextLine();
                System.out.print("You choose: ");
            }
        }
    }

    public static int getIntInput(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int v = SCANNER.nextInt();
                SCANNER.nextLine();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Data input is  invalid");
                SCANNER.nextLine();
            }
        }
    }

    public static double getDoubleInput() {
        while (true) {
            try {
                double v = SCANNER.nextDouble();
                SCANNER.nextLine();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Data input is invalid. Please enter a valid number (e.g., 4.0).");
                SCANNER.nextLine();
            }
        }
    }
}
