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

    public static double getNumBMI(String msg) {
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
                System.out.println("BMI is digit");
            }
        }
    }

    public static boolean isValidOperation(String input) {
        return input.matches("[+\\-*/^=]");
    }

    public static Operator getOperation(String msg) {
        while (true) {
            System.out.print(msg);
            String operationStr = sc.nextLine();
            if (!isValidOperation(operationStr)) {
                System.out.println("Invalid operator. Please try again.");
                continue;
            }
            return Operator.fromString(operationStr);
        }
    }
}