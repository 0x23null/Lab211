package j1.s.p0050;

import java.util.*;

public class Formatter {

    public static void printLinearSolution(List<Float> roots) {
        if (roots == null) {
            System.out.println("Solution: No solution");
        } else if (roots.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions");
        } else {
            System.out.printf("Solution: x = %s%n", toFixed(roots.get(0)));
        }
    }

    public static void printQuadraticSolution(List<Float> roots) {
        if (roots == null) {
            System.out.println("Solution: No solution");
        } else if (roots.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions");
        } else if (roots.size() == 2) {
            System.out.printf("Solution: x1 = %s and x2 = %s%n",
                    toFixed(roots.get(0)), toFixed(roots.get(1)));
        } else {
            System.out.printf("Solution: x = %s%n", toFixed(roots.get(0)));
        }
    }

    public static void printClassification(float[] coeffs) {
        StringBuilder odd = new StringBuilder();
        for (float v : coeffs) {
            if (NumberUtil.isOdd(v)) {
                odd.append(toFixed(v)).append(",  ");
            }
        }
        if (odd.length() > 0) {
            System.out.println("Odd Number(s):" + odd);
        }

        StringBuilder even = new StringBuilder();
        for (float v : coeffs) {
            if (NumberUtil.isEven(v)) {
                even.append(toFixed(v)).append(",  ");
            }
        }
        if (even.length() > 0) {
            System.out.println("Number is Even:" + even);
        }

        StringBuilder sq = new StringBuilder();
        for (float v : coeffs) {
            if (NumberUtil.isPerfectSquare(v)) {
                sq.append(toFixed(v)).append(",  ");
            }
        }
        if (sq.length() > 0) {
            System.out.println("Number is Perfect Square:" + sq);
        }
    }

    private static String toFixed(float x) {
        return String.format("%.3f", x);
    }
}
