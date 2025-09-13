package j1.s.p0008;

import java.util.Scanner;

public class Inputter {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.err.println("Input cannot be empty. Please try again.");
            System.out.print("Enter again: ");
        }
    }
}
