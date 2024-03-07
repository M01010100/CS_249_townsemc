package edu.realemj.exercises12;

import edu.realemj.exercises09.MathCompare;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        String s = "Rectangle: ";
        s += width + " x " + height;
        s += " --> " + super.toString();
        return s;
    }

    public double getArea() {
        return (width*height);
    }

    @Override
    public boolean equals(Object other) {
        boolean same = false;
        if(other instanceof Rectangle otherR) {
            if(     MathCompare.equalDoubles(width, otherR.width)
                    && MathCompare.equalDoubles(height, otherR.height)
                    && super.equals(otherR)) {

                same = true;
            }
        }
        return same;
    }
}
