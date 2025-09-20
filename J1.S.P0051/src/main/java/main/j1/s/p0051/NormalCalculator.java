package main.j1.s.p0051;

import java.util.Scanner;

public class NormalCalculator {

    Scanner sc = new Scanner(System.in);
    //Validator validator = new Validator();

    public double run() {
        double memory = 0;
        double num = 0;
        String operation;

        do {
            memory = Validator.getNum("Enter number: ");
            operation = Validator.getOperation("Enter operation: ");
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
                    System.out.println("Memory: " + memory);
                    break;
            }

        } while (operation != "=");
        System.out.println("Result is: " + memory);
        return 0;
    }
}
