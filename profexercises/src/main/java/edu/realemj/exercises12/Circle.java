package edu.realemj.exercises12;

import edu.realemj.exercises09.*;

public class Circle extends Shape {
    private static final double DEFAULT_RADIUS = 1.0;
    private double radius = DEFAULT_RADIUS; // 1.0;

    public Circle() {
        // Inserts: super() if this or super isn't present

        //this(DEFAULT_RADIUS, Matrix.makePoint2D(0,0));
    }

    public Circle(double r) {
        this(r, Matrix.makePoint2D(0,0));
    }

    public Circle(double r, Matrix c) {
        super(c);
        setRadius(r);
        //setCenter(c);
    }

    public Circle(double r, Matrix c, boolean filled) {
        super(c, filled);
        setRadius(r);

        //setCenter(c);
        //this.filled = filled;
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

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        String s = "Circle: ";
        s += "radius=" + radius;
        s += " --> " + super.toString();
        return s;
    }

    @Override
    public boolean equals(Object other) {
        boolean same = false;
        if(other instanceof Circle otherC) {
            if(MathCompare.equalDoubles(radius, otherC.radius)
                && super.equals(otherC)) {
                same = true;
            }
        }
        return same;
    }
}
