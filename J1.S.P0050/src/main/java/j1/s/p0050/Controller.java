package j1.s.p0050;

import java.util.*;

public class Controller {

    private final Scanner sc = new Scanner(System.in);
    private final EquationSolver solver = new EquationSolver();

    public void run() {
        while (true) {
            printMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 1 ->
                    handleLinear();
                case 2 ->
                    handleQuadratic();
                case 3 -> {
                    return;
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("\nPlease choice one option: ");
    }

    private int readMenuChoice() {
        while (true) {
            String s = sc.nextLine().trim();
            if (s.matches("[1-3]")) {
                return Integer.parseInt(s);
            }
            System.out.print("Please choice 1-3: ");
        }
    }

    private float readFloat(String label) {
        while (true) {
            System.out.print(label);
            String s = sc.nextLine().trim();
            Float v = NumberUtil.parseFloatOrNull(s);
            if (v != null) {
                return v;
            }
            System.out.println("Please input number");
        }
    }

    private void handleLinear() {
        System.out.println("----- Calculate Equation -----");
        float a = readFloat("Enter A: ");
        float b = readFloat("Enter B: ");

        List<Float> roots = solver.calculateEquation(a, b);
        Formatter.printLinearSolution(roots);

        Formatter.printClassification(new float[]{a, b});
    }

    private void handleQuadratic() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = readFloat("Enter A: ");
        float b = readFloat("Enter B: ");
        float c = readFloat("Enter C: ");

        List<Float> roots = solver.calculateQuadraticEquation(a, b, c);
        Formatter.printQuadraticSolution(roots);

        Formatter.printClassification(new float[]{a, b, c});
    }
}
