package main.j1.s.p0074;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;
    
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }
    
    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("[%.0f]", data[i][j]);
            }
            System.out.println();
        }
    }
    
    public Matrix additionMatrix(Matrix m2) {
        if (this.rows != m2.rows || this.cols != m2.cols) {
            throw new IllegalArgumentException("Invalid matrix dimension");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + m2.data[i][j];
            }
        }
        return result;
    }
    
    public Matrix subtractMatrix(Matrix m2) {
        if (this.rows != m2.rows || this.cols != m2.cols) {
            throw new IllegalArgumentException("Invalid matrix dimension");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - m2.data[i][j];
            }
        }
        return result;
    }
    
    public Matrix multiplicationMatrix(Matrix m2) {
        if (this.cols != m2.rows) {
            throw new IllegalArgumentException("Invalid rows, cols");
        }
        Matrix result = new Matrix(this.rows, m2.cols);
        
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * m2.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    void inputMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Validator.getNum("Enter matrix[" + i + "][" + j + "]: ");
            }
        }
    }
}
