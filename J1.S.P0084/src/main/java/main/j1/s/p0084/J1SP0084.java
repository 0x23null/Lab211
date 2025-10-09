package main.j1.s.p0084;

import java.math.BigInteger;
import java.util.Scanner;

public class J1SP0084 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----Calculator-----");

        try {
            System.out.print("Enter num 1: ");
            String numStr1 = scanner.nextLine();

            System.out.print("Enter num 2: ");
            String numStr2 = scanner.nextLine();
            
            BigInteger num1 = new BigInteger(numStr1);
            BigInteger num2 = new BigInteger(numStr2);

            Calculator calculator = new Calculator(num1, num2);

            BigInteger sum = calculator.add();
            BigInteger product = calculator.multiply();

            System.out.println("---------------------------------------");
            System.out.println("Result:");
            System.out.println("Sum: " + sum);
            System.out.println("Multy: " + product);
            System.out.println("---------------------------------------");

        } catch (NumberFormatException e) {
            System.err.println("Invalid input.");
        } finally {
            scanner.close();
        }
    }
    
}
