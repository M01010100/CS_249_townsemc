package edu.realemj.exercises10;
import edu.realemj.exercises09.Matrix;
public class Circle {
    private static final double DEFAULT_RADIUS = 1.0;
    private double radius = DEFAULT_RADIUS; // 1.0;
    private Matrix pos = Matrix.makePoint2D(0,0);

    public Circle() {
        this(DEFAULT_RADIUS, Matrix.makePoint2D(0,0));
    }

    public Circle(double r) {
        this(r, Matrix.makePoint2D(0,0));
        //radius = r;
        //setRadius(r);
    }

    public Circle(double r, Matrix c) {
        setRadius(r);
        setCenter(c);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        //if(r >= 0) {
        if(isValidRadius(radius)) {
            this.radius = radius;
        }
    }

    public static boolean isValidRadius(double r) {
        return (r >= 0);
    }

    public Matrix getCenter() {
        return new Matrix(pos);
    }

    public void setCenter(Matrix c) {
        pos = new Matrix(c);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        String s = "(Circle)\n";
        s += "r = " + radius + "\n";
        s += "center = \n";
        s += pos + "\n";
        return s;
    }

    public void judgeMyself() {
        judgeCircle(this);
    }

    public static void judgeCircle(Circle c) {
        if(c.getRadius() > 5.0) {
            System.out.println("BIG CIRCLE");
        }
        else {
            System.out.println("small circle");
        }
    }
}
