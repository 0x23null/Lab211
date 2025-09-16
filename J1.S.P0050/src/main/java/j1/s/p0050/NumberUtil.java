package j1.s.p0050;

public class NumberUtil {

    public static boolean checkIn(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOdd(float n) {
        return n % 2 != 0;
    }

    public static boolean isPerfectSquare(float n) {
        if (n < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
