package main.j1.s.p0051;

import java.util.Scanner;

public class Validator {

    static Scanner sc = new Scanner(System.in);

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

    public static double getNumBMI(String msg, String errMsg) {
        double num;
        while (true) {
            System.out.print(msg);
            try {
                num = Double.parseDouble(sc.nextLine());
                if (num <= 0) {
                    System.out.println("This number is invalid. Please enter again.");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public static boolean isValidOperation(String input) {
        return input.matches("[+\\-*/^=]");
    }

    public static String getOperation(String msg) {
        while (true) {
            System.out.print(msg);
            String operation = sc.nextLine();
            if (!isValidOperation(operation)) {
                System.out.println("Invalid operator. Please try again.");
                continue;
            }
            return operation;
        }
    }
}
