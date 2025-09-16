// File: src/Display.java
package j1.s.p0050;

import java.util.List;

public class Display {
    private final Manager manager = new Manager();

    public void run() {
        while (true) {
            showMenu();
            int option = Input.getOption();
            switch (option) {
                case 1:
                    handleLinearEquation();
                    break;
                case 2:
                    handleQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
    }

    private void showMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }

    private void handleLinearEquation() {
        System.out.println("----- Calculate Superlative Equation -----");
        float a = Input.getFloat("Enter A: ");
        float b = Input.getFloat("Enter B: ");
        
        List<Float> solutions = manager.calculateEquation(a, b);
        
        printSolution(solutions);
        classifyNumbers(a, b);
    }
    
    private void handleQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = Input.getFloat("Enter A: ");
        float b = Input.getFloat("Enter B: ");
        float c = Input.getFloat("Enter C: ");

        List<Float> solutions = manager.calculateQuadraticEquation(a, b, c);
        
        printSolution(solutions);
        classifyNumbers(a, b, c);
    }

    private void printSolution(List<Float> solutions) {
        if (solutions == null) {
            System.out.println("Solution: No solution.");
        } else if (solutions.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions.");
        } else if (solutions.size() == 1) {
            System.out.printf("Solution: x = %.3f\n", solutions.get(0));
        } else {
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", solutions.get(0), solutions.get(1));
        }
    }

    private void classifyNumbers(float... numbers) {
        StringBuilder oddNums = new StringBuilder("Odd Number(s): ");
        StringBuilder evenNums = new StringBuilder("Even Number(s): ");
        StringBuilder perfectSquares = new StringBuilder("Perfect Square Number(s): ");

        for (float num : numbers) {
            if (Manager.isOdd(num)) {
                oddNums.append(String.format("%.1f, ", num));
            }
            if (Manager.isEven(num)) {
                evenNums.append(String.format("%.1f, ", num));
            }
            if (Manager.isPerfectSquare(num)) {
                perfectSquares.append(String.format("%.1f, ", num));
            }
        }

        // Remove trailing ", " if there are numbers
        if (oddNums.length() > 18) {
            oddNums.setLength(oddNums.length() - 2);
        }
        if (evenNums.length() > 17) {
            evenNums.setLength(evenNums.length() - 2);
        }
        if (perfectSquares.length() > 28) {
            perfectSquares.setLength(perfectSquares.length() - 2);
        }

        System.out.println(oddNums);
        System.out.println(evenNums);
        System.out.println(perfectSquares);
    }
}