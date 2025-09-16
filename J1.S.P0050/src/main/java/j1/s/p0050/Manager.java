package j1.s.p0050;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    public List<Float> calculateEquation(float a, float b) {
        List<Float> res = new ArrayList<>();
        if (a == 0f) {
            if (b == 0f) {
                return res;
            } else {
                return null;
            }
        }
        res.add(-b / a);
        return res;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        if (a == 0f) {
            return calculateEquation(b, c);
        }

        float delta = b * b - 4f * a * c;
        if (delta < 0f) {
            return null;
        }
        if (delta == 0f) {
            List<Float> res = new ArrayList<>();
            res.add(-b / (2f * a));
            return res;
        }
        double sqrt = Math.sqrt(delta);
        float x1 = (float) ((-b - sqrt) / (2f * a));
        float x2 = (float) ((-b + sqrt) / (2f * a));
        List<Float> res = new ArrayList<>();
        if (x1 <= x2) {
            res.add(x1);
            res.add(x2);
        } else {
            res.add(x2);
            res.add(x1);
        }
        return res;
    }

    public static boolean isIntegerLike(float v) {
        if (!Float.isFinite(v)) {
            return false;
        }
        long r = Math.round(v);
        return Math.abs(v - r) < 1e-6;
    }

    public static boolean isEven(float v) {
        if (!isIntegerLike(v)) {
            return false;
        }
        long iv = Math.round(v);
        return iv % 2 == 0;
    }

    public static boolean isOdd(float v) {
        if (!isIntegerLike(v)) {
            return false;
        }
        long iv = Math.round(v);
        return iv % 2 != 0;
    }

    public static boolean isPerfectSquare(float v) {
        if (!isIntegerLike(v)) {
            return false;
        }
        long iv = Math.round(v);
        if (iv < 0) {
            return false;
        }
        long s = (long) Math.sqrt(iv);
        return s * s == iv;
    }
}
