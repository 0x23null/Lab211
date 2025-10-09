package main.j1.s.p0084;

import java.math.BigInteger;

public class Calculator {

    private BigInteger number1;
    private BigInteger number2;

    public Calculator(BigInteger number1, BigInteger number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public BigInteger add() {
        return this.number1.add(this.number2);
    }

    public BigInteger multiply() {
        return this.number1.multiply(this.number2);
    }

    public void setNumber1(BigInteger number1) {
        this.number1 = number1;
    }

    public void setNumber2(BigInteger number2) {
        this.number2 = number2;
    }
}