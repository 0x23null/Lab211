package main.j1.s.p0051;

public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, POWER, EQUAL;

    public static Operator fromString(String op) {
        switch (op) {
            case "+":
                return ADD;
            case "-":
                return SUBTRACT;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            case "^":
                return POWER;
            case "=":
                return EQUAL;
            default:
                return null;
        }
    }
}