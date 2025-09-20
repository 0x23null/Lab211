package j1.s.p0050;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    public static boolean isIntegerLike(float v) {
        if (!Float.isFinite(v)) {
            return false;
        }
        return Math.abs(v - Math.round(v)) < 1e-6;
    }

    public List<Float> calculateEquation(float a, float b) {
        List<Float> solutions = new ArrayList<>();
        if (a == 0) {
            if (b == 0) {
                return solutions;
            }
            return null;
        }
        solutions.add(-b / a);
        return solutions;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        if (a == 0) {
            return calculateEquation(b, c);
        }

        float delta = b * b - 4 * a * c;

        if (delta < 0) {
            return null;
        } else if (delta == 0) {
            List<Float> solutions = new ArrayList<>();
            solutions.add(-b / (2 * a));
            return solutions;
        } else {
            List<Float> solutions = new ArrayList<>();
            float sqrtDelta = (float) Math.sqrt(delta);
            float x1 = (-b + sqrtDelta) / (2 * a);
            float x2 = (-b - sqrtDelta) / (2 * a);
            
            if (x1 > x2) {
                solutions.add(x2);
                solutions.add(x1);
            } else {
                solutions.add(x1);
                solutions.add(x2);
            }
            return solutions;
        }
    }
    
    public static boolean isEven(float n) {
        if (!isIntegerLike(n)) return false;
        return Math.round(n) % 2 == 0;
    }

    public static boolean isOdd(float n) {
        if (!isIntegerLike(n)) return false;
        return Math.round(n) % 2 != 0;
    }

    public static boolean isPerfectSquare(float n) {
        if (!isIntegerLike(n) || n < 0) return false;
        long roundedN = Math.round(n);
        long sqrt = (long) Math.sqrt(roundedN);
        return sqrt * sqrt == roundedN;
    }
}