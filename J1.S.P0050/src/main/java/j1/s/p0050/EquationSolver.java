package j1.s.p0050;

import java.util.*;

public class EquationSolver {

    public List<Float> calculateEquation(float a, float b) {
        final float EPS = 1e-7f;
        if (Math.abs(a) < EPS) {
            if (Math.abs(b) < EPS) {
                return Collections.emptyList(); // infinitely many solutions
            } else {
                return null; // no solution
            }
        }
        float x = -b / a;
        return Collections.singletonList(x);
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        final float EPS = 1e-7f;
        if (Math.abs(a) < EPS) {
            return calculateEquation(b, c);
        }

        float delta = b * b - 4 * a * c;
        if (delta < -EPS) {
            return null;
        } else if (Math.abs(delta) <= EPS) {
            float x = -b / (2 * a);
            return Arrays.asList(x, x);
        } else {
            float sqrt = (float) Math.sqrt(delta);
            float x1 = (-b + sqrt) / (2 * a);
            float x2 = (-b - sqrt) / (2 * a);
            return Arrays.asList(x1, x2);
        }
    }
}
