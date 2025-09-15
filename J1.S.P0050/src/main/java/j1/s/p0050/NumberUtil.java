package j1.s.p0050;

public class NumberUtil {

    private static final double EPS = 1e-6;

    public static Float parseFloatOrNull(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isIntegerLike(float v) {
        return Math.abs(v - Math.round(v)) < EPS;
    }

    public static boolean isEven(float v) {
        if (!isIntegerLike(v)) {
            return false;
        }
        long k = Math.round(v);
        return k % 2 == 0;
    }

    public static boolean isOdd(float v) {
        if (!isIntegerLike(v)) {
            return false;
        }
        long k = Math.round(v);
        return k % 2 != 0;
    }

    public static boolean isPerfectSquare(float v) {
        if (!isIntegerLike(v)) {
            return false;
        }
        long k = Math.round(v);
        if (k < 0) {
            return false;
        }
        long r = Math.round(Math.sqrt(k));
        return r * r == k;
    }
}
