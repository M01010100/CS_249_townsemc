package edu.realemj.exercises09;

public class MathCompare {
    public static final double EPS = 1e-10;

    public static boolean equalDoubles(double a, double b) {
        return equalDoubles(a, b, EPS);
    }

    public static boolean equalDoubles(double a, double b, double maxDiff) {
        return (Math.abs(a - b) <= maxDiff);
    }
}
