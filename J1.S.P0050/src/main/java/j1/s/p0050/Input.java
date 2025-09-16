// File: src/Input.java
package j1.s.p0050;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    // Prompt for a float and handle invalid input (Non-numeric values)
    public static float getFloat(String label) {
        while (true) {
            System.out.print(label);
            String input = SCANNER.nextLine().trim();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }
        }
    }

    // Prompt for an integer option and handle invalid input
    public static int getOption() {
        while (true) {
            System.out.print("Please choice one option: ");
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}