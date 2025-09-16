package j1.s.p0050;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {
    private final Scanner sc;
    private final Manager manager;

    public Display() {
        this.sc = new Scanner(System.in);
        this.manager = new Manager();
    }

    public void run() {
        while (true) {
            showMenu();
            int opt = promptOption();
            switch (opt) {
                case 1:
                    handleLinear();
                    break;
                case 2:
                    handleQuadratic();
                    break;
                case 3:
                    System.out.println("Exitting");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void showMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }

    private int promptOption() {
        String s = sc.nextLine().trim();
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private float promptFloat(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            try {
                return Float.parseFloat(s);
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }
        }
    }

    private void handleLinear() {
        System.out.println("----- Calculate Equation -----");
        float a = promptFloat("Enter A: ");
        float b = promptFloat("Enter B: ");

        List<Float> solution = manager.calculateEquation(a, b);
        printLinearSolution(solution);

        List<Float> coeffs = new ArrayList<>();
        coeffs.add(a); coeffs.add(b);
        printClassification(coeffs);
        System.out.println(); // dòng trống
    }

    private void handleQuadratic() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = promptFloat("Enter A: ");
        float b = promptFloat("Enter B: ");
        float c = promptFloat("Enter C: ");

        List<Float> solution = manager.calculateQuadraticEquation(a, b, c);
        printQuadraticSolution(solution);

        List<Float> coeffs = new ArrayList<>();
        coeffs.add(a); coeffs.add(b); coeffs.add(c);
        printClassification(coeffs);
        System.out.println(); // dòng trống
    }

    private void printLinearSolution(List<Float> sol) {
        if (sol == null) {
            System.out.println("Solution: No solution");
        } else if (sol.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions");
        } else {
            System.out.printf("Solution: x = %s%n", fmt(sol.get(0)));
        }
    }

    private void printQuadraticSolution(List<Float> sol) {
        if (sol == null) {
            System.out.println("Solution: No solution");
        } else if (sol.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions");
        } else if (sol.size() == 1) {
            System.out.printf("Solution: x1 = %s and x2 = %s%n",
                    fmt(sol.get(0)), fmt(sol.get(0)));
        } else {
            System.out.printf("Solution: x1 = %s and x2 = %s%n",
                    fmt(sol.get(0)), fmt(sol.get(1)));
        }
    }

    private void printClassification(List<Float> coeffs) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        StringBuilder square = new StringBuilder();

        for (Float v : coeffs) {
            if (Manager.isOdd(v))   odd.append(fmt(v)).append(", ");
            if (Manager.isEven(v))  even.append(fmt(v)).append(", ");
            if (Manager.isPerfectSquare(v)) square.append(fmt(v)).append(", ");
        }

        // Bám sát format mẫu đề
        if (odd.length() > 0) {
            System.out.println("Odd Number(s):" + odd);
        } else {
            System.out.println("Odd Number(s):");
        }
        if (even.length() > 0) {
            System.out.println("Number is Even:" + even);
        } else {
            System.out.println("Number is Even:");
        }
        if (square.length() > 0) {
            System.out.println("Number is Perfect Square:" + square);
        } else {
            System.out.println("Number is Perfect Square:");
        }
    }

    private String fmt(float v) {
        if (Manager.isIntegerLike(v)) {
            return String.format("%.1f", v);
        }
        return Float.toString(v);
    }
}
