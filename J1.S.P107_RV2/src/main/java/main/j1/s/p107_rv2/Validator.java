package main.j1.s.p107_rv2;

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
}
