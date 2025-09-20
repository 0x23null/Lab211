package main.j1.s.p0051;

import java.util.Scanner;

public class NormalCalculator {

    Scanner sc = new Scanner(System.in);

    public double run() {
        double memory = 0;
        double num = 0;
        String operation;

        memory = Validator.getNum("Enter number: ");
        do {
            operation = Validator.getOperation("Enter operation: ");
            if (operation.equalsIgnoreCase("=")) break;
            
            num = Validator.getNum("Enter number: ");
            switch (operation) {
                case "+":
                    memory += num;
                    System.out.println("Memory: " + memory);
                    break;
                case "-":
                    memory -= num;
                    System.out.println("Memory: " + memory);
                    break;
                case "*":
                    memory *= num;
                    System.out.println("Memory: " + memory);
                    break;
                case "/":
                    if (num == 0) {
                        System.out.println("Cannot divided by zero.");
                        continue;
                    }
                    memory /= num;
                    System.out.println("Memory: " + memory);
                    break;
            }

        } while (true);
        System.out.println("Result is: " + memory);
        return 0;
    }
}
