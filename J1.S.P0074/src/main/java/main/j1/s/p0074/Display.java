package main.j1.s.p0074;

public class Display {

    public int showMenu() {
        System.out.println("======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        return Validator.getInt("Your choice: ");
    }

    public void run() {
        int choice = 0;
        int rows, cols, rows2, cols2;

        while (true) {
            choice = showMenu();
            switch (choice) {
                case 1 -> {
                    System.out.println("-------- Addition --------");
                    rows = Validator.getInt("Enter Row Matrix 1: ");
                    cols = Validator.getInt("Enter Column Matrix 1: ");
                    Matrix matrix = new Matrix(rows, cols);
                    matrix.inputMatrix();

                    while (true) {
                        rows2 = Validator.getInt("Enter Row Matrix 2: ");
                        cols2 = Validator.getInt("Enter Column Matrix 2: ");
                        if (rows2 == rows && cols2 == cols) {
                            break;
                        } else {
                            System.out.println("Invalid matrix size. Please enter again.");
                        }
                    }

                    Matrix matrix2 = new Matrix(rows2, cols2);
                    matrix2.inputMatrix();

                    Matrix result = matrix.additionMatrix(matrix2);
                    displayResult(matrix, matrix2, result, "+");
                }
                case 2 -> {
                    System.out.println("-------- Subtraction --------");
                    rows = Validator.getInt("Enter Row Matrix 1: ");
                    cols = Validator.getInt("Enter Column Matrix 1: ");
                    Matrix matrix = new Matrix(rows, cols);
                    matrix.inputMatrix();

                    while (true) {
                        rows2 = Validator.getInt("Enter Row Matrix 2: ");
                        cols2 = Validator.getInt("Enter Column Matrix 2: ");
                        if (rows2 == rows && cols2 == cols) {
                            break;
                        } else {
                            System.out.println("Invalid matrix size. Please enter again.");
                        }
                    }
                    Matrix matrix2 = new Matrix(rows2, cols2);
                    matrix2.inputMatrix();

                    Matrix result = matrix.subtractMatrix(matrix2);
                    displayResult(matrix, matrix2, result, "-");
                }
                case 3 -> {
                    System.out.println("-------- Multiplication --------");
                    rows = Validator.getInt("Enter Row Matrix 1: ");
                    cols = Validator.getInt("Enter Column Matrix 1: ");
                    Matrix matrix = new Matrix(rows, cols);
                    matrix.inputMatrix();

                    while (true) {
                        rows2 = Validator.getInt("Enter Row Matrix 2: ");
                        cols2 = Validator.getInt("Enter Column Matrix 2: ");
                        if (cols == rows2) {
                            break;
                        } else {
                            System.out.println("Column of Matrix 1 must be equal to Row of Matrix 2. Please enter again.");
                        }
                    }

                    Matrix matrix2 = new Matrix(rows2, cols2);
                    matrix2.inputMatrix();

                    Matrix result = matrix.multiplicationMatrix(matrix2);
                    displayResult(matrix, matrix2, result, "*");
                }
                case 4 -> {
                    System.exit(0);
                }
            }
        }

    }

    public void displayResult(Matrix m1, Matrix m2, Matrix res, String operator) {
        System.out.println("-------- Result --------");
        m1.displayMatrix();
        System.out.println(operator);
        m2.displayMatrix();
        System.out.println("=");
        res.displayMatrix();
        System.out.println();
    }

    public Display() {
    }
}
