package main.j1.s.p0051;

public class NormalCalculator {

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    System.out.println("Cannot divided by zero.");
                    return Double.NaN;
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
            default:
                return 0;
        }
    }

    public void run() {
        double memory = 0;
        double num = 0;
        Operator operation;

        memory = Validator.getNum("Enter number: ");
        while (true) {
            operation = Validator.getOperation("Enter operation: ");
            if (operation == Operator.EQUAL) {
                break;
            }
            num = Validator.getNum("Enter number: ");
            memory = calculate(memory, operation, num);
            System.out.println("Memory: " + memory);
        }
        System.out.println("Result is: " + memory);
    }
}
